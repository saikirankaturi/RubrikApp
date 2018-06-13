package com.rubrik.rubrikapp.RestApi.SwaggerObject;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Nodes {
    @SerializedName("hasMore")
    private Boolean hasMoreNodes;
    public Boolean getHasMoreNodes() {
        return hasMoreNodes;
    }

    @SerializedName("data")
    private List<Node> data;
    public List<Node> getData() {
        return data;
    }

    @SerializedName("total")
    private Integer total;
    public Integer getTotal() {
        return total;
    }
}
