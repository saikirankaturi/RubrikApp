package com.rubrik.rubrikapp.RestApi.SwaggerObject;

import com.google.gson.annotations.SerializedName;

public class Node {
    private String id;
    @SerializedName("id")
    public String getId() {
        return id;
    }

    private String brikId;
    @SerializedName("brikId")
    public String getBrikId() {
        return brikId;
    }

    private String status;
    @SerializedName("status")
    public String getStatus() {
        return status;
    }

    private String ipAddress;
    @SerializedName("ipAddress")
    public String getIpAddress() {
        return ipAddress;
    }

    private SupportTunnel supportTunnel;
    @SerializedName("supportTunnel")
    public SupportTunnel getSupportTunnel() {
        return supportTunnel;
    }
}
