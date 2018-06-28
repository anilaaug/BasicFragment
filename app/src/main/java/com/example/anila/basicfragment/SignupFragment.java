package com.example.anila.basicfragment;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.anila.basicfragment.R;
import com.example.anila.basicfragment.model.UserDetails;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignupFragment extends Fragment {

    Button msubmit;
    EditText mfirstName, mLastName, mEmail, mPhoneNo, mDateOfBirth, mPassWord, mConfirmPass;
    String mUserFirstName, mUserLastName, mUserPhoneNo, mUserEmail, mUserDob, mConfirmPassword;

    public SignupFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.signup, container, false);

        msubmit = view.findViewById(R.id.signup_button);
        mfirstName = view.findViewById(R.id.reg_fname);
        mLastName = view.findViewById(R.id.reg_lname);
        mEmail = view.findViewById(R.id.reg_email);
        mPhoneNo = view.findViewById(R.id.reg_phno);
        mDateOfBirth = view.findViewById(R.id.reg_dob);
        mPassWord = view.findViewById(R.id.reg_password);
        mConfirmPass = view.findViewById(R.id.reg_conifrm_passWord);
        msubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mUserFirstName = mfirstName.getText().toString().trim();
                mUserLastName = mLastName.getText().toString().trim();
                mUserPhoneNo = mPhoneNo.getText().toString().trim();
                mUserEmail = mEmail.getText().toString().trim();
                mUserDob = mDateOfBirth.getText().toString().trim();
                mConfirmPassword = mConfirmPass.getText().toString().trim();

                Pattern namePattern = Pattern.compile("[A-Za-z]{1,10}");
                Matcher firstnameMatch = namePattern.matcher(mUserFirstName);
                Matcher lastnameMatch = namePattern.matcher(mUserLastName);
                Pattern emailPattern = Pattern.compile("[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?\\.)+[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?");
                Matcher emailMatch = emailPattern.matcher(mUserEmail);
                Pattern phPattern = Pattern.compile("^[7-9][0-9]{9}$");
                Matcher phoneMatch = phPattern.matcher(mUserPhoneNo);
                //validation of the Name,PhoneNumber and email
                if (!(firstnameMatch.matches() || !(lastnameMatch.matches()))) {
                    mfirstName.setError("inappropriate Name");

                }
                if (!(emailMatch.matches())) {
                    mEmail.setError("Please enter a valid email address");
                }
                if (!(phoneMatch.matches())) {
                    mPhoneNo.setError("Please enter a valid phone number");
                } else {
                    Toast.makeText(getContext(), "UserRegistration completed", Toast.LENGTH_SHORT).show();
                    UserDetails.setUserDetails(mUserFirstName, mUserLastName, mUserPhoneNo, mUserEmail, mUserDob, mConfirmPassword);

                }

            }
        });
        mDateOfBirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar c = Calendar.getInstance();
                int currentYear, currentMonth, currentDay;
                currentYear = c.get(Calendar.YEAR);
                currentMonth = c.get(Calendar.MONTH);
                currentDay = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        mDateOfBirth.setText(dayOfMonth + "-" + month + "-" + year);
                    }
                }, currentYear, currentMonth, currentDay);
                datePickerDialog.show();
            }
        });

        return view;
    }


}
