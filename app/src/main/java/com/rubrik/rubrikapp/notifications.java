package com.rubrik.rubrikapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class notifications extends AppCompatActivity {

    String[] mobileArray = {
            "Failure: vCenter testing-vcenter.colo.rubrik.com unreachable from Cluster 9a0a34e8-78fb-45ba-824c-46a27fa0c1f1.",
            "Failure: Node B-1105-rb detected as down from node B-1107-rt. The node is failing periodic health checks. Could not recover node from down state. Please contact Rubrik Support.",
            "Success: Node B-1106-rb detected as up from node B-1103-rb",
            "Success: Node B-1105-rb detected as up from node B-1103-rt",
            "Warning: Consolidation bandwidth(0.05 MBPS) is low. You might want to switch off consolidation"
    };

    List<String> corrected = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);

        Spinner s1 =(Spinner)findViewById(R.id.spinner1);
        AdapterView.OnItemSelectedListener countrySelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> spinner, View container,
                                       int position, long id) {
                String selectedItem = spinner.getItemAtPosition(position).toString();
                Log.d("hello", selectedItem);
                for (int i = 0; i < mobileArray.length; i++) {
                    boolean isFound = mobileArray[i].indexOf(selectedItem) !=-1? true: false;
                    if (isFound == true) {
                        corrected.add(mobileArray[i]);
                        Log.d("now", corrected.toString());
                        Log.d("now", "yoyo");
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        };

        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.activity_listview, mobileArray);
        s1.setOnItemSelectedListener(countrySelectedListener);

        ListView listView = (ListView) findViewById(R.id.mobile_list);
        listView.setAdapter(adapter);
    }
}
