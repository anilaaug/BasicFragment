package com.example.anila.basicfragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class Login extends Fragment {

    Button loginButton;
    EditText userName,passWord;
    String loginName,loginPassword;
    public Login() {

    }



    public static Login newInstance(String param1, String param2) {
        Login fragment = new Login();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.login, container, false);
        loginButton=view.findViewById(R.id.login_button);
        userName=view.findViewById(R.id.login_email);
        passWord=view.findViewById(R.id.login_password);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginName = userName.getText().toString().trim();
                loginPassword = passWord.getText().toString().trim();
                //Validation of the Email and password in the login page
                if (loginName.equals(UserDetails.getEmail()) && loginPassword.equals(UserDetails.getConfirmPassWord())) {
                    Intent myIntent=new Intent(getContext(),Profile.class);
                    Login.this.startActivity(myIntent);
                }
            }
        });
        return view;
    }


    public void onButtonPressed(Uri uri) {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }


}
