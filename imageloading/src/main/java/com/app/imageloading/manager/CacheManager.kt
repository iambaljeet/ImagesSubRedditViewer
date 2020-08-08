package com.app.imageloading.manager

import android.content.Context
import android.graphics.Bitmap
import com.app.imageloading.callback.ImageCache
import com.app.imageloading.diskcache.DiskCache
import com.app.imageloading.memorycache.MemoryCache

/**
 * Class for managing all caching operations at one place
 */
class CacheManager(context: Context):
    ImageCache {
    val diskCache = DiskCache(context)
    val memoryCache = MemoryCache()

    /**
     * Insert bitmap to both Memory and DiskCache
     */
    override fun put(url: String, bitmap: Bitmap) {
        memoryCache.put(url,bitmap)
        diskCache.put(url,bitmap)
    }

    /**
     * Get bitmap from cache
     * First it will check memory cache for required asset if not found than it will check DiskCache
     */
    override fun get(url: String): Bitmap? {
        return memoryCache.get(url)?:diskCache.get(url)
    }

    /**
     * Clears both memory and disk cache
     */
    override fun clear() {
        memoryCache.clear()
        diskCache.clear()
    }
}