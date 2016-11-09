package com.ktoi.toi.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

public class Image extends RealmObject {

    @SerializedName("Photo")
    @Expose
    private String photo;
    @SerializedName("Thumb")
    @Expose
    private String thumb;
    @SerializedName("PhotoCaption")
    @Expose
    private String photoCaption;

    /**
     * 
     * @return
     *     The photo
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * 
     * @param photo
     *     The Photo
     */
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    /**
     * 
     * @return
     *     The thumb
     */
    public String getThumb() {
        return thumb;
    }

    /**
     * 
     * @param thumb
     *     The Thumb
     */
    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    /**
     * 
     * @return
     *     The photoCaption
     */
    public String getPhotoCaption() {
        return photoCaption;
    }

    /**
     * 
     * @param photoCaption
     *     The PhotoCaption
     */
    public void setPhotoCaption(String photoCaption) {
        this.photoCaption = photoCaption;
    }

}