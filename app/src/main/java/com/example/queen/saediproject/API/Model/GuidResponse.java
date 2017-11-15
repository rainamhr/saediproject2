package com.example.queen.saediproject.API.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sikshya on 11/9/17.
 */

public class GuidResponse {

    @SerializedName("rendered")
    public String guidRendered;

    public String getGuidRendered() {
        return guidRendered;
    }

    public void setGuidRendered(String guidRendered) {
        this.guidRendered = guidRendered;
    }
}
