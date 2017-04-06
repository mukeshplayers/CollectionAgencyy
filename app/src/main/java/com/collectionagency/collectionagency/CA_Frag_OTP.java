package com.collectionagency.collectionagency;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class CA_Frag_OTP extends Fragment {

    private View view;
    private Button btn_submit_otp;
    private Fragment frag_changepassword;

    private EditText forgot2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.ca_frag_otp, container, false);

        forgot2 = (EditText)view.findViewById(R.id.ca_et_otp);

        btn_submit_otp = (Button)view.findViewById(R.id.ca_btn_submit_otp);
        btn_submit_otp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(forgot2.getText().toString().isEmpty()){
                    forgot2.setError("This field can't be empty");
                }
                else {
                    frag_changepassword = new CA_Frag_ChangePassword();
                    FragmentManager fm = getActivity().getSupportFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.frag_forgotpassword, frag_changepassword);
                    ft.addToBackStack(null);
                    ft.commit();
                    forgot2.setText("");
                }
            }
        });

        return view;
    }
}
