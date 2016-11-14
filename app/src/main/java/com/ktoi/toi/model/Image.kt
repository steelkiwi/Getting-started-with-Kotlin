package com.ktoi.toi.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

import io.realm.RealmObject

open class Image : RealmObject() {


    @SerializedName("Photo")
    @Expose
    var photo: String? = null

    @SerializedName("Thumb")
    @Expose
    var thumb: String? = null


    @SerializedName("PhotoCaption")
    @Expose
    var photoCaption: String? = null

}