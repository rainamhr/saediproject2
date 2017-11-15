package com.example.queen.saediproject.API.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by sikshya on 11/9/17.
 */

public class MainResponse implements Serializable {

    @SerializedName("title")
    @Expose
    TitleResponse titleResponse;

    public TitleResponse getTitleResponse() {
        return titleResponse;
    }

    public void setTitleResponse(TitleResponse titleResponse) {
        this.titleResponse = titleResponse;
    }

    @SerializedName("id")
    public String id;

    @SerializedName("date")
    public String date;

    @SerializedName("date_gmt")
    public String date_gmt;

    @SerializedName("modified")
    public String modified;

    @SerializedName("modified_gmt")
    public String modified_gmt;

    @SerializedName("slug")
    public String slug;

    @SerializedName("status")
    public String status;

    @SerializedName("type")
    public String type;


    @SerializedName("better_featured_image")
    @Expose
    BetterFeaturedImage betterFeaturedImage;

    public BetterFeaturedImage getBetterFeaturedImage() {
        return betterFeaturedImage;
    }

    public void setBetterFeaturedImage(BetterFeaturedImage betterFeaturedImage) {
        this.betterFeaturedImage = betterFeaturedImage;
    }

    @SerializedName("links")
    @Expose
    LinksResponse linksResponse;

    public LinksResponse getLinksResponse() {
        return linksResponse;
    }

    public void setLinksResponse(LinksResponse linksResponse) {
        this.linksResponse = linksResponse;
    }

    @SerializedName("author")
    public String author;

    @SerializedName("featured_media")
    public String featured_media;

    @SerializedName("comment_status")
    public String comment_status;

    @SerializedName("ping_status")
    public String ping_status;

    @SerializedName("sticky")
    public String sticky;

    @SerializedName("template")
    public String template;

    @SerializedName("format")
    public String format;

    @SerializedName("meta")
    public List<MetaResponse> metaResponseList;

    @SerializedName("tags")
    public List<TagsResponse> tagsResponseList;

    @SerializedName("guid")
    @Expose
    public GuidResponse guidResponse;

    public GuidResponse getGuidResponse() {
        return guidResponse;
    }

    public void setGuidResponse(GuidResponse guidResponse) {
        this.guidResponse = guidResponse;
    }





    @SerializedName("content")
    @Expose
    ContentResponse contentResponse;

    public ContentResponse getContentResponse() {
        return contentResponse;
    }

    public void setContentResponse(ContentResponse contentResponse) {
        this.contentResponse = contentResponse;
    }

    @SerializedName("excerpt")
    @Expose
    ExcerptResponse excerptResponse;

    public ExcerptResponse getExcerptResponse() {
        return excerptResponse;
    }

    public void setExcerptResponse(ExcerptResponse excerptResponse) {
        this.excerptResponse = excerptResponse;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate_gmt() {
        return date_gmt;
    }

    public void setDate_gmt(String date_gmt) {
        this.date_gmt = date_gmt;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public String getModified_gmt() {
        return modified_gmt;
    }

    public void setModified_gmt(String modified_gmt) {
        this.modified_gmt = modified_gmt;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFeatured_media() {
        return featured_media;
    }

    public void setFeatured_media(String featured_media) {
        this.featured_media = featured_media;
    }

    public String getComment_status() {
        return comment_status;
    }

    public void setComment_status(String comment_status) {
        this.comment_status = comment_status;
    }

    public String getPing_status() {
        return ping_status;
    }

    public void setPing_status(String ping_status) {
        this.ping_status = ping_status;
    }

    public String getSticky() {
        return sticky;
    }

    public void setSticky(String sticky) {
        this.sticky = sticky;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public List<MetaResponse> getMetaResponseList() {
        return metaResponseList;
    }

    public void setMetaResponseList(List<MetaResponse> metaResponseList) {
        this.metaResponseList = metaResponseList;
    }


    public List<TagsResponse> getTagsResponseList() {
        return tagsResponseList;
    }

    public void setTagsResponseList(List<TagsResponse> tagsResponseList) {
        this.tagsResponseList = tagsResponseList;
    }


}
