package com.example.designPatterns.behavioralDesignPatterns.observer.services;

import com.example.designPatterns.behavioralDesignPatterns.observer.Observer;

public class SMSService extends Observer {
    @Override
    public void sendNotification(String message) {
        System.out.println("Printing SMS Notification : " + message);
    }
}
