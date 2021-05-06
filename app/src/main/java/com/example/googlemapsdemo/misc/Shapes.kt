package com.example.googlemapsdemo.misc

import android.graphics.Color
import com.example.googlemapsdemo.R
import com.example.googlemapsdemo.misc.Utils.Companion.columbia
import com.example.googlemapsdemo.misc.Utils.Companion.googleplex
import com.example.googlemapsdemo.misc.Utils.Companion.p0
import com.example.googlemapsdemo.misc.Utils.Companion.p1
import com.example.googlemapsdemo.misc.Utils.Companion.p2
import com.example.googlemapsdemo.misc.Utils.Companion.p3
import com.example.googlemapsdemo.misc.Utils.Companion.p4
import com.example.googlemapsdemo.misc.Utils.Companion.p5
import com.example.googlemapsdemo.misc.Utils.Companion.p6
import com.example.googlemapsdemo.misc.Utils.Companion.p7
import com.example.googlemapsdemo.misc.Utils.Companion.poland
import com.example.googlemapsdemo.misc.Utils.Companion.portugalia
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.*

class Shapes(private val map: GoogleMap) {

    fun addPolyline() {

//        val pattern = listOf(Dot(), Gap(20f), Dash(20f), Gap(20f),)

        map.addPolyline(
            PolylineOptions().apply {
                add(
                    googleplex,
                    columbia,
                    portugalia,
                    poland,
                    googleplex
                )
                width(120f)
                color(Color.RED)
                geodesic(true)
//                pattern(pattern)
                jointType(JointType.ROUND)
                startCap(RoundCap())
                endCap(RoundCap())
            }
        )
    }

    fun addPolygon() {
        map.addPolygon(
            PolygonOptions().apply {
                val add = add(
                    p0, p1, p2, p3
                )
                fillColor(R.color.teal_200)
                strokeColor(R.color.purple_700)
                addHole(listOf(p4, p5, p6, p7))
            }
        )
    }

    fun addCircle() {
        map.addCircle(
            CircleOptions().apply {
                center(googleplex)
                radius(50.0)
                fillColor(R.color.purple_500)
            }
        )
    }

}