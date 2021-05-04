package com.example.googlemapsdemo

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
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.lifecycle.lifecycleScope
import com.example.googlemapsdemo.misc.CameraAndViewPort
import com.example.googlemapsdemo.misc.TypeAndStyle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.lang.Exception

private const val TAG = "MapsActivity"

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var map: GoogleMap
    private val typeAndStyle by lazy { TypeAndStyle() }
    private val cameraAndViewPort by lazy { CameraAndViewPort() }

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
        val googleplex = LatLng(37.422081535716444, -122.0840910386807)
        map.addMarker(
            MarkerOptions()
                .position(googleplex)
                .title("Marker in Googleplex")
                .icon(fromVectorToBitmap(R.drawable.ic_star, Color.parseColor("#FFFFFF")))
        )
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(googleplex, 10f))
        map.uiSettings.apply {
            isZoomControlsEnabled = true
        }
        typeAndStyle.setMapStyle(googleMap, this)
    }

    private fun fromVectorToBitmap(vectorId: Int, vectorColor: Int): BitmapDescriptor {
        val vectorDrawable: Drawable? = ResourcesCompat.getDrawable(resources, vectorId, null)
        return vectorDrawable?.let { drawable ->
            val bitmap = Bitmap.createBitmap(
                drawable.intrinsicWidth,
                drawable.intrinsicHeight,
                Bitmap.Config.ARGB_8888
            )
            val canvas = Canvas(bitmap)
            drawable.setBounds(0, 0, canvas.width, canvas.height)
            DrawableCompat.setTint(drawable, vectorColor)
            drawable.draw(canvas)
            BitmapDescriptorFactory.fromBitmap(bitmap)
        } ?: BitmapDescriptorFactory.defaultMarker()
    }
}