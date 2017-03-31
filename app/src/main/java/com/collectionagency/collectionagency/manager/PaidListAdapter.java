package com.collectionagency.collectionagency.manager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.collectionagency.collectionagency.R;

import java.util.ArrayList;

public class PaidListAdapter extends BaseAdapter {

    Context context;
    int layoutResourceId;
    ArrayList<PaidlistPost> posts;

    public PaidListAdapter(Context context, int layoutResourceId, ArrayList<PaidlistPost> posts) {
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
        TextView cst_id, name, mobile, amount, company;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = new ViewHolder();

        if (convertView == null) {

            convertView = LayoutInflater.from(context).inflate(R.layout.paidlist_rows, parent, false);

            holder.cst_id = (TextView)convertView.findViewById(R.id.paid_customerid);
            holder.name = (TextView)convertView.findViewById(R.id.paid_customername);
            holder.mobile = (TextView)convertView.findViewById(R.id.paid_mobileno);
            holder.amount = (TextView)convertView.findViewById(R.id.paid_amount);
            holder.company = (TextView)convertView.findViewById(R.id.paid_companyname);

            convertView.setTag(holder);
        }

        else {

            holder = (ViewHolder)convertView.getTag();
        }

            holder.cst_id.setText("Customer ID: " +posts.get(position).getCustomer_ID());
            holder.name.setText("Name: "+posts.get(position).getName());
            holder.mobile.setText("Mobile: "+posts.get(position).getMobile());
            holder.amount.setText("Amount: "+posts.get(position).getAmount());
            holder.company.setText("Company: "+posts.get(position).getCompany_Name());

            return convertView;
    }
}
