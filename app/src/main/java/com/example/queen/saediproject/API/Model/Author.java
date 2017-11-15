package com.example.queen.saediproject.API.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sikshya on 11/9/17.
 */

public class Author {
    @SerializedName("embeddable")
    public String embeddable;
    @SerializedName("href")
    public String href;

    public String getEmbeddable() {
        return embeddable;
    }

    public void setEmbeddable(String embeddable) {
        this.embeddable = embeddable;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }
}
