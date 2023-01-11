package com.androiddevs.mvvmnewsapp

import android.content.Context
import androidx.room.Room
import com.androiddevs.mvvmnewsapp.db.ArticleDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RoomModule {

    @Singleton
    @Provides
    fun provideRoomdb(@ApplicationContext context: Context) : ArticleDatabase {
        return Room.databaseBuilder(
            context,
            ArticleDatabase::class.java,
            "article_db.db"
        ).fallbackToDestructiveMigration()
            .build()
    }
}