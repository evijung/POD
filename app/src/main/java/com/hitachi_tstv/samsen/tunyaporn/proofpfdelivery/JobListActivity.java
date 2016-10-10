package com.hitachi_tstv.samsen.tunyaporn.proofpfdelivery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

public class JobListActivity extends AppCompatActivity {
    //Explicit
    private ListView listView;
    private TextView nameTextView, truckTextView;
    private String licenseString, nameString, idString, truckIdString;
    private String[] jobStrings, storeStrings, timeStrings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_list);

        licenseString = getIntent().getStringExtra("license");
        nameString = getIntent().getStringExtra("name");
        idString = getIntent().getStringExtra("id");
        truckIdString = getIntent().getStringExtra("truckId");

        //Bind Widget
        listView = (ListView) findViewById(R.id.jobListView);
        nameTextView = (TextView) findViewById(R.id.txtName);
        truckTextView = (TextView) findViewById(R.id.txtTruck);

        nameTextView.setText(nameString);
        truckTextView.setText(licenseString);

        jobStrings = new String[]{"babaganoosh","Cabbage","cake","carrots","carne asada","celery","cheese","chicken","catfish","chips","chocolate","chowder","chicken","catfish","chips","chocolate","chowder"};
        storeStrings = new String[]{"asparagus","apples","avacado","alfalfa","acorn squash","almond","arugala","artichoke","applesauce","asian noodles","antelope","ahi tuna","artichoke","applesauce","asian noodles","antelope","ahi tuna"};
        timeStrings = new String[]{"barley","beer","bisque","bluefish","bread","broccoli","buritto","babaganoosh","Cabbage","cake","carrots","carne asada","babaganoosh","Cabbage","cake","carrots","carne asada"};

          JobListAdaptor jobListAdaptor = new JobListAdaptor(this,jobStrings,storeStrings,timeStrings);
        listView.setAdapter(jobListAdaptor);

    }
}
