package com.example.designPatterns.behavioralDesignPatterns.observer;

public interface Publisher {
    void addObserver(Observer observer);

    void removeObserver(Observer observer);
}
