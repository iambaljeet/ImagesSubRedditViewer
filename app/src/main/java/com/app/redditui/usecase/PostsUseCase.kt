package com.app.redditui.usecase

import android.util.Log
import com.app.redditui.model.RedditPostsModel
import com.app.redditui.network.ResultData
import com.app.redditui.repository.PostsRepository
import javax.inject.Inject

private const val TAG = "PostsUseCase"

/**
 * Used to manage states of result of API call
 */
class PostsUseCase @Inject constructor(private val postsRepository: PostsRepository) {

    suspend fun getPosts(): ResultData<RedditPostsModel> {
        Log.d(TAG, "getPosts postsRepository: $postsRepository")
        return try {
            val redditPostsModel = postsRepository.getPosts()
            if (redditPostsModel.data != null) {
                ResultData.Success(redditPostsModel)
            } else {
                ResultData.Failed()
            }
        } catch (e: Exception) {
            e.printStackTrace()
            ResultData.Exception(exception = e)
        }
    }
}