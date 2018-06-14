package com.rubrik.rubrikapp.RestApi.SwaggerObject;

import com.google.gson.annotations.SerializedName;

public class HDDCap {
        @SerializedName("bytes")
        private Long bytes;
        public Long getBytes() {
            return bytes;
        }
}
