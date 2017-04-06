package com.collectionagency.collectionagency.manager;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.collectionagency.collectionagency.R;

public class CA_Manager_ChangePassword extends AppCompatActivity {

    Button btn_chanagepassword;
    EditText oldpwd, newpwd, renewpwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ca_manager_change_password);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Change Password");
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        oldpwd = (EditText)findViewById(R.id.ca_et_manager_cp_oldpwd);
        newpwd = (EditText)findViewById(R.id.ca_et_manager_cp_newpwd);
        renewpwd = (EditText)findViewById(R.id.ca_et_manager_cp_reenterpwd);

        final String new1 = newpwd.getText().toString();
        final String new2 = renewpwd.getText().toString();

        btn_chanagepassword = (Button)findViewById(R.id.ca_btn_manager_cp);
        btn_chanagepassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (new1.equals(new2))
                {
                        Toast.makeText(CA_Manager_ChangePassword.this, "Password Changed Successfully!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(CA_Manager_ChangePassword.this, "Password Didn't Match.", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
}
