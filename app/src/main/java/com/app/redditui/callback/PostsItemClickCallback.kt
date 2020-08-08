package com.app.redditui.callback

import com.app.redditui.model.RedditPostsModel

interface PostsItemClickCallback {
    fun onPostItemClicked(redditPostsModel: RedditPostsModel.Data.Children?, selectedPosition: Int)
}