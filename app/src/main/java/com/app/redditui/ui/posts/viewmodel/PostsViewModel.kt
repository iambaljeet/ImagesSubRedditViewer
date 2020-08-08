package com.app.redditui.ui.posts.viewmodel

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.redditui.model.RedditPostsModel
import com.app.redditui.network.ResultData
import com.app.redditui.usecase.PostsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

private const val TAG = "PostsViewModel"

/**
 * ViewModel for managing business logic
 */
class PostsViewModel @ViewModelInject constructor(private val postsUseCase: PostsUseCase): ViewModel() {
    var postsData = MutableLiveData<ResultData<RedditPostsModel>>()

    fun getPosts() {
        Log.d(TAG, "getPosts postsRepository: $postsUseCase")
        viewModelScope.launch(Dispatchers.IO) {
            postsData.postValue(ResultData.Loading())
            postsData.postValue(postsUseCase.getPosts())
        }
    }
}