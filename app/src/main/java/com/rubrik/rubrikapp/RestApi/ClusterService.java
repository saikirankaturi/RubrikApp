package com.rubrik.rubrikapp.RestApi;

import com.google.gson.annotations.SerializedName;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ClusterService {
    @GET("internal/cluster/me/brik_count")
    Call<BrikCount> getBrikCountForCluster();
}
