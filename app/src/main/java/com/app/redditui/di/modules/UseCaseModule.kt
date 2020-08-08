package com.app.redditui.di.modules

import com.app.redditui.repository.PostsRepository
import com.app.redditui.usecase.PostsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
object UseCaseModule {
    @Provides
    fun providePostsUseCase(postsRepository: PostsRepository): PostsUseCase {
        return PostsUseCase(postsRepository)
    }
}