package com.app.imageloading.utility

/**
 * Calculates available RAM(memory) for caching
 */
fun memoryCacheMaxSize(): Int {
    val availableMemory = Runtime.getRuntime().maxMemory() /1024
    return (availableMemory/2).toInt()
}

/**
 * Calculates available (LocalStore)memory for caching
 */
fun dataCacheMaxSize(): Long {
    return 50 * 1024 * 1024
}

/**
 * Checks for available thread pool size
 */
fun availableThreadPoolSize(): Int {
    return Runtime.getRuntime().availableProcessors()
}