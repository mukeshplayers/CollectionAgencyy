package com.collectionagency.collectionagency.agent;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.collectionagency.collectionagency.R;

public class AgentNotificationDetail extends AppCompatActivity {

    String custid, name, mobile, amount, address, area, city, state;

    TextView tvcustid, tvname, tvmobile, tvamount, tvaddress, tvarea, tvcity, tvstate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agent_notification_detail);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Details");
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        custid = getIntent().getStringExtra("customerid");
        name = getIntent().getStringExtra("name");
        mobile = getIntent().getStringExtra("mobile");
        amount = getIntent().getStringExtra("amount");
        address = getIntent().getStringExtra("address");
        area = getIntent().getStringExtra("area");
        city = getIntent().getStringExtra("city");
        state = getIntent().getStringExtra("state");

        Log.d("CustomerID:", "CustomerID: "+custid);

        tvcustid = (TextView)findViewById(R.id.tv_custid);
        tvname = (TextView)findViewById(R.id.tv_custname);
        tvmobile = (TextView)findViewById(R.id.tv_custmobile);
        tvamount = (TextView)findViewById(R.id.tv_custamount);
        tvaddress = (TextView)findViewById(R.id.tv_custaddress);
        tvarea = (TextView)findViewById(R.id.tv_custarea);
        tvcity = (TextView)findViewById(R.id.tv_custcity);
        tvstate = (TextView)findViewById(R.id.tv_custstate);

        tvcustid.setText("Customer ID: "+custid);
        tvname.setText("Name: "+name);
        tvmobile.setText("Mobile No: "+mobile);
        tvamount.setText("Amount: "+amount);
        tvaddress.setText("Address: "+address);
        tvarea.setText("Area: "+area);
        tvcity.setText("City: "+city);
        tvstate.setText("State: "+state);
    }
}