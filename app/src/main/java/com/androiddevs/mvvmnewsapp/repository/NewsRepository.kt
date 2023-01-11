package com.androiddevs.mvvmnewsapp.repository

import com.androiddevs.mvvmnewsapp.api.NewsAPI
import com.androiddevs.mvvmnewsapp.db.ArticleDatabase
import com.androiddevs.mvvmnewsapp.models.Article
import javax.inject.Inject

class NewsRepository @Inject constructor(
    val db: ArticleDatabase,
    val api: NewsAPI
) {
    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        api.getBreakingNews(countryCode, pageNumber)

    suspend fun getSearchNews(searchQuery : String, pageNumber: Int) =
        api.searchForNews(searchQuery, pageNumber)

    suspend fun upsert(article: Article) = db.getArticleDao().upsert(article)

    suspend fun deleteArticle(article: Article) = db.getArticleDao().deleteArticle(article)

    fun getSavedNews() = db.getArticleDao().getAllArticles()
}