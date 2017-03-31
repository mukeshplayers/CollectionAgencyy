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

public class RemoveCompany extends AppCompatActivity {

    ListView listView;
    RemoveCompanyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.remove_company);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Remove Company");
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        String companyString = "{\n" +
                "\t\"remove_companydata\":\n" +
                "\t[\n" +
                "\t\t{\n" +
                "\t\t\t\"Company_Id\": \"1\",\n" +
                "\t\t\t\"Company_Name\": \"Vodafone\",\n" +
                "\t\t\t\"Email\": \"vodafone@vodafone.com\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"Company_Id\": \"2\",\n" +
                "\t\t\t\"Company_Name\": \"AirTel\",\n" +
                "\t\t\t\"Email\": \"airtel@airtel.com\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"Company_Id\": \"3\",\n" +
                "\t\t\t\"Company_Name\": \"Idea\",\n" +
                "\t\t\t\"Email\": \"idea@idea.com\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"Company_Id\": \"4\",\n" +
                "\t\t\t\"Company_Name\": \"Telenor\",\n" +
                "\t\t\t\"Email\": \"telenor@telenor.com\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"Company_Id\": \"5\",\n" +
                "\t\t\t\"Company_Name\": \"DOCOMO\",\n" +
                "\t\t\t\"Email\": \"docomo@docomo.com\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"Company_Id\": \"6\",\n" +
                "\t\t\t\"Company_Name\": \"Aircel\",\n" +
                "\t\t\t\"Email\": \"aircel@aircel.com\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"Company_Id\": \"7\",\n" +
                "\t\t\t\"Company_Name\": \"Reliance\",\n" +
                "\t\t\t\"Email\": \"reliance@reliance.com\"\n" +
                "\t\t},\n" +
                "\t]\n" +
                "}";

        ArrayList<RemoveCompanyPost> arrayList = new ArrayList<RemoveCompanyPost>();

        try {
            JSONObject rootObject = new JSONObject(companyString);
            JSONArray jsonArray = rootObject.getJSONArray("remove_companydata");

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                RemoveCompanyPost post = new RemoveCompanyPost();

                String cmpny_id = jsonObject.getString("Company_Id");
                String cmpny_name = jsonObject.getString("Company_Name");
                String cmpny_email = jsonObject.getString("Email");

                post.setCompany_id(cmpny_id);
                post.setCompany_name(cmpny_name);
                post.setCompany_email(cmpny_email);

                arrayList.add(post);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        listView = (ListView)findViewById(R.id.list_removecompany);
        adapter = new RemoveCompanyAdapter(RemoveCompany.this, R.id.layout_removecompany_rows, arrayList);
        listView.setAdapter(adapter);
    }
}
