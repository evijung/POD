package com.hitachi_tstv.samsen.tunyaporn.proofpfdelivery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class JobListActivity extends AppCompatActivity {
    //Explicit
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_list);

        listView = (ListView) findViewById(R.id.jobListView);

        String[] jobStrings, storeStrings, timeStrings;
        jobStrings = new String[]{"babaganoosh","Cabbage","cake","carrots","carne asada","celery","cheese","chicken","catfish","chips","chocolate","chowder","chicken","catfish","chips","chocolate","chowder"};
        storeStrings = new String[]{"asparagus","apples","avacado","alfalfa","acorn squash","almond","arugala","artichoke","applesauce","asian noodles","antelope","ahi tuna","artichoke","applesauce","asian noodles","antelope","ahi tuna"};
        timeStrings = new String[]{"barley","beer","bisque","bluefish","bread","broccoli","buritto","babaganoosh","Cabbage","cake","carrots","carne asada","babaganoosh","Cabbage","cake","carrots","carne asada"};

        JobListAdaptor jobListAdaptor = new JobListAdaptor(this,jobStrings,storeStrings,timeStrings);
        listView.setAdapter(jobListAdaptor);

    }
}
