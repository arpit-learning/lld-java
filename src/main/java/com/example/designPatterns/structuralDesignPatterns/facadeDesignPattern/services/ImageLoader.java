package com.example.designPatterns.structuralDesignPatterns.facadeDesignPattern.services;

import com.example.designPatterns.structuralDesignPatterns.facadeDesignPattern.models.Image;

public class ImageLoader {
    public Image loadImage(String imagePath) {
        return new Image();
    }
}
