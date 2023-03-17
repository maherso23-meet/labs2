package com.example.a1stlab;

import androidx.annotation.NonNull;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class User {
    private static String Name;
    private String Password;
    private static String Email;
    public User(){

    }
    public User(String name, String password, String email) {
        Name = name;
        Password = password;
        Email = email;
    }

    public static String getName() {
        return Name;
    }

    public String getPassword() {
        return Password;
    }

    public static String getEmail() {
        return Email;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void setEmail(String email) {
        Email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "Name='" + Name + '\'' +
                ", Password='" + Password + '\'' +
                ", Email='" + Email + '\'' +
                '}';
    }
}

