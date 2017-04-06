package com.collectionagency.collectionagency.manager;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.collectionagency.collectionagency.R;
import com.collectionagency.collectionagency.company.CA_Company_HomeScreen;

public class CA_Manager_Company_Registration extends AppCompatActivity {

    Button register;
    EditText e1, e2, e3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ca_manager_company_registration);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Company Registration");
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        e1 = (EditText)findViewById(R.id.et_company_email);
        e2 = (EditText)findViewById(R.id.et_company_phone);
        e3 = (EditText)findViewById(R.id.et_company_pwd);

        register = (Button)findViewById(R.id.ca_btn_register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (e1.getText().toString().isEmpty() &&
                        e2.getText().toString().isEmpty()&&
                        e3.getText().toString().isEmpty()) {

                    e1.setError("This field can't be empty");
                    e2.setError("This field can't be empty");
                    e3.setError("This field can't be empty");
                }

                else{
                    Toast.makeText(CA_Manager_Company_Registration.this, "Company Registered", Toast.LENGTH_SHORT).show();
                    e1.setText("");
                    e2.setText("");
                    e3.setText("");
                    e1.setError(null);
                    e2.setError(null);
                    e3.setError(null);
                }
            }
        });
    }
}
