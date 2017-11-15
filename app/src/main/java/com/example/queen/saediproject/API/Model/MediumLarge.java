package com.example.queen.saediproject.API.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by sikshya on 11/9/17.
 */

public class MediumLarge {

    @SerializedName("file")
    @Expose
    private String file;
    @SerializedName("width")
    @Expose
    private Integer width;
    @SerializedName("height")
    @Expose
    private Integer height;
    @SerializedName("mime-type")
    @Expose
    private String mimeType;
    @SerializedName("ewww_image_optimizer")
    @Expose
    private String ewwwImageOptimizer;
    @SerializedName("source_url")
    @Expose
    private String sourceUrl;

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public String getEwwwImageOptimizer() {
        return ewwwImageOptimizer;
    }

    public void setEwwwImageOptimizer(String ewwwImageOptimizer) {
        this.ewwwImageOptimizer = ewwwImageOptimizer;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

}
