package com.app.redditui.ui.posts.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.app.redditui.R
import com.app.redditui.callback.PostsItemClickCallback
import com.app.redditui.extensions.loadImage
import com.app.redditui.model.RedditPostsModel
import kotlinx.android.synthetic.main.list_item_reddit_feed.view.*

class PostsAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    /**
     * Binds data and callback to UI elements
     */
    fun bind(redditPostsModel: RedditPostsModel.Data.Children?, postsItemClickCallback: PostsItemClickCallback) {
        val imageViewRedditPost = itemView.image_view_reddit_post
        val imageUrl = redditPostsModel?.data?.url_overridden_by_dest

        if (!imageUrl.isNullOrBlank()) {
            imageViewRedditPost?.loadImage(imageUrl = imageUrl, placeholder = R.drawable.image_placeholder)
        }

        imageViewRedditPost.setOnClickListener {
            postsItemClickCallback.onPostItemClicked(redditPostsModel = redditPostsModel, selectedPosition = adapterPosition)
        }
    }
}