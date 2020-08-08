package com.app.imageloading.helper

import java.util.concurrent.Callable

abstract class DownloadTask<T>: Callable<T> {
    abstract fun download(url: String): T
}