package com.ktoi.toi.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

import javax.annotation.Generated

@Generated("org.jsonschema2pojo")
class Pagination {

    @SerializedName("TotalPages")
    @Expose
    var totalPages: String? = null

    @SerializedName("PageNo")
    @Expose
    var pageNo: String? = null

    @SerializedName("PerPage")
    @Expose
    var perPage: String? = null

    @SerializedName("WebURL")
    @Expose
    var webURL: String? = null

}