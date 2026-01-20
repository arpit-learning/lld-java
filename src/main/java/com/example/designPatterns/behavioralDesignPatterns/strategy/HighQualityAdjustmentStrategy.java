package com.example.designPatterns.behavioralDesignPatterns.strategy;

public class HighQualityAdjustmentStrategy implements QualityAdjustmentStrategy {
    @Override
    public Video adjust(Video video) {
        video.setCodec(VideoCodec.VP9);
        video.setBitrate(2000);
        return video;
    }

    @Override
    public VideoQuality supportsType() {
        return VideoQuality.HIGH;
    }

}