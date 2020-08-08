package com.app.redditui.network

import com.app.redditui.model.RedditPostsModel
import retrofit2.http.GET

/**
 * Used to define all our network requests at one place
 */
interface ApiService {
    @GET(NetworkingConstants.URL_POSTS)
    suspend fun getPosts(): RedditPostsModel
}