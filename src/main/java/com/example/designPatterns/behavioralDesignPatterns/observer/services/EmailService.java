package com.example.designPatterns.behavioralDesignPatterns.observer.services;

import com.example.designPatterns.behavioralDesignPatterns.observer.Observer;

public class EmailService extends Observer {
    @Override
    public void sendNotification(String message) {
        System.out.println("Printing Email Notification : " + message);
    }
}
