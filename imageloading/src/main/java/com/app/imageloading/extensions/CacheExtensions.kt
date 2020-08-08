package com.app.imageloading.extensions

import android.graphics.Bitmap
import com.jakewharton.disklrucache.DiskLruCache
import java.io.BufferedOutputStream
import java.io.OutputStream
import java.math.BigInteger
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

/**
 * Used to put bitmap to DiskCache using RemoteUrl as key
 */
fun DiskLruCache.putCache(key: String, bitmap: Bitmap) {
    val edit = edit(key)
    if (edit.writeBitmapToDiskCache(bitmap)) {
        flush()
        edit.commit()
    } else {
        edit.commit()
    }
}

/**
 * Used to write bitmap to Disk cache
 */
fun DiskLruCache.Editor.writeBitmapToDiskCache(bitmap: Bitmap): Boolean {
    var out: OutputStream? = null
    try {
        out = BufferedOutputStream(newOutputStream(0), 8 * 1024)
        return bitmap.compress(Bitmap.CompressFormat.PNG, 100, out)
    } finally {
        out?.close()
    }
}

/**
 * Converts a String to MD5
 */
fun String.toMD5(): String {
    try {
        val md = MessageDigest.getInstance("MD5")
        val messageDigest = md.digest(toByteArray())
        val no = BigInteger(1, messageDigest)
        var hashtext = no.toString(16)
        while (hashtext.length < 32) {
            hashtext = "0$hashtext"
        }
        return hashtext
    } catch (e: NoSuchAlgorithmException) {
        throw RuntimeException(e)
    }
}

/**
 * Used to calculate sizes for resizing bitmaps
 */
fun Bitmap.calculateNewSize(viewWidth: Int, viewHeight: Int, size: (width: Int, height: Int) -> Unit) {
    val width = width
    val height = height

    if (width > height) {
        val imageRatio = width / height

        val newWidth = viewWidth
        val newHeight = newWidth * imageRatio

        size(newWidth, newHeight)
    } else {
        val imageRatio = height / width

        val newHeight = viewHeight
        val newWidth = newHeight * imageRatio

        size(newWidth, newHeight)
    }
}

/**
 * Used to resize bitmaps
 */
fun Bitmap.scaleBitmap(viewWidth: Int, viewHeight: Int) : Bitmap {
    var scaledBitmap = this
    if (width > viewWidth || height > viewHeight) {
        calculateNewSize(viewWidth = viewWidth, viewHeight = viewHeight) { width, height ->
            scaledBitmap = Bitmap.createScaledBitmap(this, width, height, false)
        }
    }
    return scaledBitmap
}