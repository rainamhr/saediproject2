package com.example.queen.saediproject.API.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by sikshya on 11/9/17.
 */


public class MediaDetails {

    @SerializedName("width")
    @Expose
    private Integer width;
    @SerializedName("height")
    @Expose
    private Integer height;
    @SerializedName("file")
    @Expose
    private String file;
    @SerializedName("sizes")
    @Expose
    private Sizes sizes;
    @SerializedName("image_meta")
    @Expose
    private ImageMeta imageMeta;
    @SerializedName("ewww_image_optimizer")
    @Expose
    private String ewwwImageOptimizer;

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

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public Sizes getSizes() {
        return sizes;
    }

    public void setSizes(Sizes sizes) {
        this.sizes = sizes;
    }

    public ImageMeta getImageMeta() {
        return imageMeta;
    }

    public void setImageMeta(ImageMeta imageMeta) {
        this.imageMeta = imageMeta;
    }

    public String getEwwwImageOptimizer() {
        return ewwwImageOptimizer;
    }

    public void setEwwwImageOptimizer(String ewwwImageOptimizer) {
        this.ewwwImageOptimizer = ewwwImageOptimizer;
    }

}
