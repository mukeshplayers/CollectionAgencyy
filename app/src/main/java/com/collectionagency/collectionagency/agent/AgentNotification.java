package com.collectionagency.collectionagency.agent;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.collectionagency.collectionagency.R;

public class AgentNotification extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agent_notification);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Notification");
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
    }
}
