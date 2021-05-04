package com.example.googlemapsdemo.misc

import android.app.Activity
import android.content.Context
import android.view.View
import com.example.googlemapsdemo.databinding.CustomMarkerInfoLayoutBinding
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.Marker

class CustomWindowAdapter(context: Context) : GoogleMap.InfoWindowAdapter {

    private val inflater =
        (context as Activity).layoutInflater

    private val binding = CustomMarkerInfoLayoutBinding.inflate(inflater)

    override fun getInfoWindow(marker: Marker?): View {
        renderView(marker)
        return binding.root
    }

    override fun getInfoContents(marker: Marker?): View {
        renderView(marker)
        return binding.root
    }

    private fun renderView(marker: Marker?) {
        val title = marker?.title ?: ""
        val subtitle = marker?.snippet ?: ""

        binding.headerTextView.text = title
        binding.subtitleTextView.text = subtitle
    }
}