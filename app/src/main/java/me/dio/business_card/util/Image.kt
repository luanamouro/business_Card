package me.dio.business_card.util

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.view.View

class Image {
    fun share(context: Context, view: View){
        val bitmap = getScreenShotFromView(view)

        bitmap?.let{
            saveMediaToStorage()
        }
    }

    private fun getScreenShotFromView(card: View): Bitmap? {
        var screenshot: Bitmap? = null
        try{
            screenshot = Bitmap.createBitmap(
                card.measuredWidth,
                card.measuredHeight,
                Bitmap.Config.ARGB_8888
            )

            val canvas: Canvas(screenshot)
            card.draw(canvas)
        }catch (e: Exception){
            log.e("Error ->", "Falha ao capturar imagem.")
        }
    }
}