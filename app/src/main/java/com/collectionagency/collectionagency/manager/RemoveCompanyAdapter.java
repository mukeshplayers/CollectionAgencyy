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

public class RemoveCompanyAdapter extends BaseAdapter {

    Context context;
    int layoutResourceId;
    ArrayList<RemoveCompanyPost> posts;


    public RemoveCompanyAdapter(Context context, int layoutResourceId, ArrayList<RemoveCompanyPost> posts) {
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
        TextView c_id, c_name, c_email;
        Button remove;
    }

        @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        ViewHolder holder = new ViewHolder();
        if (convertView == null) {

            convertView = LayoutInflater.from(context).inflate(R.layout.removecompany_rows, parent, false);

            holder.c_id = (TextView)convertView.findViewById(R.id.remove_cmpnyid);
            holder.c_name = (TextView)convertView.findViewById(R.id.remove_cmpnyname);
            holder.c_email = (TextView)convertView.findViewById(R.id.remove_cmpnyemail);

            holder.remove = (Button)convertView.findViewById(R.id.btn_removecompany);

            convertView.setTag(holder);
        }

        else {

            holder = (ViewHolder)convertView.getTag();
        }

        holder.c_id.setText("Company ID: "+posts.get(position).getCompany_id());
        holder.c_name.setText("Name: "+posts.get(position).getCompany_name());
        holder.c_email.setText("Email: "+posts.get(position).getCompany_email());

        holder.remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Company Removed!", Toast.LENGTH_SHORT).show();
                posts.remove(position);
                notifyDataSetChanged();
            }
        });

        return convertView;
    }
}
