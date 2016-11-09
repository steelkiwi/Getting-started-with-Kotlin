package com.ktoi.toi.view.activities

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import com.ktoi.toi.R
import com.ktoi.toi.model.NewsItem
import com.ktoi.toi.presenter.NewsPresenter
import com.ktoi.toi.shared.AppDelegate
import com.ktoi.toi.shared.NewsApiInterface
import com.ktoi.toi.view.adapters.NewsAdapter
import com.ktoi.toi.view.interfaces.NewsView
import java.io.IOException
import javax.inject.Inject

class MainActivity : AppCompatActivity(), NewsView, SwipeRefreshLayout.OnRefreshListener {

    @Inject
    lateinit var mNewsPresenter: NewsPresenter
    @Inject
    lateinit var mNewsAPI: NewsApiInterface

    private val mProgressBar: ProgressBar by lazy {
        findViewById(R.id.progress_bar) as ProgressBar
    }
    private val mStatusTextView: TextView by lazy {
        findViewById(R.id.status_text_view) as TextView
    }
    private val mRecyclerView: RecyclerView by lazy {
        findViewById(R.id.recycler_view) as RecyclerView
    }
    private val mSwipeRefreshLayout: SwipeRefreshLayout by lazy {
        findViewById(R.id.swipe_layout) as SwipeRefreshLayout
    }
    private val toolbar: Toolbar by lazy {
        findViewById(R.id.toolbar) as Toolbar
    }

    private val mNewsAdapter = NewsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        inject()
        prepareSwipeRefreshLayout()
        prepareRecyclerView()
        mRecyclerView.adapter = mNewsAdapter
        mNewsPresenter.setNewsApiInterface(mNewsAPI)
        mNewsPresenter.onViewCreated(this)
        mNewsPresenter.loadNews()
    }

    private fun inject() {
        (application as AppDelegate).injector?.inject(this)
    }

    private fun prepareSwipeRefreshLayout() {
        mSwipeRefreshLayout.setColorSchemeColors(Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW)
        mSwipeRefreshLayout.setOnRefreshListener(this)
    }

    private fun prepareRecyclerView() {
        val layoutManager = LinearLayoutManager(this)
        mRecyclerView.layoutManager = layoutManager
        mRecyclerView.setHasFixedSize(true)
    }

    override fun onNewsItemLoaded(newsItems: List<NewsItem>) {
        mSwipeRefreshLayout.isRefreshing = false
        mProgressBar.visibility = View.GONE
        if(newsItems.isEmpty()) {
            mStatusTextView.setText(R.string.list_is_empty)
            return
        }
        mStatusTextView.text = null
        mNewsAdapter.setDataSource(newsItems)
    }

    override fun onError(throwable: Throwable?) {
        mSwipeRefreshLayout.isRefreshing = false
        mProgressBar.visibility = View.GONE
        if (throwable is IOException) {
            mStatusTextView.setText(R.string.connection_error)
        } else {
            mStatusTextView.setText(R.string.list_is_empty)
        }
    }

    override fun hideLoading() {
        mSwipeRefreshLayout.isRefreshing = false
        mProgressBar.visibility = View.GONE
    }

    override fun onRefresh() {
        mNewsPresenter.loadNews()
    }

    override fun onStop() {
        super.onStop()
        mNewsPresenter.onDestroy()
    }
}
