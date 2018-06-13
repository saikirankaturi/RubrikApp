package com.rubrik.rubrikapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.rubrik.rubrikapp.RestApi.SwaggerObject.BrikCount;
import com.rubrik.rubrikapp.RestApi.JsonObjectRetriever;
import com.rubrik.rubrikapp.RestApi.JsonObjectVolleyInterface;
import com.rubrik.rubrikapp.RestApi.SwaggerObject.Nodes;

public class AddCluster extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_cluster);
        ProgressDialog progressDialog = new ProgressDialog(this);


        JsonObjectRetriever.getObjectFromRest(
            "https://10.33.16.117/api/internal/cluster/me/node",
            progressDialog,
            Nodes.class,
            new JsonObjectVolleyInterface<Nodes>() {
                @Override
                public void onSuccess(Nodes nodes) {
                    Log.d("Woah!", nodes.getData().get(0).getBrikId());
                }
            }
        );
    }

    public void sendMessage(View view)
    {
        Intent intent = new Intent(AddCluster.this, mainlogin.class);
        startActivity(intent);
    }

}
