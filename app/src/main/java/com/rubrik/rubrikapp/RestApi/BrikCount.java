package com.rubrik.rubrikapp.RestApi;

import com.google.gson.annotations.SerializedName;

public class BrikCount {
    @SerializedName("count")
    private Long brikCount;
    public Long getBrikCount() {
        return brikCount;
    }
}
