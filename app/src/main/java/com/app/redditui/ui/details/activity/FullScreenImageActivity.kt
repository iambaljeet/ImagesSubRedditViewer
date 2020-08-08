package com.app.redditui.ui.details.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.app.redditui.R
import com.app.redditui.extensions.loadImage
import com.app.redditui.helper.Constants
import kotlinx.android.synthetic.main.fullscreen_image_activity.*

/**
 * Used to show a fullscreen image as per user selection from the list of iamges
 */
class FullScreenImageActivity : AppCompatActivity(), View.OnClickListener {
    private var imageUrl: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fullscreen_image_activity)

        imageUrl = intent.extras?.getString(Constants.IMAGE_URL)
        if (imageUrl.isNullOrBlank()) throw Exception("ImageUrl should not be null")

        image_view_back?.setOnClickListener(this)
        image_view_main?.loadImage(imageUrl = imageUrl, placeholder = R.drawable.image_placeholder)
    }

    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.image_view_back -> {
                finish()
            }
        }
    }

    companion object {
        /**
         * Method to launch this activity using a single method call
         */
        fun launch(context: Context, imageUrl: String?) {
            val intent = Intent(context, FullScreenImageActivity::class.java)
            intent.putExtra(Constants.IMAGE_URL, imageUrl)
            context.startActivity(intent)
        }
    }
}