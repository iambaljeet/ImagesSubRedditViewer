package com.app.imageloading.diskcache

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.app.imageloading.callback.ImageCache
import com.app.imageloading.extensions.putCache
import com.app.imageloading.extensions.toMD5
import com.app.imageloading.utility.dataCacheMaxSize
import com.jakewharton.disklrucache.DiskLruCache

/**
 * Class for managing Disk based caching
 */
class DiskCache(private val context: Context):
    ImageCache {
    private var cacheDir = context.cacheDir
    private var diskLruCache: DiskLruCache = DiskLruCache.open(cacheDir, 1, 1, dataCacheMaxSize())

    /**
     * Put data to disk cache using URL as KEY and bitmap as VALUE
     */
    override fun put(key: String, bitmap: Bitmap) {
        val keyMD5 = key.toMD5()
        diskLruCache.putCache(key = keyMD5, bitmap = bitmap)
    }

    /**
     * get data(Bitmap) from disk cache using URL as KEY
     * Need to handle null value for empty bitmaps
     */
    override fun get(key: String): Bitmap? {
        val keyMD5 = key.toMD5()
        val snapshot: DiskLruCache.Snapshot? = diskLruCache.get(keyMD5)

        return if (snapshot != null) {
            val inputStream = snapshot.getInputStream(0).buffered(8 * 1024)
            BitmapFactory.decodeStream(inputStream)
        } else {
            null
        }
    }

    /**
     * Clear cache and reinitialize it for future use
     */
    override fun clear() {
        diskLruCache.delete()
        diskLruCache = DiskLruCache.open(context.cacheDir, 1, 1, dataCacheMaxSize())
    }
}