package com.collectionagency.collectionagency.agent;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.collectionagency.collectionagency.R;
import com.collectionagency.collectionagency.manager.AgentNotificationAdapter;
import com.collectionagency.collectionagency.manager.CompanyPost;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class AgentNotification extends AppCompatActivity {

    ListView listView;
    AgentNotificationAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agent_notification);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Notification");
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        String jsonString = "{\n" +
                "\t\"customer_data\":\n" +
                "\t\t[\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"Customer_id\": \"1\",\n" +
                "\t\t\t\t\"Name\": \"Mukesh Prajapati\",\n" +
                "\t\t\t\t\"Mobile No\": \"7874181218\",\n" +
                "\t\t\t\t\"Amount\": \"5000\",\n" +
                "\t\t\t\t\"Address\": \"12 Anand Shopping Centre\",\n" +
                "\t\t\t\t\"Area\": \"New Ranip\",\n" +
                "\t\t\t\t\"City\": \"Ahmedabad\",\n" +
                "\t\t\t\t\"State\": \"Gujarat\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"Customer_id\": \"2\",\n" +
                "\t\t\t\t\"Name\": \"Dharmesh Dataniya\",\n" +
                "\t\t\t\t\"Mobile No\": \"7405229128\",\n" +
                "\t\t\t\t\"Amount\": \"4000\",\n" +
                "\t\t\t\t\"Address\": \"138 Government Quarters\",\n" +
                "\t\t\t\t\"Area\": \"Meethkali\",\n" +
                "\t\t\t\t\"City\": \"Ahmedabad\",\n" +
                "\t\t\t\t\"State\": \"Gujarat\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"Customer_id\": \"3\",\n" +
                "\t\t\t\t\"Name\": \"Ravi Patel\",\n" +
                "\t\t\t\t\"Mobile No\": \"8460881278\",\n" +
                "\t\t\t\t\"Amount\": \"500\",\n" +
                "\t\t\t\t\"Address\": \"45\",\n" +
                "\t\t\t\t\"Area\": \" Nirman Society\",\n" +
                "\t\t\t\t\"City\": \"Navrangpura\",\n" +
                "\t\t\t\t\"State\": \"Ahmedabad\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"Customer_id\": \"4\",\n" +
                "\t\t\t\t\"Name\": \"Karan Singh\",\n" +
                "\t\t\t\t\"Mobile No\": \"7845987878\",\n" +
                "\t\t\t\t\"Amount\": \"10000\",\n" +
                "\t\t\t\t\"Address\": \"Block B Arved Complex\",\n" +
                "\t\t\t\t\"Area\": \"Wadaj\",\n" +
                "\t\t\t\t\"City\": \"Ahmedabad\",\n" +
                "\t\t\t\t\"State\": \"Gujarat\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"Customer_id\": \"5\",\n" +
                "\t\t\t\t\"Name\": \"Mulayam Singh\",\n" +
                "\t\t\t\t\"Mobile No\": \"8521400033\",\n" +
                "\t\t\t\t\"Amount\": \"4200\",\n" +
                "\t\t\t\t\"Address\": \"12 Nirman Plaza\",\n" +
                "\t\t\t\t\"Area\": \"Jyoti Nagar\",\n" +
                "\t\t\t\t\"City\": \"Ahmedabad\",\n" +
                "\t\t\t\t\"State\": \"Gujarat\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"Customer_id\": \"6\",\n" +
                "\t\t\t\t\"Name\": \"Kuldeep Yadav\",\n" +
                "\t\t\t\t\"Mobile No\": \"7468978454\",\n" +
                "\t\t\t\t\"Amount\": \"4875\",\n" +
                "\t\t\t\t\"Address\": \"3 Kamla Nagar Park\",\n" +
                "\t\t\t\t\"Area\": \"Manek Chowk\",\n" +
                "\t\t\t\t\"City\": \"Ahmedabad\",\n" +
                "\t\t\t\t\"State\": \"Gujarat\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"Customer_id\": \"7\",\n" +
                "\t\t\t\t\"Name\": \"Deepak Chaurasiya\",\n" +
                "\t\t\t\t\"Mobile No\": \"8569874527\",\n" +
                "\t\t\t\t\"Amount\": \"9875\",\n" +
                "\t\t\t\t\"Address\": \"7 Dhandhupura Marg\",\n" +
                "\t\t\t\t\"Area\": \"New Ranip\",\n" +
                "\t\t\t\t\"City\": \"Ahmedabad\",\n" +
                "\t\t\t\t\"State\": \"Gujarat\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"Customer_id\": \"8\",\n" +
                "\t\t\t\t\"Name\": \"Natwarlal Chauhan\",\n" +
                "\t\t\t\t\"Mobile No\": \"8568782178\",\n" +
                "\t\t\t\t\"Amount\": \"4575\",\n" +
                "\t\t\t\t\"Address\": \"24 Bansal Nagar\",\n" +
                "\t\t\t\t\"Area\": \"Jyoti Nagar\",\n" +
                "\t\t\t\t\"City\": \"Ahmedabad\",\n" +
                "\t\t\t\t\"State\": \"Gujarat\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"Customer_id\": \"9\",\n" +
                "\t\t\t\t\"Name\": \"Sachin Thakkar\",\n" +
                "\t\t\t\t\"Mobile No\": \"9874651238\",\n" +
                "\t\t\t\t\"Amount\": \"1200\",\n" +
                "\t\t\t\t\"Address\": \"56 Ambika Cross Road\",\n" +
                "\t\t\t\t\"Area\": \"Ananpur\",\n" +
                "\t\t\t\t\"City\": \"Ahmedabad\",\n" +
                "\t\t\t\t\"State\": \"Gujarat\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"Customer_id\": \"10\",\n" +
                "\t\t\t\t\"Name\": \"Rahul Roy\",\n" +
                "\t\t\t\t\"Mobile No\": \"7845699856\",\n" +
                "\t\t\t\t\"Amount\": \"7200\",\n" +
                "\t\t\t\t\"Address\": \"1 Shiv Shakti Society\",\n" +
                "\t\t\t\t\"Area\": \"Jyoti Nagar\",\n" +
                "\t\t\t\t\"City\": \"Ahmedabad\",\n" +
                "\t\t\t\t\"State\": \"Gujarat\"\n" +
                "\t\t\t}\n" +
                "\t\t]\n" +
                "}";

            ArrayList<CompanyPost> arrayList = new ArrayList<CompanyPost>();

        try {
            JSONObject rootObject = new JSONObject(jsonString);
            JSONArray jsonArray = rootObject.getJSONArray("customer_data");

            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject jsonObject = jsonArray.getJSONObject(i);

                String id = jsonObject.getString("Customer_id");
                String name = jsonObject.getString("Name");
                String mobileno = jsonObject.getString("Mobile No");
                String amount = jsonObject.getString("Amount");
                String address = jsonObject.getString("Address");
                String area = jsonObject.getString("Area");
                String city = jsonObject.getString("City");
                String state = jsonObject.getString("State");

                CompanyPost post = new CompanyPost();

                post.setCustomer_id(id);
                post.setName(name);
                post.setMobile_no(mobileno);
                post.setAmount(amount);
                post.setAddress(address);
                post.setArea(area);
                post.setCity(city);
                post.setState(state);

                arrayList.add(post);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        listView = (ListView)findViewById(R.id.list_agent_notification);
        adapter = new AgentNotificationAdapter(AgentNotification.this, R.id.layout_agent_rows, arrayList);
        listView.setAdapter(adapter);
    }
}