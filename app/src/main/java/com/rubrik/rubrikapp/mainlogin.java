package com.rubrik.rubrikapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class mainlogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainlogin);
        getWindow().getDecorView().setBackgroundColor(Color.rgb(173,216,230));

    }

    public void sendMessage(View view)
    {
        final EditText editTextUsername = (EditText) findViewById(R.id.usernameid);
        final String username = editTextUsername.getText().toString();
        final EditText editTextPassword = (EditText) findViewById(R.id.passwordid);
        final String password = editTextPassword.getText().toString();

        if (username.equals("admin") && password.equals("RubrikAdminPassword")) {
            Intent intent = new Intent(mainlogin.this, homepage.class);
            startActivity(intent);
        } else {
            AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
            dlgAlert.setMessage("Wrong username/password");
            dlgAlert.setTitle("Invalid credentials");
            dlgAlert.setCancelable(false);
            dlgAlert.setPositiveButton("Ok",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            findViewById(R.id.ipaddress).refreshDrawableState();
                            editTextUsername.setText("");
                            editTextPassword.setText("");
                        }
                    });
            dlgAlert.create().show();
        }
    }
}
