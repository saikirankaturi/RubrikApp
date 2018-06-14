package com.rubrik.rubrikapp;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.iid.FirebaseInstanceId;
import com.rubrik.rubrikapp.RestApi.JsonObjectRetriever;
import com.rubrik.rubrikapp.RestApi.JsonObjectVolleyInterface;
import com.rubrik.rubrikapp.RestApi.SwaggerObject.Nodes;
import com.rubrik.rubrikapp.Utils.GenericUtils;

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

    public void sendMessage(View view) {
        String token = FirebaseInstanceId.getInstance().getToken();
        Log.d("AddCluster token", "token = " + token);

        final EditText editText = (EditText) findViewById(R.id.ipaddress);
        final String inputIp = editText.getText().toString(); //gets you the contents of edit text
        if (!GenericUtils.isValidIpAddress(inputIp)) {
            AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
            dlgAlert.setMessage("Please enter a valid IP address");
            dlgAlert.setTitle("Invalid IP");
            dlgAlert.setCancelable(false);
            dlgAlert.setPositiveButton("Ok",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            findViewById(R.id.ipaddress).refreshDrawableState();
                            editText.setText("");
                        }
                    });
            dlgAlert.create().show();
        } else if (!GenericUtils.isIpAccessibleOver443(inputIp)) {
            AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
            dlgAlert.setMessage("Please enter a valid node's IP address");
            dlgAlert.setTitle("Can't establish connection");
            dlgAlert.setCancelable(false);
            dlgAlert.setPositiveButton("Ok",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            findViewById(R.id.ipaddress).refreshDrawableState();
                            editText.setText("");
                        }
                    });
            dlgAlert.create().show();
        } else {
            Log.d("Woah!!!", inputIp);
            AppController.getInstance().setClusterIp(inputIp);
            Intent intent = new Intent(AddCluster.this, mainlogin.class);
            startActivity(intent);
        }
    }
}
