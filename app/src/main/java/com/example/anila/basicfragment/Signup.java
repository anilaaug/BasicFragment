package com.example.anila.basicfragment;

import android.app.DatePickerDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.anila.basicfragment.model.UserDetails;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Signup extends Fragment {

    Button submit;
    EditText firstName, lastName, email, phoneNo, dateOfBirth, passWord, confirmPass;
    String userFirstName, userLastName, userPhoneno, userEmail, userDob, confirmPassword;

    public Signup() {

    }
    public static Signup newInstance(String param1, String param2) {
        Signup fragment = new Signup();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.signup, container, false);

        submit= view.findViewById(R.id.signup_button);
        firstName = view.findViewById(R.id.reg_fname);
        lastName = view.findViewById(R.id.reg_lname);
        email = view.findViewById(R.id.reg_email);
        phoneNo = view.findViewById(R.id.reg_phno);
        dateOfBirth = view.findViewById(R.id.reg_dob);
        passWord = view.findViewById(R.id.reg_password);
        confirmPass = view.findViewById(R.id.reg_conifrm_passWord);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userFirstName = firstName.getText().toString().trim();
                userLastName = lastName.getText().toString().trim();
                userPhoneno = phoneNo.getText().toString().trim();
                userEmail = email.getText().toString().trim();
                userDob = dateOfBirth.getText().toString().trim();
                confirmPassword = confirmPass.getText().toString().trim();

                Pattern namePattern = Pattern.compile("[A-Za-z]{1,10}");
                Matcher firstnameMatch = namePattern.matcher(userFirstName);
                Matcher lastnameMatch = namePattern.matcher(userLastName);
                Pattern emailPattern = Pattern.compile("[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?\\.)+[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?");
                Matcher emailMatch = emailPattern.matcher(userEmail);
                Pattern phPattern = Pattern.compile("^[7-9][0-9]{9}$");
                Matcher phoneMatch = phPattern.matcher(userPhoneno);
                //validation of the Name,PhoneNumber and email
                if(!(firstnameMatch.matches()||!(lastnameMatch.matches())))
                {
                    firstName.setError("inappropriate Name");

                }
                if(!(emailMatch.matches())){
                    email.setError("Please enter a valid email address");
                }
                if(!(phoneMatch.matches()))
                {
                    phoneNo.setError("Please enter a valid phone number");
                }
                else {
                    Toast.makeText(getContext(), "UserRegistration completed", Toast.LENGTH_SHORT).show();
                    UserDetails.setUserDetails(userFirstName, userLastName, userPhoneno, userEmail, userDob, confirmPassword);
                    //Intent myIntent = new Intent(SignUp.this, Login.class);
                    //SignUp.this.startActivity(myIntent);
                }

            }
        });
        dateOfBirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar c = Calendar.getInstance();
                int currentYear,currentMonth,currentDay;
                currentYear = c.get(Calendar.YEAR);
                currentMonth = c.get(Calendar.MONTH);
                currentDay = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener()
                {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        dateOfBirth.setText(dayOfMonth+"-"+month+"-"+year);
                    }
                }, currentYear, currentMonth, currentDay);
                datePickerDialog.show();
            }
        });
;
//        }
        return view;
    }






}
