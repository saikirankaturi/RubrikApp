package com.rubrik.rubrikapp.RestApi.SwaggerObject;

import com.google.gson.annotations.SerializedName;

public class FlashCap {
    @SerializedName("bytes")
    private Long bytes;
    public Long getBytes() {
        return bytes;
    }
}
