package com.collectionagency.collectionagency.manager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.collectionagency.collectionagency.R;

import java.util.ArrayList;

public class LeaveAdapter extends BaseAdapter {

    private Context context;
    int layoutResourceId;
    ArrayList<LeavePost> posts;

    public LeaveAdapter(Context context, int layoutResourceId, ArrayList<LeavePost> posts) {
        this.context = context;
        this.layoutResourceId = layoutResourceId;
        this.posts = posts;
    }

    @Override
    public int getCount() {
        return posts.size();
    }

    @Override
    public Object getItem(int position) {
        return posts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    static class ViewHolder
    {
        TextView agent_id, name, reason, fromdate, todate;
        Button approve, reject;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

            ViewHolder holder = new ViewHolder();
            if (convertView == null)
            {
                convertView = LayoutInflater.from(context).inflate(R.layout.leave_rows,parent,false);

                holder.agent_id = (TextView)convertView.findViewById(R.id.leave_agentid);
                holder.name = (TextView)convertView.findViewById(R.id.leave_agentname);
                holder.reason = (TextView)convertView.findViewById(R.id.leave_reason);
                holder.fromdate = (TextView)convertView.findViewById(R.id.leave_fromdate);
                holder.todate = (TextView)convertView.findViewById(R.id.leave_todate);

                holder.approve = (Button)convertView.findViewById(R.id.btn_approve);
                holder.reject = (Button)convertView.findViewById(R.id.btn_reject);

                convertView.setTag(holder);
            }

            else {
                holder = (ViewHolder)convertView.getTag();
            }

            holder.agent_id.setText("Agent ID: "+posts.get(position).getAgent_id());
            holder.name.setText("Agent Name: "+posts.get(position).getAgent_name());
            holder.reason.setText("Reason of Leave: "+posts.get(position).getReason());
            holder.fromdate.setText("From Date: "+posts.get(position).getFromDate());
            holder.todate.setText(" To Date: "+posts.get(position).getToDate());

            holder.approve.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText(context, "Leave Approved Successfully.", Toast.LENGTH_SHORT).show();

                }
            });

            holder.reject.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText(context, "Sorry! Leave Has Not Been Approved.", Toast.LENGTH_SHORT).show();
                }
            });

            return convertView;
    }
}