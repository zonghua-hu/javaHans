package com.example.javahans.service;

/**
 * 雇员类
 */
public class Employ
{
    /**
     * 名字
     */
    String name;
    /**
     * 年龄
     */
    public int age;
    /**
     * 职位描述
     */
    String description;
    /**
     * 工资
     */
    double salary;

    public Employ(String name)
    {
        this.name = name;
    }

    public void empAge(int age)
    {
        this.age = age;
    }

    public void setDescription(String desc)
    {
        this.description = desc;
    }

    public void setSalary(Double empSalary)
    {
        this.salary = empSalary;
    }

    /**
     * 雇员信息打印
     */
    public void printEmployee()
    {
        System.out.println("名字:"+ name);
        System.out.println("年龄:" + age);
        System.out.println("职位:" + description);
        System.out.println("薪水:" + salary);
    }
}
