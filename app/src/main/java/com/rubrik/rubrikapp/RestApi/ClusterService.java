package com.rubrik.rubrikapp.RestApi;

import com.rubrik.rubrikapp.RestApi.SwaggerObject.BrikCount;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ClusterService {
    @GET("internal/cluster/me/brik_count")
    Call<BrikCount> getBrikCountForCluster();
}
