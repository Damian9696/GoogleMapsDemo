package com.example.googlemapsdemo.misc

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.drawable.DrawableCompat
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory

class CustomPin(private val resources: Resources) {

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