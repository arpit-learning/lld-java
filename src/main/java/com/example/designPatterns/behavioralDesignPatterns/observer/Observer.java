package com.example.designPatterns.behavioralDesignPatterns.observer;

public abstract class Observer {
    public Observer() {
        NotificationSystem.getInstance().addObserver(this);
    }

    public abstract void sendNotification(String message);
}
