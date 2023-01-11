package com.androiddevs.mvvmnewsapp

import com.androiddevs.mvvmnewsapp.adapters.NewsAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.scopes.FragmentScoped

@InstallIn(FragmentComponent::class)
@Module
class AdapterModule {

    @FragmentScoped
    @Provides
    fun provideAdapter() : NewsAdapter{
        return NewsAdapter()
    }
}