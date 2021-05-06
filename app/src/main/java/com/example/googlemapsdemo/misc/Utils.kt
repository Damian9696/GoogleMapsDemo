package com.example.googlemapsdemo.misc

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.drawable.DrawableCompat
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds

class Utils(private val resources: Resources) {

    companion object {
        val googleplex = LatLng(37.422081535716444, -122.0840910386807)
        val columbia = LatLng(3.455821127923707, -73.22468585007239)
        val portugalia = LatLng(37.947391893928014, -8.372567250174345)
        val poland = LatLng(52.86029781554506, 17.966512331809508)

        val p0 = LatLng(37.42317505125657, -122.08633450900605)
        val p1 = LatLng(37.42312392819358, -122.08123831172675)
        val p2 = LatLng(37.420861697711246, -122.08123831172675)
        val p3 = LatLng(37.42114714298992, -122.08651153480629)

        val p4 = LatLng(37.42270642187261, -122.08491830260422)
        val p5 = LatLng(37.42248914725402, -122.08342162992957)
        val p6 = LatLng(37.42208441834229, -122.08337335016584)
        val p7 = LatLng(37.42214406274038, -122.0849773112043)

        val googleplexBounds = LatLngBounds(
            LatLng(37.421162527747384, -122.08657206936668),
            LatLng(37.423133354865485, -122.08121336977322)
        )
    }

    fun fromVectorToBitmap(vectorId: Int, vectorColor: Int): BitmapDescriptor {
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