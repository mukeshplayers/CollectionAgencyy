package com.collectionagency.collectionagency.manager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.collectionagency.collectionagency.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class CA_Manager_Notification_Paidlist extends Fragment {

    private View view;

    private ListView listView;
    private PaidListAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.ca_manager_notification_paidlist, container, false);

        String jsonPaidString = "{\n" +
                "\t\"paidlist_data\":\n" +
                "\t[\n" +
                "\t\t{\n" +
                "\t\t\t\"Customer_ID\": \"25\",\n" +
                "\t\t\t\"Name\": \"Rakesh Sharma\",\n" +
                "\t\t\t\"Mobile\": \"8547969632\",\n" +
                "\t\t\t\"Amount\": \"4512\",\n" +
                "\t\t\t\"Company_Name\": \"Vodafone\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"Customer_ID\": \"32\",\n" +
                "\t\t\t\"Name\": \"Deepak Jadeja\",\n" +
                "\t\t\t\"Mobile\": \"7845981265\",\n" +
                "\t\t\t\"Amount\": \"785\",\n" +
                "\t\t\t\"Company_Name\": \"Vodafone\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"Customer_ID\": \"56\",\n" +
                "\t\t\t\"Name\": \"Miteshbhai Patel\",\n" +
                "\t\t\t\"Mobile\": \"7898456578\",\n" +
                "\t\t\t\"Amount\": \"368\",\n" +
                "\t\t\t\"Company_Name\": \"Reliance\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"Customer_ID\": \"78\",\n" +
                "\t\t\t\"Name\": \"Akil Khan\",\n" +
                "\t\t\t\"Mobile\": \"8549743215\",\n" +
                "\t\t\t\"Amount\": \"127\",\n" +
                "\t\t\t\"Company_Name\": \"Jio\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"Customer_ID\": \"85\",\n" +
                "\t\t\t\"Name\": \"Ramesh Verma\",\n" +
                "\t\t\t\"Mobile\": \"7449558741\",\n" +
                "\t\t\t\"Amount\": \"854\",\n" +
                "\t\t\t\"Company_Name\": \"Telenor\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"Customer_ID\": \"98\",\n" +
                "\t\t\t\"Name\": \"Vikesh Sharma\",\n" +
                "\t\t\t\"Mobile\": \"8301478964\",\n" +
                "\t\t\t\"Amount\": \"2458\",\n" +
                "\t\t\t\"Company_Name\": \"Docomo\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"Customer_ID\": \"45\",\n" +
                "\t\t\t\"Name\": \"Vishal Agnihotri\",\n" +
                "\t\t\t\"Mobile\": \"9875452133\",\n" +
                "\t\t\t\"Amount\": \"1200\",\n" +
                "\t\t\t\"Company_Name\": \"Docomo\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"Customer_ID\": \"111\",\n" +
                "\t\t\t\"Name\": \"Mahesh Mishra\",\n" +
                "\t\t\t\"Mobile\": \"9898454520\",\n" +
                "\t\t\t\"Amount\": \"1000\",\n" +
                "\t\t\t\"Company_Name\": \"Reliance\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"Customer_ID\": \"58\",\n" +
                "\t\t\t\"Name\": \"Shivam Pujara\",\n" +
                "\t\t\t\"Mobile\": \"9875789811\",\n" +
                "\t\t\t\"Amount\": \"589\",\n" +
                "\t\t\t\"Company_Name\": \"Telenor\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"Customer_ID\": \"44\",\n" +
                "\t\t\t\"Name\": \"Jay Prajapati\",\n" +
                "\t\t\t\"Mobile\": \"7506547892\",\n" +
                "\t\t\t\"Amount\": \"844\",\n" +
                "\t\t\t\"Company_Name\": \"Telenor\"\n" +
                "\t\t},\n" +
                "\t]\n" +
                "}";


        ArrayList<PaidlistPost>  arrayList = new ArrayList<PaidlistPost>();

        try {

            JSONObject rootObject = new JSONObject(jsonPaidString);
            JSONArray jsonArray = rootObject.getJSONArray("paidlist_data");

            for (int i = 0; i < jsonArray.length() ; i++) {

                JSONObject jsonObject = jsonArray.getJSONObject(i);
                PaidlistPost post = new PaidlistPost();

                String id = jsonObject.getString("Customer_ID");
                String name = jsonObject.getString("Name");
                String mobile = jsonObject.getString("Mobile");
                String amount = jsonObject.getString("Amount");
                String company_name = jsonObject.getString("Company_Name");

                post.setCustomer_ID(id);
                post.setName(name);
                post.setMobile(mobile);
                post.setAmount(amount);
                post.setCompany_Name(company_name);

                arrayList.add(post);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


        listView = (ListView)view.findViewById(R.id.list_paidlist_data);
        adapter = new PaidListAdapter(getActivity(), R.id.layout_paidlist_rows, arrayList);
        listView.setAdapter(adapter);

        return view;
    }
}
