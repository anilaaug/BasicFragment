package com.example.anila.basicfragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.anila.basicfragment.app.image.ImageHomeActivity;
import com.example.anila.basicfragment.model.UserDetails;
import com.example.anila.basicfragment.model.UserProfile;

public class LoginFragment extends Fragment {

    Button mLoginButton;
    EditText mUserName, mPassWord;
    String mLoginName, mLoginPassword;
    ImageView mPreviousButton;

    public LoginFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login, container, false);
        mLoginButton = view.findViewById(R.id.login_button);
        mUserName = view.findViewById(R.id.login_email);
        mPassWord = view.findViewById(R.id.login_password);
        mPreviousButton = view.findViewById(R.id.previous_image);
        mPreviousButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getContext(), ImageHomeActivity.class);
                startActivity(myIntent);
            }
        });
        mLoginButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                mLoginName = mUserName.getText().toString().trim();
                mLoginPassword = mPassWord.getText().toString().trim();

                //Validation of the Email and password in the login page
                if (mLoginName.equals(UserDetails.getEmail()) && mLoginPassword.equals(UserDetails.getConfirmPassWord())) {
                    Intent myIntent = new Intent(getContext(), UserProfile.class);
                    startActivity(myIntent);
                }
            }
        });
        return view;
    }
}
