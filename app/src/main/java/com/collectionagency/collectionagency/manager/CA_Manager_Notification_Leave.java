package com.collectionagency.collectionagency.manager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.collectionagency.collectionagency.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class CA_Manager_Notification_Leave extends Fragment {
    private View view;
    private ListView listView;
    private LeaveAdapter adapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.ca_manager_notification_leave, container, false);


        String jsonLeaveData = "{\n" +
                "\t\"leave_data\":\n" +
                "\t[\n" +
                "\t\t{\n" +
                "\t\t\t\"Agent_id\": \"2\",\n" +
                "\t\t\t\"Name\": \"Rohit Sharma\",\n" +
                "\t\t\t\"Reason\": \"Suffering from high fever.\",\n" +
                "\t\t\t\"From_date\": \"04-12-17\",\n" +
                "\t\t\t\"To_date\": \"04-20-17\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"Agent_id\": \"74\",\n" +
                "\t\t\t\"Name\": \"Vikash Mehra\",\n" +
                "\t\t\t\"Reason\": \"I will be outside town.\",\n" +
                "\t\t\t\"From_date\": \"03-08-17\",\n" +
                "\t\t\t\"To_date\": \"03-13-17\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"Agent_id\": \"23\",\n" +
                "\t\t\t\"Name\": \"Jigar Patel\",\n" +
                "\t\t\t\"Reason\": \"Sister marriage.\",\n" +
                "\t\t\t\"From_date\": \"04-24-17\",\n" +
                "\t\t\t\"To_date\": \"04-26-17\"\n" +
                "\t\t},\n" +
                "\t]\n" +
                "}";


        ArrayList<LeavePost> arrayList = new ArrayList<LeavePost>();

        try {
            JSONObject rootObject = new JSONObject(jsonLeaveData);
            JSONArray jsonArray = rootObject.getJSONArray("leave_data");

            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject jsonObject = jsonArray.getJSONObject(i);

                LeavePost post = new LeavePost();

                String agent_id = jsonObject.getString("Agent_id");
                String name = jsonObject.getString("Name");
                String reason = jsonObject.getString("Reason");
                String fromdate = jsonObject.getString("From_date");
                String todate = jsonObject.getString("To_date");

                post.setAgent_id(agent_id);
                post.setAgent_name(name);
                post.setReason(reason);
                post.setFromDate(fromdate);
                post.setToDate(todate);

                arrayList.add(post);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        listView = (ListView)view.findViewById(R.id.list_leave_data);
        adapter = new LeaveAdapter(getActivity(), R.id.layout_leave_rows, arrayList);
        listView.setAdapter(adapter);


        return view;
    }
}
