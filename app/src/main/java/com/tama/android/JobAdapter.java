package com.tama.android;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class JobAdapter extends BaseAdapter {
    private Context context;
    private List<JobModel> jobList;

    public JobAdapter(Context context, List<JobModel> jobList) {
        this.context = context;
        this.jobList = jobList;
    }


    @Override
    public int getCount() {
        return jobList.size();
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
        if (convertView == null) {
            convertView = View.inflate(context, android.R.layout.simple_list_item_1, null);
        }

        JobModel jobModel = jobList.get(position);
        ((TextView) convertView.findViewById(android.R.id.text1)).setText(jobModel.toString());

        return convertView;
    }
}
