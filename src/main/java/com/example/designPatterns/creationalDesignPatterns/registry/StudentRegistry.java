package com.example.designPatterns.creationalDesignPatterns.registry;

import java.util.HashMap;

public class StudentRegistry {
    public static StudentRegistry instance;
    HashMap<BatchType, Student> registry;

    public StudentRegistry() {
        registry = new HashMap<>();
    }

    public static StudentRegistry getInstance() {
        if (instance == null) {
            synchronized (StudentRegistry.class) {
                if (instance == null) {
                    instance = new StudentRegistry();
                }
            }
        }
        return instance;
    }

    public void addPrototype(BatchType type, Student prototype) {
        registry.put(type, prototype);
    }

    public Student getPrototype(BatchType type) {
        return registry.get(type);
    }

    public Student remotePrototype(BatchType type) {
        return registry.remove(type);
    }
}
