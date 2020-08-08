package com.app.redditui.ui.posts.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.app.redditui.R
import com.app.redditui.callback.PostsItemClickCallback
import com.app.redditui.model.DiffUtilRedditPostsModelChildren
import com.app.redditui.model.RedditPostsModel

/**
 * Adapter for inflating items to our ListView(RecyclerView)
 */
class PostsAdapter(private val postsItemClickCallback: PostsItemClickCallback): ListAdapter<RedditPostsModel.Data.Children, PostsAdapterViewHolder>(
    DiffUtilRedditPostsModelChildren()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsAdapterViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item_reddit_feed, parent, false)
        return PostsAdapterViewHolder(itemView = itemView)
    }

    override fun onBindViewHolder(holder: PostsAdapterViewHolder, position: Int) {
        val redditPostsModel = getItem(position)
        holder.bind(redditPostsModel, postsItemClickCallback)
    }
}