package com.hitachi_tstv.samsen.tunyaporn.proofpfdelivery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by tunyaporns on 9/27/2016.
 */

public class JobListAdaptor extends BaseAdapter {

    private Context context;
    private String[] jobStrings, storeStrings, timeStrings;

    public JobListAdaptor(Context context, String[] jobStrings, String[] storeStrings, String[] timeStrings) {
        this.context = context;
        this.jobStrings = jobStrings;
        this.storeStrings = storeStrings;
        this.timeStrings = timeStrings;
    }

    @Override
    public int getCount() {
        return jobStrings.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.job_list_item, parent, false);

        //Bind widget
        TextView jobTextView = (TextView) view.findViewById(R.id.txtJob);
        TextView storeTextView = (TextView) view.findViewById(R.id.txtStore);
        TextView timeTextView = (TextView) view.findViewById(R.id.txtTime);

        jobTextView.setText(jobStrings[position]);
        storeTextView.setText(storeStrings[position]);
        timeTextView.setText(timeStrings[position]);

        return view;
    }
}
