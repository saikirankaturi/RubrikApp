package com.rubrik.rubrikapp.RestApi.SwaggerObject;

import com.google.gson.annotations.SerializedName;

public class BrikCount {
    @SerializedName("count")
    private Long brikCount;
    public Long getBrikCount() {
        return brikCount;
    }
}
