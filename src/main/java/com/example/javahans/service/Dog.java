package com.example.javahans.service;

public class Dog
{
    int dogAge;

    public Dog(String name)
    {
        System.out.println("this is dog name:" + name);
    }
    public void setDogAge(int age)
    {
        dogAge = age;
    }
    public int getDogAge()
    {
        return dogAge;
    }
}
