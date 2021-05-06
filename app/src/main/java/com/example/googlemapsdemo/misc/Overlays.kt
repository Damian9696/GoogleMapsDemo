package com.example.googlemapsdemo.misc

import android.content.res.Resources
import android.graphics.Color
import com.example.googlemapsdemo.R
import com.example.googlemapsdemo.misc.Utils.Companion.googleplex
import com.example.googlemapsdemo.misc.Utils.Companion.googleplexBounds
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.GroundOverlayOptions

class Overlays(private val map: GoogleMap) {

    fun addGroundOverlay(resources: Resources) {
        val utils = Utils(resources)
        val groundOverlay = map.addGroundOverlay(
            GroundOverlayOptions().apply {
//                position(googleplex, 1000f)
                positionFromBounds(googleplexBounds)
                image(utils.fromVectorToBitmap(R.drawable.ic_star, Color.parseColor("#FFFFFF")))
                transparency(0.5f)

            }
        )
        groundOverlay.tag = "Sample groundOverlay tag"
    }
}