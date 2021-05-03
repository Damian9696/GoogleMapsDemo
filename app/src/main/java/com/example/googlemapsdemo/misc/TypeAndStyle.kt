package com.example.googlemapsdemo.misc

import android.content.Context
import android.util.Log
import android.view.MenuItem
import com.example.googlemapsdemo.R
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.MapStyleOptions
import java.lang.Exception

private const val TAG = "TypeAndStyle"

class TypeAndStyle {

    fun setMapStyle(googleMap: GoogleMap, context: Context) {
        try {
            val success = googleMap.setMapStyle(
                MapStyleOptions.loadRawResourceStyle(
                    context,
                    R.raw.map_style
                )
            )
            if (!success) {
                Log.d(TAG, "Failed to apply style.")
            }
        } catch (e: Exception) {
            Log.d(TAG, "setMapStyle: ${e.message.toString()}")
        }
    }

    fun setMapType(item: MenuItem, map: GoogleMap) {
        when (item.itemId) {
            R.id.normal_map -> map.mapType = GoogleMap.MAP_TYPE_NORMAL
            R.id.hybrid_map -> map.mapType = GoogleMap.MAP_TYPE_HYBRID
            R.id.satellite_map -> map.mapType = GoogleMap.MAP_TYPE_SATELLITE
            R.id.terrain_map -> map.mapType = GoogleMap.MAP_TYPE_TERRAIN
            R.id.none_map -> map.mapType = GoogleMap.MAP_TYPE_NONE
        }
    }

}