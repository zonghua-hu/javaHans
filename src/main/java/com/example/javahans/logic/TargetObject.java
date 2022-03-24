package com.example.javahans.logic;

public class TargetObject {
    public String value;
    public TargetObject()
    {
        value = "javaHans";
    }
    public void publicMethod(String s)
    {
        System.out.println("I Love " + s);
    }
    private void privateMethod()
    {
        System.out.println("value is " + value);
    }
}
