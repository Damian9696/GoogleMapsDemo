package com.example.googlemapsdemo.misc

import android.graphics.Color
import com.example.googlemapsdemo.R
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.PolygonOptions
import com.google.android.gms.maps.model.PolylineOptions

private val googleplex = LatLng(37.422081535716444, -122.0840910386807)
private val columbia = LatLng(3.455821127923707, -73.22468585007239)
private val portugalia = LatLng(37.947391893928014, -8.372567250174345)
private val poland = LatLng(52.86029781554506, 17.966512331809508)

private val p0 = LatLng(37.42317505125657, -122.08633450900605)
private val p1 = LatLng(37.42312392819358, -122.08123831172675)
private val p2 = LatLng(37.420861697711246, -122.08123831172675)
private val p3 = LatLng(37.42114714298992, -122.08651153480629)

private val p4 = LatLng(37.42270642187261, -122.08491830260422)
private val p5 = LatLng(37.42248914725402, -122.08342162992957)
private val p6 = LatLng(37.42208441834229, -122.08337335016584)
private val p7 = LatLng(37.42214406274038, -122.0849773112043)


class Shapes(private val map: GoogleMap) {

    fun addPolyline() {
        map.addPolyline(
            PolylineOptions().apply {
                add(
                    googleplex,
                    columbia,
                    portugalia,
                    poland,
                    googleplex
                )
                width(5f)
                color(Color.RED)
                geodesic(true)
            }
        )
    }

    fun addPolygon() {
        map.addPolygon(
            PolygonOptions().apply {
                add(
                    p0, p1, p2, p3
                )
                fillColor(R.color.teal_200)
                strokeColor(R.color.purple_700)
                addHole(listOf(p4, p5, p6, p7))
            }
        )
    }

}