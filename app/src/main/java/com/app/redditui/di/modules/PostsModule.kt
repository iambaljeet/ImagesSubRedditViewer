package com.app.redditui.di.modules

import com.app.redditui.network.ApiService
import com.app.redditui.repository.PostsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
object PostsModule {
    @Provides
    fun provideRepository(apiService: ApiService): PostsRepository {
        return PostsRepository(apiService)
    }
}