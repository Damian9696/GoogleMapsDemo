package com.example.googlemapsdemo

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.lifecycle.lifecycleScope
import com.example.googlemapsdemo.misc.*
import com.google.android.gms.maps.*

import com.google.android.gms.maps.model.*
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.lang.Exception

private const val TAG = "MapsActivity"

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private val googleplex = LatLng(37.422081535716444, -122.0840910386807)
    private val columbia = LatLng(3.455821127923707, -73.22468585007239)
    private val portugalia = LatLng(37.947391893928014, -8.372567250174345)
    private val poland = LatLng(52.86029781554506, 17.966512331809508)

    private lateinit var map: GoogleMap
    private val typeAndStyle by lazy { TypeAndStyle() }
    private val cameraAndViewPort by lazy { CameraAndViewPort() }
    private val customWindowAdapter by lazy { CustomWindowAdapter(this) }
    private val shapes by lazy { Shapes(map) }
    private val overlays by lazy { Overlays(map) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.map_type_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        typeAndStyle.setMapType(item, map)
        return super.onOptionsItemSelected(item)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap

        // Add a marker in Sydney and move the camera

        map.addMarker(
            MarkerOptions()
                .position(googleplex)
                .title("First Marker in Googleplex")
                .snippet("First Marker in Googleplex")
        )

        map.moveCamera(CameraUpdateFactory.newLatLngZoom(googleplex, 17f))
        map.uiSettings.apply {
            isZoomControlsEnabled = true
            isMyLocationButtonEnabled = true
        }

        map.setInfoWindowAdapter(customWindowAdapter)
        typeAndStyle.setMapStyle(googleMap, this)

        checkAccessFineLocationPermission()

    }

    private fun checkAccessFineLocationPermission() {
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            map.isMyLocationEnabled = true
            Toast.makeText(this, "location permission granted", Toast.LENGTH_SHORT).show()
        } else {
            requestAccessFineLocationPermission()
        }
    }

    private fun requestAccessFineLocationPermission() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 1
        )
    }

    @SuppressLint("MissingPermission")
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode != 1) {
            return
        }
        if (grantResults.isEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "location permission granted", Toast.LENGTH_SHORT).show()
            map.isMyLocationEnabled = true
        } else {
            Toast.makeText(this, "need location permission", Toast.LENGTH_SHORT).show()
        }
    }
}