package com.ktoi.toi.view.interfaces

import com.ktoi.toi.model.NewsItem

interface NewsView {

    fun onNewsItemLoaded(newsItems: List<NewsItem>)

    fun onError(throwable: Throwable?)

    fun hideLoading()

}