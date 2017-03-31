package com.collectionagency.collectionagency.manager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.collectionagency.collectionagency.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class CA_Manager_Notification_PendingList extends Fragment {
    private View view;

    private ListView listView;
    private CompanyAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.ca_manager_notification_pendinglist, container, false);

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


        ArrayList<CompanyPost> arrayList = new ArrayList<CompanyPost>();
        ArrayList<AgentNamesPost> names = new ArrayList<AgentNamesPost>();

        try {

            JSONObject rootObject = new JSONObject(jsonString);
            JSONArray jsonArray = rootObject.getJSONArray("customer_data");

            JSONObject rootObject1 = new JSONObject(agentString);
            JSONArray jsonArray1 = rootObject1.getJSONArray("agent_data");

            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject jsonObject = jsonArray.getJSONObject(i);

                CompanyPost post = new CompanyPost();

                String id = jsonObject.getString("Customer_id");
                String name = jsonObject.getString("Name");
                String mobileno = jsonObject.getString("Mobile No");
                String amount = jsonObject.getString("Amount");
                String address = jsonObject.getString("Address");
                String area = jsonObject.getString("Area");
                String city = jsonObject.getString("City");
                String state = jsonObject.getString("State");

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

            /*for (int i = 0; i <jsonArray1.length() ; i++) {
                JSONObject jsonObject1 = jsonArray1.getJSONObject(i);

                AgentNamesPost post1 = new AgentNamesPost();

                String fname = jsonObject1.getString("fname");
                //String lname = jsonObject1.getString("Lname");

                post1.setFname(fname);
                //post.setLname(lname);

                names.add(post1);
            }*/

        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {

            JSONObject rootObject1 = new JSONObject(agentString);
            JSONArray jsonArray1 = rootObject1.getJSONArray("agent_data");


            for (int i = 0; i <jsonArray1.length() ; i++) {
                JSONObject jsonObject1 = jsonArray1.getJSONObject(i);

                AgentNamesPost post1 = new AgentNamesPost();

                String fname = jsonObject1.getString("Fname");
                Log.d("Name ", "Name: " +fname);

                post1.setFname(fname);
                names.add(post1);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


        listView = (ListView)view.findViewById(R.id.list_company_data);
        adapter = new CompanyAdapter(getActivity(), R.id.list_rows, arrayList, names);
        listView.setAdapter(adapter);

        return view;
    }
}