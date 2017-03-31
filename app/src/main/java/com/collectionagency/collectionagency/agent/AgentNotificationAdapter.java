package com.collectionagency.collectionagency.agent;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.collectionagency.collectionagency.R;
import com.collectionagency.collectionagency.manager.CompanyPost;

import java.util.ArrayList;

public class AgentNotificationAdapter extends BaseAdapter {

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
        Button view_detail;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        ViewHolder holder = new ViewHolder();

        if (convertView == null) {

            convertView = LayoutInflater.from(context).inflate(R.layout.agent_notification_rows, parent, false);

            holder.id = (TextView)convertView.findViewById(R.id.agent_custid);
            holder.name = (TextView)convertView.findViewById(R.id.agent_custname);
            holder.address = (TextView)convertView.findViewById(R.id.agent_custaddress);

            holder.view_detail = (Button)convertView.findViewById(R.id.btn_viewdetail);
            convertView.setTag(holder);
        }

        else {
            holder = (ViewHolder)convertView.getTag();
        }

            holder.id.setText("Customer ID: "+posts.get(position).getCustomer_id());
            holder.name.setText("Name: "+posts.get(position).getName());
            holder.address.setText("Address: "+posts.get(position).getAddress());

            final String mobile = posts.get(position).getMobile_no();
            final String amount = posts.get(position).getAmount();
            final String area = posts.get(position).getArea();
            final String city = posts.get(position).getCity();
            final String state = posts.get(position).getState();
            final String pincode = posts.get(position).getPincode();
            final String email = posts.get(position).getEmail();

            holder.view_detail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context.getApplicationContext(), AgentNotificationDetail.class);

                    intent.putExtra("customerid", posts.get(position).getCustomer_id());
                    intent.putExtra("name", posts.get(position).getName());
                    intent.putExtra("mobile", mobile);
                    intent.putExtra("amount", amount);
                    intent.putExtra("address", posts.get(position).getAddress());
                    intent.putExtra("area", area);
                    intent.putExtra("city", city);
                    intent.putExtra("state", state);
                    intent.putExtra("pincode", pincode);
                    intent.putExtra("email", email);

                    context.startActivity(intent);
                }
            });
            return convertView;
    }
}
