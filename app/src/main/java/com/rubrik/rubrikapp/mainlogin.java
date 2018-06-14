package com.rubrik.rubrikapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class mainlogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainlogin);
        getWindow().getDecorView().setBackgroundColor(Color.rgb(173,216,230));

    }

    public void sendMessage(View view)
    {
        Intent intent = new Intent(mainlogin.this, homepage.class);
        startActivity(intent);
    }

}
