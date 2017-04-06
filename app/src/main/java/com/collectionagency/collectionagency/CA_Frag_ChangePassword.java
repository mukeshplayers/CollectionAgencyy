package com.collectionagency.collectionagency;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class CA_Frag_ChangePassword extends Fragment {

    private View view;
    private Button ca_chanage_pwd_done;

    private EditText forgot3, forgot4;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.ca_frag_chanagepassword, container, false);

        forgot3 = (EditText)view.findViewById(R.id.ca_et_cp_newpwd);
        forgot4 = (EditText)view.findViewById(R.id.ca_et_cp_renewpwd);

        ca_chanage_pwd_done = (Button)view.findViewById(R.id.ca_btn_cp_done);
        ca_chanage_pwd_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (forgot3.getText().toString().isEmpty() || forgot4.getText().toString().isEmpty()){
                    forgot3.setError("This field can't be empty");
                    forgot4.setError("This field can't be empty");
                }
                else {
                    Intent intent = new Intent(getActivity(), MainActivity.class);
                    startActivity(intent);
                    forgot3.setText("");
                    forgot4.setText("");
                }
            }
        });

        return view;
    }
}
