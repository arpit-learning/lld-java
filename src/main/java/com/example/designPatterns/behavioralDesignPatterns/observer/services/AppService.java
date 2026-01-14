package com.example.designPatterns.behavioralDesignPatterns.observer.services;

import com.example.designPatterns.behavioralDesignPatterns.observer.Observer;

public class AppService extends Observer {
    @Override
    public void sendNotification(String message) {
        System.out.println("Printing Push Notification : " + message);
    }
}
