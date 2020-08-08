package com.app.redditui.ui.posts.activity

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.app.imageloading.loader.ImageLoader
import com.app.redditui.R
import com.app.redditui.callback.PostsItemClickCallback
import com.app.redditui.model.RedditPostsModel
import com.app.redditui.network.ResultData
import com.app.redditui.ui.details.activity.FullScreenImageActivity
import com.app.redditui.ui.posts.adapter.PostsAdapter
import com.app.redditui.ui.posts.viewmodel.PostsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_posts.*

@AndroidEntryPoint
class PostsActivity : AppCompatActivity(), PostsItemClickCallback {
    private val postsViewModel: PostsViewModel by viewModels()
    private var postsAdapter: PostsAdapter? = null

    /**
     * Observer for observing data state changes due to API
     */
    private val postsDataObserver = Observer<ResultData<RedditPostsModel>> { resultData ->
        when(resultData) {
            is ResultData.Loading -> {
                setLoading()
            }
            is ResultData.Success -> {
                setData(resultData)
            }
            is ResultData.Failed -> {
                setFailed()
            }
            is ResultData.Exception -> {
                setFailed()
            }
        }
    }

    /**
     * Shows a loader till API call is made
     */
    private fun setLoading() {
        progress_bar_loader.isVisible = true
        recycler_view_posts.isVisible = false
    }

    /**
     * Sets data to UI after a success state from API result
     */
    private fun setData(resultData: ResultData.Success<RedditPostsModel>) {
        val children = resultData.data?.data?.children
        progress_bar_loader.isVisible = false
        if (!children.isNullOrEmpty()) {
            recycler_view_posts.isVisible = true
            postsAdapter?.submitList(children)
        } else {
            recycler_view_posts.isVisible = false
        }
    }

    /**
     * Hides the loader and inform user about API failure
     */
    private fun setFailed() {
        progress_bar_loader.isVisible = false
        recycler_view_posts.isVisible = false
        Toast.makeText(this, getString(R.string.something_went_wrong), Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_posts)

        postsAdapter = PostsAdapter(this)
        recycler_view_posts.adapter = postsAdapter

        getDataAndSubscribeEvents()
    }

    /**
     * Calls API request and start observing for state changes of API result
     */
    private fun getDataAndSubscribeEvents() {
        postsViewModel.postsData.observe(this, postsDataObserver)
        postsViewModel.getPosts()
    }

    /**
     * Handles result when user selects any image(POST) from list of images(Posts)
     * and handles the opening of new Activity
     */
    override fun onPostItemClicked(redditPostsModel: RedditPostsModel.Data.Children?, selectedPosition: Int) {
        val urlOverriddenByDest = redditPostsModel?.data?.url_overridden_by_dest
        if (!urlOverriddenByDest.isNullOrBlank()) {
            FullScreenImageActivity.launch(this, urlOverriddenByDest)
        }
    }

    /**
     * We clear our memory and triggers a cancellation signal for all ongoing image loading requests
     * can also be managed using LifecycleCallbacks
     */
    override fun onDestroy() {
        ImageLoader.getInstance(this).cancelAll()
        super.onDestroy()
    }
}