package com.rubrik.rubrikapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AddCluster extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_cluster);
    }

    public void sendMessage(View view)
    {
        Intent intent = new Intent(AddCluster.this, mainlogin.class);
        startActivity(intent);
    }

}
