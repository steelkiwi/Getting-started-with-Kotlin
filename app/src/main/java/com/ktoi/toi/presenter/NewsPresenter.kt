package com.ktoi.toi.presenter

import com.ktoi.toi.model.NewsItem
import com.ktoi.toi.shared.NewsApiInterface
import com.ktoi.toi.view.interfaces.NewsView
import io.realm.Realm
import rx.Observable
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers


/**
 * @author polyakov
 * 09.11.16.
 */
class NewsPresenter {

    private var mNewsApiInterface: NewsApiInterface? = null
    private var mNewsView: NewsView? = null

    private var subscription: Subscription? = null

    fun onViewCreated(view: NewsView) {
        mNewsView = view
    }

    fun setNewsApiInterface(newsApiInterface: NewsApiInterface) {
        this.mNewsApiInterface = newsApiInterface
    }

    fun loadNews() {
        subscription = mNewsApiInterface!!
                .getNews()
                .map { it.newsItem }
                .flatMap({ items ->
                    Realm.getDefaultInstance().executeTransaction({ realm ->
                        realm.delete(NewsItem::class.java)
                        realm.insert(items)
                    })
                    Observable.just(items)
                })
                .onErrorResumeNext { throwable ->
                    val realm = Realm.getDefaultInstance()
                    val items = realm.where(NewsItem::class.java).findAll()
                    Observable.just(realm.copyFromRealm(items))
                }
                .observeOn(AndroidSchedulers.mainThread())
                .doOnTerminate { mNewsView?.hideLoading() }
                .subscribe({ mNewsView?.onNewsItemLoaded(it) }, { mNewsView?.onError(it) })
    }

    fun onDestroy() {
        subscription?.unsubscribe()
    }

}