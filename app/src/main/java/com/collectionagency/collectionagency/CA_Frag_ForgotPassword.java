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

public class CA_Frag_ForgotPassword extends Fragment {
    private View view;
    private Button generate_otp;
    private Fragment frag_otp;

    private EditText forgot1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.ca_frag_forgotpassword,container,false);

        forgot1 = (EditText)view.findViewById(R.id.ca_et_emailphone);


        generate_otp = (Button)view.findViewById(R.id.ca_btn_generate_otp);
        generate_otp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(forgot1.getText().toString().isEmpty()){
                    forgot1.setError("This field can't be empty");
                }
                else {
                    frag_otp = new CA_Frag_OTP();
                    FragmentManager fm = getActivity().getSupportFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.frag_forgotpassword, frag_otp);
                    ft.addToBackStack(null);
                    ft.commit();
                    forgot1.setText("");
                }
            }
        });

        return view;
    }
}
