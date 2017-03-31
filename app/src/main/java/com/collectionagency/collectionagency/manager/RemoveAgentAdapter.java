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

public class RemoveAgentAdapter extends BaseAdapter{

    Context context;
    int layoutResourceId;
    ArrayList<RemoveAgentPost> posts;

    public RemoveAgentAdapter(Context context, int layoutResourceId, ArrayList<RemoveAgentPost> posts) {
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
        TextView agent_id, fname, address, pincode, email, phone, area, city, state, gender, aadhar, dob;
        Button remove;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        ViewHolder holder = new ViewHolder();

        if (convertView == null) {

            convertView = LayoutInflater.from(context).inflate(R.layout.removeagent_row, parent, false);

            holder.agent_id = (TextView)convertView.findViewById(R.id.remove_agentid);
            holder.fname = (TextView)convertView.findViewById(R.id.remove_name);
            holder.address = (TextView)convertView.findViewById(R.id.remove_address);
            holder.pincode = (TextView)convertView.findViewById(R.id.remove_pincode);
            holder.email = (TextView)convertView.findViewById(R.id.remove_email);
            holder.phone = (TextView)convertView.findViewById(R.id.remove_phone);
            holder.area = (TextView)convertView.findViewById(R.id.remove_area);
            holder.city = (TextView)convertView.findViewById(R.id.remove_city);
            holder.state = (TextView)convertView.findViewById(R.id.remove_state);
            holder.gender = (TextView)convertView.findViewById(R.id.remove_gender);
            holder.aadhar = (TextView)convertView.findViewById(R.id.remove_aadhar);
            holder.dob = (TextView)convertView.findViewById(R.id.remove_dob);

            holder.remove = (Button)convertView.findViewById(R.id.btn_removeagent);

            convertView.setTag(holder);
        }

        else {

            holder = (ViewHolder)convertView.getTag();
        }


        holder.agent_id.setText("Agent ID: "+posts.get(position).getAgent_Id());
        holder.fname.setText("Name: "+posts.get(position).getFname());
        holder.address.setText("Address: "+posts.get(position).getAddress());
        holder.pincode.setText("Pincode: "+posts.get(position).getPincode());
        holder.email.setText("Email: "+posts.get(position).getEmail());
        holder.phone.setText("Phone: "+posts.get(position).getPhone());
        holder.area.setText("Area: " +posts.get(position).getArea());
        holder.city.setText("City:" +posts.get(position).getCity());
        holder.state.setText("State: "+posts.get(position).getState());
        holder.gender.setText("Gender: "+posts.get(position).getGender());
        holder.aadhar.setText("Aadhar: "+posts.get(position).getAadhar());
        holder.dob.setText("Date of Birth:" +posts.get(position).getDob());

        holder.remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Agent Removed", Toast.LENGTH_SHORT).show();
                posts.remove(position);
                notifyDataSetChanged();
            }
        });

        return convertView;
    }
}
