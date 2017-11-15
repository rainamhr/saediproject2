package com.example.queen.saediproject.API.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sikshya on 11/9/17.
 */

public class TitleResponse {
    @SerializedName("rendered")
    public String renderedTitle;

    public String getRenderedTitle() {
        return renderedTitle;
    }

    public void setRenderedTitle(String renderedTitle) {
        this.renderedTitle = renderedTitle;
    }
}
