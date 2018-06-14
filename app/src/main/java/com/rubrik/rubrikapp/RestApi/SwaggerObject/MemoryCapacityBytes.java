package com.rubrik.rubrikapp.RestApi.SwaggerObject;

import com.google.gson.annotations.SerializedName;

public class MemoryCapacityBytes {
    @SerializedName("bytes")
    private Long bytes;
    public Long getBytes() {
            return bytes;
        }
}
