package com.ktoi.toi.shared

import com.ktoi.toi.presenter.NewsPresenter
import javax.inject.Singleton

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rx.schedulers.Schedulers


/**
 * Created by polyakov on 29.10.16.
 */
@Module
class NewsModule {

    @Provides
    @Singleton
    fun provideNewsPresenter(): NewsPresenter {
        return NewsPresenter()
    }

    @Provides
    @Singleton
    internal fun provideNewApiInterface(): NewsApiInterface {
        val retrofit = Retrofit.Builder()
                .baseUrl(Constants.NEWS_ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build()
        return retrofit.create(NewsApiInterface::class.java)
    }
}