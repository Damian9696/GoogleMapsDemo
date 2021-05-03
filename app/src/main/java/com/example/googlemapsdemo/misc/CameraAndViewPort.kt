package com.example.googlemapsdemo.misc

import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds

class CameraAndViewPort {

    val googleplex =
        CameraPosition.Builder()
            .target(LatLng(37.422081535716444, -122.0840910386807))
            .zoom(18f)
            .bearing(300f)
            .tilt(45f)
            .build()

    val googleplexBounds = LatLngBounds(
        LatLng(37.421162527747384, -122.08657206936668),
        LatLng(37.423133354865485, -122.08121336977322)
    )
}