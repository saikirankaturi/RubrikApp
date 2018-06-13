package com.rubrik.rubrikapp.RestApi.SwaggerObject;

import com.google.gson.annotations.SerializedName;

public class SupportTunnel {
    @SerializedName("isTunnelEnabled")
    private Boolean isTunnelEnabled;
    public Boolean getIsTunnelEnabled() {
        return isTunnelEnabled;
    }
}