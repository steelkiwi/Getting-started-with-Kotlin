package com.ktoi.toi.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

public class NewsItem extends RealmObject {

    @SerializedName("NewsItemId")
    @Expose
    private String newsItemId;
    @SerializedName("HeadLine")
    @Expose
    private String headLine;
    @SerializedName("Agency")
    @Expose
    private String agency;
    @SerializedName("DateLine")
    @Expose
    private String dateLine;
    @SerializedName("WebURL")
    @Expose
    private String webURL;
    @SerializedName("Caption")
    @Expose
    private String caption;
    @SerializedName("Image")
    @Expose
    private Image image;
    @SerializedName("Keywords")
    @Expose
    private String keywords;
    @SerializedName("Story")
    @Expose
    private String story;
    @SerializedName("CommentCountUrl")
    @Expose
    private String commentCountUrl;
    @SerializedName("CommentFeedUrl")
    @Expose
    private String commentFeedUrl;
    @SerializedName("Related")
    @Expose
    private String related;

    /**
     * 
     * @return
     *     The newsItemId
     */
    public String getNewsItemId() {
        return newsItemId;
    }

    /**
     * 
     * @param newsItemId
     *     The NewsItemId
     */
    public void setNewsItemId(String newsItemId) {
        this.newsItemId = newsItemId;
    }

    /**
     * 
     * @return
     *     The headLine
     */
    public String getHeadLine() {
        return headLine;
    }

    /**
     * 
     * @param headLine
     *     The HeadLine
     */
    public void setHeadLine(String headLine) {
        this.headLine = headLine;
    }

    /**
     * 
     * @return
     *     The agency
     */
    public String getAgency() {
        return agency;
    }

    /**
     * 
     * @param agency
     *     The Agency
     */
    public void setAgency(String agency) {
        this.agency = agency;
    }

    /**
     * 
     * @return
     *     The dateLine
     */
    public String getDateLine() {
        return dateLine;
    }

    /**
     * 
     * @param dateLine
     *     The DateLine
     */
    public void setDateLine(String dateLine) {
        this.dateLine = dateLine;
    }

    /**
     * 
     * @return
     *     The webURL
     */
    public String getWebURL() {
        return webURL;
    }

    /**
     * 
     * @param webURL
     *     The WebURL
     */
    public void setWebURL(String webURL) {
        this.webURL = webURL;
    }

    /**
     * 
     * @return
     *     The caption
     */
    public String getCaption() {
        return caption;
    }

    /**
     * 
     * @param caption
     *     The Caption
     */
    public void setCaption(String caption) {
        this.caption = caption;
    }

    /**
     * 
     * @return
     *     The image
     */
    public Image getImage() {
        return image;
    }

    /**
     * 
     * @param image
     *     The Image
     */
    public void setImage(Image image) {
        this.image = image;
    }

    /**
     * 
     * @return
     *     The keywords
     */
    public String getKeywords() {
        return keywords;
    }

    /**
     * 
     * @param keywords
     *     The Keywords
     */
    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    /**
     * 
     * @return
     *     The story
     */
    public String getStory() {
        return story;
    }

    /**
     * 
     * @param story
     *     The Story
     */
    public void setStory(String story) {
        this.story = story;
    }

    /**
     * 
     * @return
     *     The commentCountUrl
     */
    public String getCommentCountUrl() {
        return commentCountUrl;
    }

    /**
     * 
     * @param commentCountUrl
     *     The CommentCountUrl
     */
    public void setCommentCountUrl(String commentCountUrl) {
        this.commentCountUrl = commentCountUrl;
    }

    /**
     * 
     * @return
     *     The commentFeedUrl
     */
    public String getCommentFeedUrl() {
        return commentFeedUrl;
    }

    /**
     * 
     * @param commentFeedUrl
     *     The CommentFeedUrl
     */
    public void setCommentFeedUrl(String commentFeedUrl) {
        this.commentFeedUrl = commentFeedUrl;
    }

    /**
     * 
     * @return
     *     The related
     */
    public String getRelated() {
        return related;
    }

    /**
     * 
     * @param related
     *     The Related
     */
    public void setRelated(String related) {
        this.related = related;
    }

}