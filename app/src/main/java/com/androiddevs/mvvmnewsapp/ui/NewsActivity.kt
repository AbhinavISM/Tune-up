package com.androiddevs.mvvmnewsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.androiddevs.mvvmnewsapp.R
import com.androiddevs.mvvmnewsapp.db.ArticleDatabase
import com.androiddevs.mvvmnewsapp.repository.NewsRepository
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_news.*

@AndroidEntryPoint
class NewsActivity : AppCompatActivity() {

//    lateinit var viewModel: NewsViewModel
//    val viewModel : NewsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        val newsRepository = NewsRepository(ArticleDatabase(this))
//        val viewModelProviderFactory = NewsViewModelProviderFactory(newsRepository)

//        viewModel = ViewModelProvider(this).get(NewsViewModel::class.java)
        setContentView(R.layout.activity_news)
        bottomNavigationView.setupWithNavController(newsNavHostFragment.findNavController())
    }
}
