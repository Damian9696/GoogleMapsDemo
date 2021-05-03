package com.example.googlemapsdemo.misc

import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng

class CameraAndViewPort {

    val googleplex =
        CameraPosition.Builder()
            .target(LatLng(37.422081535716444, -122.0840910386807))
            .zoom(18f)
            .bearing(300f)
            .tilt(45f)
            .build()
}