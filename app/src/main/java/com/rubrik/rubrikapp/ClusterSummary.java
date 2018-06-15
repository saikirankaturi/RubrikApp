package com.rubrik.rubrikapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.rubrik.rubrikapp.RestApi.JsonObjectRetriever;
import com.rubrik.rubrikapp.RestApi.JsonObjectVolleyInterface;
import com.rubrik.rubrikapp.RestApi.SwaggerObject.BrikCount;
import com.rubrik.rubrikapp.RestApi.SwaggerObject.FlashCap;
import com.rubrik.rubrikapp.RestApi.SwaggerObject.HDDCap;
import com.rubrik.rubrikapp.RestApi.SwaggerObject.MemoryCapacityBytes;
import com.rubrik.rubrikapp.RestApi.SwaggerObject.Nodes;

public class ClusterSummary extends AppCompatActivity {

    String clusterip = AppController.getInstance().getClusterIp();
    String clusterName;
    String noOfNodes, cores, noOfBriks, memoryInBytes, SSD, HDD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cluster_summary);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ProgressDialog progressDialog = new ProgressDialog(this);
        String clusterIp = AppController.getInstance().getClusterIp();
        TextView mText = (TextView) findViewById(R.id.clusterip1);
        mText.setText("Cluster IP : " + clusterIp);
        JsonObjectRetriever.getObjectFromRest(
                "internal/cluster/me/brik_count",
                progressDialog,
                BrikCount.class,
                "internal/cluster/me/brik_count",
                new JsonObjectVolleyInterface<BrikCount>() {
                    @Override
                    public void onSuccess(BrikCount brikCount) {
                        noOfBriks = brikCount.getCount().toString();
                        TextView mText = (TextView) findViewById(R.id.noOfBriks);
                        mText.setText("Briks\n4");
                        JsonObjectRetriever.getObjectFromRest(
                                "internal/cluster/me/node",
                                progressDialog,
                                Nodes.class,
                                "internal/cluster/me/node",
                                new JsonObjectVolleyInterface<Nodes>() {
                                    @Override
                                    public void onSuccess(Nodes nodes) {
                                        noOfNodes = nodes.getTotal().toString();
                                        TextView mText = (TextView) findViewById(R.id.noOfNodes);
                                        mText.setText("Nodes\n4");
                                        JsonObjectRetriever.getObjectFromRest(
                                                "internal/cluster/me/memory_capacity",
                                                progressDialog,
                                                MemoryCapacityBytes.class,
                                                "internal/cluster/me/memory_capacity",
                                                new JsonObjectVolleyInterface<MemoryCapacityBytes>() {
                                                    @Override
                                                    public void onSuccess(MemoryCapacityBytes bytes) {
                                                        memoryInBytes = bytes.getBytes().toString();
                                                        TextView mText = (TextView) findViewById(R.id.memory1);
                                                        mText.setText("Memory\n25 GB");
                                                        JsonObjectRetriever.getObjectFromRest(
                                                                "internal/cluster/me/disk_capacity",
                                                                progressDialog,
                                                                HDDCap.class,
                                                                "internal/cluster/me/disk_capacity",
                                                                new JsonObjectVolleyInterface<HDDCap>() {
                                                                    @Override
                                                                    public void onSuccess(HDDCap hDDCap) {
                                                                        HDD = hDDCap.getBytes().toString();
                                                                        TextView mText = (TextView) findViewById(R.id.HDD);
                                                                        mText.setText("Total HDD Space : " + HDD);
                                                                        JsonObjectRetriever.getObjectFromRest(
                                                                                "internal/cluster/me/flash_capacity",
                                                                                progressDialog,
                                                                                FlashCap.class,
                                                                                "internal/cluster/me/flash_capacity",
                                                                                new JsonObjectVolleyInterface<FlashCap>() {
                                                                                    @Override
                                                                                    public void onSuccess(FlashCap flashCap) {
                                                                                        SSD = flashCap.getBytes().toString();
                                                                                        TextView mText = (TextView) findViewById(R.id.SSD);
                                                                                        mText.setText("Total SSD Space : " + SSD);
                                                                                        JsonObjectRetriever.getObjectFromRest(
                                                                                                "internal/node/*/cpu_cores_count",
                                                                                                progressDialog,
                                                                                                BrikCount.class,
                                                                                                "internal/node/*/cpu_cores_count",
                                                                                                new JsonObjectVolleyInterface<BrikCount>() {
                                                                                                    @Override
                                                                                                    public void onSuccess(BrikCount cpu) {
                                                                                                        cores = cpu.getCount().toString();
                                                                                                        TextView mText = (TextView) findViewById(R.id.cores);
                                                                                                        mText.setText("Total No. of cores : " + cores);
                                                                                                        JsonObjectRetriever.getObjectFromRest(
                                                                                                                "internal/cluster/me/name",
                                                                                                                progressDialog,
                                                                                                                String.class,
                                                                                                                "internal/cluster/me/name",
                                                                                                                new JsonObjectVolleyInterface<String>() {
                                                                                                                    @Override
                                                                                                                    public void onSuccess(String brikName) {
                                                                                                                        clusterName = brikName;
                                                                                                                        TextView mText = (TextView) findViewById(R.id.clusterName);
                                                                                                                        mText.setText("ClusterName : " + clusterName);
                                                                                                                    }
                                                                                                                }
                                                                                                        );
                                                                                                    }
                                                                                                }
                                                                                        );
                                                                                    }
                                                                                }
                                                                        );
                                                                    }
                                                                }
                                                        );
                                                    }
                                                }
                                        );
                                    }
                                }
                        );
                    }
                }
        );





        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ClusterSummary.this, navbar.class);
                startActivity(intent);
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                 //       .setAction("Action", null).show();
            }
        });
    }

}
