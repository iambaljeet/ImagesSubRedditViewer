package com.app.imageloading.loader

import android.os.Process
import java.util.concurrent.ThreadFactory

/**
 * Factory class for initializing thread
 */
class ImageThreadFactory : ThreadFactory {
    override fun newThread(runnable: Runnable): Thread {
        return Thread(runnable).apply {
            name = "ImageLoader Thread"
            priority = Process.THREAD_PRIORITY_BACKGROUND
        }
    }
}