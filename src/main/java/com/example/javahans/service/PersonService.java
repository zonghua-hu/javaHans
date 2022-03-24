package com.example.javahans.service;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

public class PersonService implements BeanFactoryAware
{
    private BeanFactory beanFactoryAware;

    @Override
    public void setBeanFactory(BeanFactory beanFactory)
    {
        this.beanFactoryAware = beanFactory;
    }
    public void add()
    {
        PersonService personService = (PersonService)beanFactoryAware.getBean("Employe");
    }
}
