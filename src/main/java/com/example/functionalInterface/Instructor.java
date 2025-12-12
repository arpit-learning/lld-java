package com.example.functionalInterface;

@FunctionalInterface // no use case, only for better readability, similar to @Override
public interface Instructor<T> {
    void teach(int numberOfStudents, T topic);
}
