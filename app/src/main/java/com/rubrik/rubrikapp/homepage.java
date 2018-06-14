package com.rubrik.rubrikapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class homepage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        String clusterip = AppController.getInstance().getClusterIp();
        String clusterid = "brik3";
        String nodes = "4",  cores = "4", brik = "2", memory = "256GB", SSD = "1.6TB", HDD = "94TB";
    /*
        TextView mText = (TextView) findViewById(R.id.clusteridid);
        mText.setText("Cluster ID : " + clusterid);

        mText = (TextView) findViewById(R.id.clusteripid1);
        mText.setText("Cluster IP : " + clusterip);

        mText = (TextView) findViewById(R.id.memoryid1);
        mText.setText("Memory : " + memory);

        mText = (TextView) findViewById(R.id.nodesid1);
        mText.setText("Nodes : " + nodes);

        mText = (TextView) findViewById(R.id.coresid);
        mText.setText("Cores : " + cores);

        mText = (TextView) findViewById(R.id.brikid);
        mText.setText("Brik : " + brik);

        mText = (TextView) findViewById(R.id.ssdid);
        mText.setText("SSD : " + SSD);

        mText = (TextView) findViewById(R.id.hddid);
        mText.setText("HDD : " + HDD);
*/
    }

    public void sendMessage(View view){
      //  Intent intent = new Intent(homepage.this, infopage.class);
       // startActivity(intent);
    }
}
