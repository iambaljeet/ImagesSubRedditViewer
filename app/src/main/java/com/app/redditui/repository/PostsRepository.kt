package com.app.redditui.repository

import com.app.redditui.model.RedditPostsModel
import com.app.redditui.network.ApiService
import javax.inject.Inject

private const val TAG = "PostsRepository"

/**
 * Repository class used just for calling API
 * Build to easily change API in future without touching entire flow
 */
class PostsRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getPosts(): RedditPostsModel {
        return apiService.getPosts()
    }
}