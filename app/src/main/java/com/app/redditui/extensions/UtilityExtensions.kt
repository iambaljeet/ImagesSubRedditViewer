package com.app.redditui.extensions

import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import com.app.imageloading.loader.ImageLoader

private const val TAG = "UtilityExtensions"

/**
 * Extension method for loading image using ImageLoader
 */
fun AppCompatImageView.loadImage(imageUrl: String?, placeHolder: Int? = null) {
    val imageLoader = ImageLoader.getInstance(context)
    imageUrl?.let { url -> imageLoader.loadImage(fileUrl = url, imageView = this, placeHolder = placeHolder?.let { it1 ->
        ContextCompat.getDrawable(context,
            it1
        )
    }) }
}