package com.example.myapplication;

import androidx.annotation.NonNull;

public class Student {
    private final String Name;
    private int Age;
    private String Email;

    public Student(String name, int age, String email){
        this.Name = name;
        this.Age = age;
        this.Email = email;
    }

    @NonNull
    @Override
    public String toString()
    {
        return "Name: " + Name + " Age: "+ Age + " Email: " + Email;
    }
}
