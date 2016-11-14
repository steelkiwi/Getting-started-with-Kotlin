package com.ktoi.toi.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

import io.realm.RealmObject

open class NewsItem : RealmObject() {

    @SerializedName("NewsItemId")
    @Expose
    var newsItemId: String? = null

    @SerializedName("HeadLine")
    @Expose
    var headLine: String? = null

    @SerializedName("Agency")
    @Expose
    var agency: String? = null

    @SerializedName("DateLine")
    @Expose
    var dateLine: String? = null

    @SerializedName("WebURL")
    @Expose
    var webURL: String? = null

    @SerializedName("Caption")
    @Expose
    var caption: String? = null

    @SerializedName("Image")
    @Expose
    var image: Image? = null

    @SerializedName("Keywords")
    @Expose
    var keywords: String? = null

    @SerializedName("Story")
    @Expose
    var story: String? = null

    @SerializedName("CommentCountUrl")
    @Expose
    var commentCountUrl: String? = null

    @SerializedName("CommentFeedUrl")
    @Expose
    var commentFeedUrl: String? = null

    @SerializedName("Related")
    @Expose
    var related: String? = null

}