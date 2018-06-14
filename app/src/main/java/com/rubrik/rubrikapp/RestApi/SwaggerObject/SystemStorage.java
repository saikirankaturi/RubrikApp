package com.rubrik.rubrikapp.RestApi.SwaggerObject;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SystemStorage {
    @SerializedName("total")
    private double total;
    public double getTotal() {
        return total;
    }

    @SerializedName("used")
    private double used;
    public double getUsed() {
        return used;
    }
}
