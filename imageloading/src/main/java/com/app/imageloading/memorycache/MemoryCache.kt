package com.app.imageloading.memorycache

import android.graphics.Bitmap
import androidx.collection.LruCache
import com.app.imageloading.callback.ImageCache
import com.app.imageloading.utility.memoryCacheMaxSize

/**
 * Class used to manage in-memory caching using LruCache
 */
class MemoryCache: ImageCache {

    /**
     * Initializing default cache with available size
     */
    private val cache: LruCache<String, Bitmap> = object: LruCache<String, Bitmap>(memoryCacheMaxSize()) {
        override fun sizeOf(key: String, value: Bitmap): Int {
            return value.byteCount / 1024
        }
    }

    /**
     * Puts bitmap to cache using RemoteUrl as KEY
     */
    override fun put(key: String, bitmap: Bitmap) {
        cache.put(key, bitmap)
    }

    /**
     * Gets bitmap from cache using RemoteUrl as KEY
     */
    override fun get(key: String): Bitmap? {
        return cache.get(key)
    }

    /**
     * Clear all memory cache
     */
    override fun clear() {
        cache.evictAll()
    }
}