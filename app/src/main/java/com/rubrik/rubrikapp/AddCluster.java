package com.rubrik.rubrikapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.rubrik.rubrikapp.RestApi.SwaggerObject.BrikCount;
import com.rubrik.rubrikapp.RestApi.JsonObjectRetriever;
import com.rubrik.rubrikapp.RestApi.JsonObjectVolleyInterface;

public class AddCluster extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_cluster);
        ProgressDialog progressDialog = new ProgressDialog(this);

        getWindow().getDecorView().setBackgroundColor(Color.rgb(173,216,230));

        JsonObjectRetriever.getObjectFromRest(
            "https://10.33.16.117/api/internal/cluster/me/brik_count",
            progressDialog,
            BrikCount.class,
            new JsonObjectVolleyInterface<BrikCount>() {
                @Override
                public void onSuccess(BrikCount brikCount) {
                    Log.d("Woah!", brikCount.getBrikCount().toString());
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
