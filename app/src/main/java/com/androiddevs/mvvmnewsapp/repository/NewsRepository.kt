package com.androiddevs.mvvmnewsapp.repository

import com.androiddevs.mvvmnewsapp.api.NewsAPI
import com.androiddevs.mvvmnewsapp.db.ArticleDatabase
import com.androiddevs.mvvmnewsapp.models.Article
import com.androiddevs.mvvmnewsapp.models.NewsResponse
import com.androiddevs.mvvmnewsapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject

class NewsRepository @Inject constructor(
    val db: ArticleDatabase,
    val api: NewsAPI
) {
    fun getBreakingNews(countryCode: String, pageNumber: Int)
//    : Response<NewsResponse>{
//        return api.getBreakingNews(countryCode, pageNumber)
//    }
    : Flow<Resource<NewsResponse>> = flow{
        try{
            emit(Resource.Loading())
            val response =  api.getBreakingNews(countryCode, pageNumber)
            emit(Resource.Success(response))
        } catch (e : HttpException) {
            emit(Resource.Error(e.message()))
        } catch (e : IOException) {
            emit(Resource.Error(e.message ?: "Some error occurred"))
        }
    }

    fun getSearchNews(searchQuery : String, pageNumber: Int): Flow<Resource<NewsResponse>> = flow{
        try {
            emit(Resource.Loading())
            val response = api.searchForNews(searchQuery, pageNumber)
            emit(Resource.Success(response))
        } catch (e : HttpException){
            emit(Resource.Error(e.message()))
        } catch (e : IOException){
            emit(Resource.Error(e.message ?: "Some error occurred"))
        }
    }

    suspend fun upsert(article: Article) = db.getArticleDao().upsert(article)

    suspend fun deleteArticle(article: Article) = db.getArticleDao().deleteArticle(article)

    fun getSavedNews() = db.getArticleDao().getAllArticles()
}