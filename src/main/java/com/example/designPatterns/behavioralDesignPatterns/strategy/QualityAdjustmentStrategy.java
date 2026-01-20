package com.example.designPatterns.behavioralDesignPatterns.strategy;

public interface QualityAdjustmentStrategy {
    Video adjust(Video video);

    VideoQuality supportsType();
}