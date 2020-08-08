package com.app.imageloading.callback

import android.graphics.Bitmap

/**
 * Callbacks containing appropriate methods for caching data
 */
interface ImageCache {
    fun put(key: String, bitmap: Bitmap)
    fun get(key: String): Bitmap?
    fun clear()
}