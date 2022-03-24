package com.example.javahans.controller;

import com.example.javahans.annotion.TestMathAnnotion;

public class NoBug
{
    @TestMathAnnotion
    public void suanShu()
    {
        System.out.println("123456");
    }
    @TestMathAnnotion
    public void addMethod()
    {
        System.out.println("1+10="+Math.addExact(1,10));
    }
    @TestMathAnnotion
    public void subtractionMethod()
    {
        System.out.println("10-1=" + Math.subtractExact(10,1));
    }
    @TestMathAnnotion
    public void multiplicationMethod()
    {
        System.out.println("9*8=" + Math.multiplyExact(9,8));
    }
    @TestMathAnnotion
    public void divisionMethod()
    {
        System.out.println("18/0=" + Math.floorDiv(18,0));
    }
    public void echoBug()
    {
        System.out.println("my code is no bug");
    }
}
