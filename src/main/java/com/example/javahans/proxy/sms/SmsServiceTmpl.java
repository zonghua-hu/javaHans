package com.example.javahans.proxy.sms;

public class SmsServiceTmpl implements SmsService{
    @Override
    public String send(String message) {
        System.out.println("send message:" + message);
        return message;
    }
}
