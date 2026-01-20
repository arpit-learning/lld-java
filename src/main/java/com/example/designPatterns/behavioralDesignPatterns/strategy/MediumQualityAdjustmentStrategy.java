package com.example.designPatterns.behavioralDesignPatterns.strategy;

public class MediumQualityAdjustmentStrategy implements QualityAdjustmentStrategy {

    @Override
    public Video adjust(Video video) {
        video.setCodec(VideoCodec.H265);
        video.setBitrate(1000);
        return video;
    }

    @Override
    public VideoQuality supportsType() {
        return VideoQuality.MEDIUM;
    }

}
