package com.collectionagency.collectionagency.manager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.collectionagency.collectionagency.R;

import java.util.ArrayList;

public class AgentNotificationAdapter extends BaseAdapter{

    Context context;
    int layoutResourceId;
    ArrayList<CompanyPost> posts;

    public AgentNotificationAdapter(Context context, int layoutResourceId, ArrayList<CompanyPost> posts) {
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
        TextView id, name, address;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = new ViewHolder();

        if (convertView == null) {

            convertView = LayoutInflater.from(context).inflate(R.layout.agent_notification_rows, parent, false);

            holder.id = (TextView)convertView.findViewById(R.id.agent_custid);
            holder.name = (TextView)convertView.findViewById(R.id.agent_custname);
            holder.address = (TextView)convertView.findViewById(R.id.agent_custaddress);

            convertView.setTag(holder);
        }

        else {
            holder = (ViewHolder)convertView.getTag();
        }

            holder.id.setText("Customer ID: "+posts.get(position).getCustomer_id());
            holder.name.setText("Name: "+posts.get(position).getName());
            holder.address.setText("Address: "+posts.get(position).getAddress());

            return convertView;
    }
}
