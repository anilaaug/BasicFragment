package com.example.anila.basicfragment.model;

public class UserDetails
{
    private  static String userFirst_Name, userLast_Name, userEmail, phoneNo, date_of_birth, confirmPassWord;


    public static void setUserDetails(String name, String name2, String phone, String email, String dob, String confirm)
    {

        userFirst_Name = name;
        userLast_Name = name2;
        userEmail = email;
        phoneNo = phone;
        date_of_birth = dob;
        confirmPassWord = confirm;

    }
    public static String getUserFirst_Name()
    {
        return userFirst_Name;
    }

    public static String getUserLast_Name()
    {
        return userLast_Name;
    }

    public  static String getEmail()
    {
        return userEmail;
    }

    public static String getPhoneNo()
    {
        return phoneNo;
    }

    public  static String getDate_of_birth()
    {
        return date_of_birth;
    }

    public  static String getConfirmPassWord()
    {
        return confirmPassWord;
    }

    public  void main(String[] args) { }
}

