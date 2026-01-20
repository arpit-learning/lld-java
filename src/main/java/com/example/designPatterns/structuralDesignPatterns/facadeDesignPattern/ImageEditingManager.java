package com.example.designPatterns.structuralDesignPatterns.facadeDesignPattern;

import com.example.designPatterns.structuralDesignPatterns.facadeDesignPattern.services.*;

public class ImageEditingManager {

    private ImageEditingFacade facade;

    public ImageEditingManager(ImageLoader imageLoader, FilterService filterService, ImageModifier imageModifier, ImageWriter imageWriter, AnalyticsService analyticsService) {
        this.facade = new ImageEditingFacade(imageLoader, filterService, imageModifier, imageWriter, analyticsService);
    }

    public void editImage(String imagePath, String filterType, int brightness) {
        this.facade.editImage(imagePath, filterType, brightness);
    }

}