package com.ktoi.toi.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class NewsResponse {

    @SerializedName("Pagination")
    @Expose
    private Pagination pagination;
    @SerializedName("NewsItem")
    @Expose
    private List<NewsItem> newsItem = new ArrayList<NewsItem>();

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public List<NewsItem> getNewsItem() {
        return newsItem;
    }

    public void setNewsItem(List<NewsItem> newsItem) {
        this.newsItem = newsItem;
    }

}