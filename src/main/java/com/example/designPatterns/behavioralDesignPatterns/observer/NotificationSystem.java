package com.example.designPatterns.behavioralDesignPatterns.observer;

import com.example.designPatterns.behavioralDesignPatterns.observer.services.AppService;
import com.example.designPatterns.behavioralDesignPatterns.observer.services.EmailService;
import com.example.designPatterns.behavioralDesignPatterns.observer.services.SMSService;

import java.util.ArrayList;
import java.util.List;

public class NotificationSystem implements Publisher {
    private static NotificationSystem instance;
    private final List<Observer> observers;

    private NotificationSystem() {
        observers = new ArrayList<>();
    }

    public static NotificationSystem getInstance() {
        if (instance == null) {
            synchronized (NotificationSystem.class) {
                if (instance == null) {
                    instance = new NotificationSystem();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        AppService appService = new AppService();
        EmailService emailService = new EmailService();
        SMSService smsService = new SMSService();

        NotificationSystem ns = NotificationSystem.getInstance();

        ns.updateNotifications("New Notification");
    }

    public void updateNotifications(String message) {
        for (Observer observer : observers) {
            observer.sendNotification(message);
        }
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
}
