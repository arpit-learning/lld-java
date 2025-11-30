package com.example.concurrency.synchronisation.semaphore;

public class Item {
    private final String name;

    public Item(String name, String producerName) {
        this.name = name;
        System.out.println(name + " created by " + producerName);
    }

    public String getName() {
        return name;
    }
}
