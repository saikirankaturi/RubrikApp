package com.rubrik.rubrikapp;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.rubrik.rubrikapp.RestApi.JsonObjectRetriever;
import com.rubrik.rubrikapp.RestApi.JsonObjectVolleyInterface;
import com.rubrik.rubrikapp.RestApi.SwaggerObject.BrikCount;
import com.rubrik.rubrikapp.RestApi.SwaggerObject.FlashCap;
import com.rubrik.rubrikapp.RestApi.SwaggerObject.HDDCap;
import com.rubrik.rubrikapp.RestApi.SwaggerObject.MemoryCapacityBytes;
import com.rubrik.rubrikapp.RestApi.SwaggerObject.Nodes;
import com.rubrik.rubrikapp.RestApi.SwaggerObject.SystemStorage;

public class dashboard extends AppCompatActivity {

    String snapshotCount;
    Double percentDataReduction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        final ProgressDialog progressDialog = new ProgressDialog(this);
//        String clusterIp = AppController.getInstance().getClusterIp();

        JsonObjectRetriever.getObjectFromRest(
                "internal/stats/system_storage",
                progressDialog,
                SystemStorage.class,
                "internal/stats/system_storage",
                new JsonObjectVolleyInterface<SystemStorage>() {
                    @Override
                    public void onSuccess(SystemStorage systemStorage) {
                        percentDataReduction = 5000.0 * systemStorage.getUsed() / systemStorage.getTotal();
                        TextView mText = (TextView) findViewById(R.id.percentDataReduction);
                        mText.setText("Percentage data reduction: " + percentDataReduction.toString());

                        TextView mText0 = (TextView) findViewById(R.id.ArchiveSize);
                        mText0.setText("Size of Archive: 12.76 GB");

                        TextView mText1 = (TextView) findViewById(R.id.ProtectedVmsCount);
                        mText1.setText("Number of protected Vms: 837");

                        TextView mText2 = (TextView) findViewById(R.id.UnprotectedVmsCount);
                        mText2.setText("Number of unprotected Vms: 18");

                        TextView mText3 = (TextView) findViewById(R.id.snapshotCount);
                        mText3.setText("Vmware Snapshot Count : 128" );

                    }
                }
        );
//
//        JsonObjectRetriever.getObjectFromRest(
//                "internal/vmware/vm/snapshot/count",
//                progressDialog,
//                BrikCount.class,
//                "internal/vmware/vm/snapshot/count",
//                new JsonObjectVolleyInterface<BrikCount>() {
//                    @Override
//                    public void onSuccess(BrikCount brikCount) {
//                        snapshotCount = brikCount.getCount().toString();
////                        TextView mText = (TextView) findViewById(R.id.snapshotCount);
////                        mText.setText("Vmware Snapshot Count : " + snapshotCount);
//                        JsonObjectRetriever.getObjectFromRest(
//                                "internal/stats/system_storage",
//                                progressDialog,
//                                SystemStorage.class,
//                                "internal/stats/system_storage",
//                                new JsonObjectVolleyInterface<SystemStorage>() {
//                                    @Override
//                                    public void onSuccess(SystemStorage systemStorage) {
//                                        percentDataReduction = 5000.0 * systemStorage.getUsed() / systemStorage.getTotal();
//                                        TextView mText = (TextView) findViewById(R.id.percentDataReduction);
//                                        mText.setText("Percentage data reduction: " + percentDataReduction.toString());
//                                    }
//                                }
//                        );
//                    }
//                }
//        );
    }
}
