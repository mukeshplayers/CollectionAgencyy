package com.collectionagency.collectionagency.manager;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.collectionagency.collectionagency.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class RemoveAgent extends AppCompatActivity {

    ListView listView;
    RemoveAgentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.remove_agent);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Remove Agent");
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        String agentString = "{\n" +
                "\t\"agent_data\":\n" +
                "\t[\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"Agent_Id\": \"1\",\n" +
                "\t\t\t\t\"Fname\": \"Aakash Bhatia\",\n" +
                "\t\t\t\t\"Address\": \"B45 Gopal Nagar Society\",\n" +
                "\t\t\t\t\"Pincode\": \"382480\",\n" +
                "\t\t\t\t\"Email\": \"aakashbhatia@gmail.com\",\n" +
                "\t\t\t\t\"Phone\": \"9874561230\",\n" +
                "\t\t\t\t\"Password\": \"aakash\",\n" +
                "\t\t\t\t\"Area\": \"New Ranip\",\n" +
                "\t\t\t\t\"City\": \"Ahmedabad\",\n" +
                "\t\t\t\t\"State\": \"Gujarat\",\n" +
                "\t\t\t\t\"Gender\": \"Male\",\n" +
                "\t\t\t\t\"Aadhar\": \"1874 6547 8955\",\n" +
                "\t\t\t\t\"Dob\": \"04-24-90\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"Agent_Id\": \"2\",\n" +
                "\t\t\t\t\"Fname\": \"Gautam Mishra\",\n" +
                "\t\t\t\t\"Address\": \"1 Rambagh Society\",\n" +
                "\t\t\t\t\"Pincode\": \"348577\",\n" +
                "\t\t\t\t\"Email\": \"gautammishra@gmail.com\",\n" +
                "\t\t\t\t\"Phone\": \"8745961235\",\n" +
                "\t\t\t\t\"Password\": \"gautam\",\n" +
                "\t\t\t\t\"Area\": \"Navrangpura\",\n" +
                "\t\t\t\t\"City\": \"Ahmedabad\",\n" +
                "\t\t\t\t\"State\": \"Gujarat\",\n" +
                "\t\t\t\t\"Gender\": \"Male\",\n" +
                "\t\t\t\t\"Aadhar\": \"1875 4578 6587\",\n" +
                "\t\t\t\t\"Dob\": \"03-21-92\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"Agent_Id\": \"3\",\n" +
                "\t\t\t\t\"Fname\": \"Ashwin Parekh\",\n" +
                "\t\t\t\t\"Address\": \"72 Wishwa Flats\",\n" +
                "\t\t\t\t\"Pincode\": \"383800\",\n" +
                "\t\t\t\t\"Email\": \"ashwinparekh@gmail.com\",\n" +
                "\t\t\t\t\"Phone\": \"9874654848\",\n" +
                "\t\t\t\t\"Password\": \"ashwin\",\n" +
                "\t\t\t\t\"Area\": \"Wadaj\",\n" +
                "\t\t\t\t\"City\": \"Ahmedabad\",\n" +
                "\t\t\t\t\"State\": \"Gujarat\",\n" +
                "\t\t\t\t\"Gender\": \"Male\",\n" +
                "\t\t\t\t\"Aadhar\": \"1875 4587 8598\",\n" +
                "\t\t\t\t\"Dob\": \"02-12-91\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"Agent_Id\": \"4\",\n" +
                "\t\t\t\t\"Fname\": \"Jaimin Panchal\",\n" +
                "\t\t\t\t\"Address\": \"32 Tirupati Nagar\",\n" +
                "\t\t\t\t\"Pincode\": \"383800\",\n" +
                "\t\t\t\t\"Email\": \"jaiminpanchal@gmail.com\",\n" +
                "\t\t\t\t\"Phone\": \"8545457898\",\n" +
                "\t\t\t\t\"Password\": \"jaimin\",\n" +
                "\t\t\t\t\"Area\": \"Wadaj\",\n" +
                "\t\t\t\t\"City\": \"Ahmedabad\",\n" +
                "\t\t\t\t\"State\": \"Gujarat\",\n" +
                "\t\t\t\t\"Gender\": \"Male\",\n" +
                "\t\t\t\t\"Aadhar\": \"1875 7898 1236\",\n" +
                "\t\t\t\t\"Dob\": \"01-17-93\"\n" +
                "\t\t\t},\n" +
                "\t\t\t{\n" +
                "\t\t\t\t\"Agent_Id\": \"5\",\n" +
                "\t\t\t\t\"Fname\": \"Rajveer Dataniya\",\n" +
                "\t\t\t\t\"Address\": \"J8 Ramnagar\",\n" +
                "\t\t\t\t\"Pincode\": \"382480\",\n" +
                "\t\t\t\t\"Email\": \"rajveerdataniya@gmail.com\",\n" +
                "\t\t\t\t\"Phone\": \"8845789812\",\n" +
                "\t\t\t\t\"Password\": \"rajveer\",\n" +
                "\t\t\t\t\"Area\": \"New Ranip\",\n" +
                "\t\t\t\t\"City\": \"Ahmedabad\",\n" +
                "\t\t\t\t\"State\": \"Gujarat\",\n" +
                "\t\t\t\t\"Gender\": \"Male\",\n" +
                "\t\t\t\t\"Aadhar\": \"1873 7415 9874\",\n" +
                "\t\t\t\t\"Dob\": \"05-15-91\"\n" +
                "\t\t\t},\n" +
                "\n" +
                "\t]\n" +
                "}";

            ArrayList<RemoveAgentPost> arrayList = new ArrayList<RemoveAgentPost>();

        try {
            JSONObject rootObject = new JSONObject(agentString);
            JSONArray jsonArray = rootObject.getJSONArray("agent_data");

            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject jsonObject = jsonArray.getJSONObject(i);
                RemoveAgentPost post = new RemoveAgentPost();

                String agent_Id = jsonObject.getString("Agent_Id");
                String fname = jsonObject.getString("Fname");
                String address = jsonObject.getString("Address");
                String pincode = jsonObject.getString("Pincode");
                String email = jsonObject.getString("Email");
                String phone = jsonObject.getString("Phone");
                String area = jsonObject.getString("Area");
                String city = jsonObject.getString("City");
                String state = jsonObject.getString("State");
                String gender = jsonObject.getString("Gender");
                String aadhar = jsonObject.getString("Aadhar");
                String dob = jsonObject.getString("Dob");

                post.setAgent_Id(agent_Id);
                post.setFname(fname);
                post.setAddress(address);
                post.setPincode(pincode);
                post.setEmail(email);
                post.setPhone(phone);
                post.setArea(area);
                post.setCity(city);
                post.setState(state);
                post.setGender(gender);
                post.setAadhar(aadhar);
                post.setDob(dob);

                arrayList.add(post);
            }

            } catch (JSONException e) {
            e.printStackTrace();
        }

        listView = (ListView)findViewById(R.id.list_removeagent);
        adapter = new RemoveAgentAdapter(RemoveAgent.this, R.id.layout_removeagent_rows, arrayList);
        listView.setAdapter(adapter);
    }
}
