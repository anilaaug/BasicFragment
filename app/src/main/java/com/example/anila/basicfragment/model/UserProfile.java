package com.example.anila.basicfragment.model;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.anila.basicfragment.R;
import com.example.anila.basicfragment.model.UserDetails;

public class UserProfile extends AppCompatActivity {

    TextView name,email,phone,dob,passWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        name=findViewById(R.id.user_name);
        email=findViewById(R.id.user_email);
        phone=findViewById(R.id.user_phone);
        dob=findViewById(R.id.user_dob);
        passWord=findViewById(R.id.user_password);
        name.setText("Name : "+ UserDetails.getUserFirst_Name()+" "+ UserDetails.getUserLast_Name());
        email.setText("Email : "+UserDetails.getEmail());
        phone.setText("phone : "+UserDetails.getPhoneNo());
        dob.setText("Dob : "+UserDetails.getDate_of_birth());
        passWord.setText("Password : "+UserDetails.getConfirmPassWord());






    }
}
