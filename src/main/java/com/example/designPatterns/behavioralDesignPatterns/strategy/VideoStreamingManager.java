package com.example.designPatterns.behavioralDesignPatterns.strategy;

public class VideoStreamingManager {
    private Video video;
    private QualityAdjustmentStrategy strategy;

    public VideoStreamingManager(Video video, QualityAdjustmentStrategy strategy) {
        this.video = video;
        this.strategy = strategy;
    }

    public Video streamVideo() {
        return strategy.adjust(video);
    }
}
