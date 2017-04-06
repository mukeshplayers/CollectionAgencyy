package com.collectionagency.collectionagency.manager;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v4.app.DialogFragment;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.collectionagency.collectionagency.R;

import java.util.Calendar;


public class CA_Manager_Agent_Registration extends AppCompatActivity {
    public static TextView SelectedDateView;
    private Button btn_register;
    private RadioButton r1;

    private EditText a1, a2, a3, a4, a5, a6, a7, a8, a9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ca_manager_agent_registration);
        SelectedDateView = (TextView)findViewById(R.id.ca_agent_dob);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Agent Registration");
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        a1 = (EditText)findViewById(R.id.ca_agent_firstname);
        a2 = (EditText)findViewById(R.id.ca_agent_lastname);
        a3 = (EditText)findViewById(R.id.ca_agent_address);
        a4 = (EditText)findViewById(R.id.ca_agent_area);
        a5 = (EditText)findViewById(R.id.ca_agent_pincode);
        a6 = (EditText)findViewById(R.id.ca_agent_email_id);
        a7 = (EditText)findViewById(R.id.ca_agent_phone_number);
        a8 = (EditText)findViewById(R.id.ca_agent_password);
        a9 = (EditText)findViewById(R.id.ca_agent_aadhar_number);

        r1 = (RadioButton)findViewById(R.id.ca_agent_male);

        btn_register = (Button)findViewById(R.id.ca_btn_register);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean flag = false;
                if (a1.getText().toString().isEmpty() &&
                        a2.getText().toString().isEmpty() &&
                        a3.getText().toString().isEmpty() &&
                        a4.getText().toString().isEmpty() &&
                        a5.getText().toString().isEmpty() &&
                        a6.getText().toString().isEmpty() &&
                        a7.getText().toString().isEmpty() &&
                        a8.getText().toString().isEmpty() &&
                        a9.getText().toString().isEmpty())
                {
                    a1.setError("This field can't be empty");
                    a2.setError("This field can't be empty");
                    a3.setError("This field can't be empty");
                    a4.setError("This field can't be empty");
                    a5.setError("This field can't be empty");
                    a6.setError("This field can't be empty");
                    a7.setError("This field can't be empty");
                    a8.setError("This field can't be empty");
                    a9.setError("This field can't be empty");
                }

                else {
                    Toast.makeText(CA_Manager_Agent_Registration.this, "Agent Regitered Successfully.", Toast.LENGTH_SHORT).show();
                    a1.setText("");
                    a2.setText("");
                    a3.setText("");
                    a4.setText("");
                    a5.setText("");
                    a6.setText("");
                    a7.setText("");
                    a8.setText("");
                    a9.setText("");
                    a1.setError(null);
                    a2.setError(null);
                    a3.setError(null);a4.setError(null);a5.setError(null);
                    a6.setError(null);a7.setError(null);a8.setError(null);
                    a9.setError(null);


                }
            }
        });

    }

    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            SelectedDateView.setText("Selected Date: " + (month + 1) + "-" + day + "-" + year);
        }
    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }
}
