package com.example.queen.saediproject.API.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sikshya on 11/9/17.
 */

public class ExcerptResponse {

    @SerializedName("rendered")
    public String renderedExcerpt;

    public String getRenderedExcerpt() {
        return renderedExcerpt;
    }

    public void setRenderedExcerpt(String renderedExcerpt) {
        this.renderedExcerpt = renderedExcerpt;
    }
}
