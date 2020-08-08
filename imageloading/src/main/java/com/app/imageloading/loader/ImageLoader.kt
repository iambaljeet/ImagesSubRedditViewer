package com.app.imageloading.loader

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.app.imageloading.helper.DownloadImageTask
import com.app.imageloading.helper.DownloadTask
import com.app.imageloading.manager.CacheManager
import com.app.imageloading.utility.availableThreadPoolSize
import java.util.concurrent.Executors
import java.util.concurrent.Future

/**
 * Serve image to ImageView using caching first mechanism
 * It make a call to network to load image from RemoteUrl and loads it into memory
 */
class ImageLoader(context: Context) {
    private val cacheManager = CacheManager(context = context)
    private val executorService = Executors.newFixedThreadPool(availableThreadPoolSize(), ImageThreadFactory())
    private val downloadTaskList = hashMapOf<String, Future<Bitmap?>>()

    /**
     * Method for handling requests for loading images
     * Checks cache for bitmap otherwise starts Downloading abd caching task
     */
    fun loadImage(fileUrl: String, imageView: ImageView, placeHolder: Drawable?) {
        val bitmap = cacheManager.get(url = fileUrl)
        bitmap?.let {
            imageView.setImageBitmap(it)
            return
        } ?: run {
            imageView.tag = fileUrl
            if (placeHolder != null) imageView.setImageDrawable(placeHolder)
            addDownloadImageTask(fileUrl, DownloadImageTask(fileUrl, imageView, placeHolder, cacheManager))
        }
    }

    /**
     * Used to add image loading task to Map for future use
     * Also triggers image loading request
     */
    private fun addDownloadImageTask(url: String, downloadTask: DownloadTask<Bitmap?>) {
        downloadTaskList[url] = executorService.submit(downloadTask)
    }

    /**
     * Used to clear all caches
     */
    fun clearCache() {
        cacheManager.clear()
    }

    /**
     * Used to cancel any particular task using RemoteUrl
     */
    @Synchronized
    fun cancelTask(imageView: ImageView, fileUrl: String) {
        downloadTaskList.forEach { map ->
            downloadTaskList.remove(fileUrl)
            if (map.key == fileUrl &&  !map.value.isDone)
                map.value.cancel(true)
        }
    }

    /**
     * Used to cancel all existing image loading tasks
     */
    @Synchronized
    fun cancelAll() {
        downloadTaskList.forEach{
            if (!it.value.isDone)
                it.value.cancel(true)
        }
        downloadTaskList.clear()
    }

    companion object {
        private val imageLoader: ImageLoader? = null

        /**
         * Provides singleton instance of ImageLoader for loading images
         */
        @Synchronized
        fun getInstance(context: Context): ImageLoader {
            return imageLoader?.let { return it }
                ?: run {
                    return ImageLoader(context = context)
                }
        }
    }
}