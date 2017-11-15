package com.example.queen.saediproject.API.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by sikshya on 11/9/17.
 */

public class Sizes {

    @SerializedName("thumbnail")
    @Expose
    private Thumbnail thumbnail;
    @SerializedName("medium")
    @Expose
    private Medium medium;
    @SerializedName("medium_large")
    @Expose
    private MediumLarge mediumLarge;
    @SerializedName("simplifiedblog-list-thumb")
    @Expose
    private SimplifiedblogListThumb simplifiedblogListThumb;

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Medium getMedium() {
        return medium;
    }

    public void setMedium(Medium medium) {
        this.medium = medium;
    }

    public MediumLarge getMediumLarge() {
        return mediumLarge;
    }

    public void setMediumLarge(MediumLarge mediumLarge) {
        this.mediumLarge = mediumLarge;
    }

    public SimplifiedblogListThumb getSimplifiedblogListThumb() {
        return simplifiedblogListThumb;
    }

    public void setSimplifiedblogListThumb(SimplifiedblogListThumb simplifiedblogListThumb) {
        this.simplifiedblogListThumb = simplifiedblogListThumb;
    }

}
