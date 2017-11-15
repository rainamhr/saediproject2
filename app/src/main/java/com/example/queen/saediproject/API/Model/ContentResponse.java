package com.example.queen.saediproject.API.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sikshya on 11/9/17.
 */

public class ContentResponse {

    @SerializedName("rendered")
    public String renderedContent;

    public String getRenderedContent() {
        return renderedContent;
    }

    public void setRenderedContent(String renderedContent) {
        this.renderedContent = renderedContent;
    }
}
