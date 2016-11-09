package com.ktoi.toi.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Pagination {

    @SerializedName("TotalPages")
    @Expose
    private String totalPages;
    @SerializedName("PageNo")
    @Expose
    private String pageNo;
    @SerializedName("PerPage")
    @Expose
    private String perPage;
    @SerializedName("WebURL")
    @Expose
    private String webURL;

    /**
     * 
     * @return
     *     The totalPages
     */
    public String getTotalPages() {
        return totalPages;
    }

    /**
     * 
     * @param totalPages
     *     The TotalPages
     */
    public void setTotalPages(String totalPages) {
        this.totalPages = totalPages;
    }

    /**
     * 
     * @return
     *     The pageNo
     */
    public String getPageNo() {
        return pageNo;
    }

    /**
     * 
     * @param pageNo
     *     The PageNo
     */
    public void setPageNo(String pageNo) {
        this.pageNo = pageNo;
    }

    /**
     * 
     * @return
     *     The perPage
     */
    public String getPerPage() {
        return perPage;
    }

    /**
     * 
     * @param perPage
     *     The PerPage
     */
    public void setPerPage(String perPage) {
        this.perPage = perPage;
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

}