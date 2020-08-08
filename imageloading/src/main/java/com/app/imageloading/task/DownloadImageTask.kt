package com.app.imageloading.helper

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.Drawable
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.ImageView
import com.app.imageloading.extensions.scaleBitmap
import com.app.imageloading.manager.CacheManager
import java.net.HttpURLConnection
import java.net.URL

/**
 * Class for for loading of images as Bitmaps and caching them accordingly
 */
private const val TAG = "DownloadImageTask"
class DownloadImageTask(private val fileUrl: String,
                        private val imageView: ImageView,
                        private val placeholder: Drawable?,
                        private val cacheManager: CacheManager): DownloadTask<Bitmap?>() {
    private val uiHandler = Handler(Looper.getMainLooper())

    /**
     * Load image from provided URL and returns Bitmap for the same
     */
    override fun download(url: String): Bitmap? {
        var bitmap: Bitmap? = null
        try {
            val conn: HttpURLConnection = URL(url).openConnection() as HttpURLConnection
            bitmap = BitmapFactory.decodeStream(conn.inputStream)
            Log.d(TAG, "download: url: $url bitmap: $bitmap")
            conn.disconnect()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return bitmap
    }

    /**
     * Used to make a call to start downloading image from RemoteUrl
     * After getting bitmap it will load it into cache(Disk and memory both)
     * Also it will set the bitmap to provided ImageView
     */
    override fun call(): Bitmap? {
        Log.d(TAG, "call: fileUrl: $fileUrl")
        val bitmap = download(fileUrl)
        if (bitmap != null) {
            if (imageView.tag == fileUrl) {
                updateImageView(imageView, bitmap)
            }
            cacheManager.put(fileUrl, bitmap)
        } else {
            placeholder?.let { imageView.setImageDrawable(it) }
        }
        return bitmap
    }

    /**
     * Resizes the bitmap to small dimension and set to ImageView accordingly
     */
    private fun updateImageView(imageView: ImageView, bitmap: Bitmap) {
        val scaleBitmap = bitmap.scaleBitmap(600, 600)
        uiHandler.post {
            imageView.setImageBitmap(scaleBitmap)
        }
    }
}