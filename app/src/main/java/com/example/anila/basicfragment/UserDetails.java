package com.example.anila.basicfragment;

public class UserDetails
{
    private static String userFirst_Name, userLast_Name, email, phoneNo, date_of_birth, confirmPassWord;
    UserDetails(String name, String name2, String phone, String email, String dob, String confirm)
    {
        this.userFirst_Name = name;
        this.userLast_Name = name2;
        this.email = email;
        this.phoneNo = phone;
        this.date_of_birth = dob;
        this.confirmPassWord = confirm;
    }

    public static String getUserFirst_Name()
    {
        return userFirst_Name;
    }

    public static String getUserLast_Name()
    {
        return userLast_Name;
    }

    public static String getEmail()
    {
        return email;
    }

    public static String getPhoneNo()
    {
        return phoneNo;
    }

    public static String getDate_of_birth()
    {
        return date_of_birth;
    }

    public static String getConfirmPassWord()
    {
        return confirmPassWord;
    }

    public static void main(String[] args) { }
}

