package com.example.designPatterns.behavioralDesignPatterns.strategy;

public class LowQualityAdjustmentStrategy implements QualityAdjustmentStrategy {

    @Override
    public Video adjust(Video video) {
        video.setCodec(VideoCodec.H264);
        video.setBitrate(500);
        return video;
    }

    @Override
    public VideoQuality supportsType() {
        return VideoQuality.LOW;
    }

}
