package com.example.designPatterns.creationalDesignPatterns.flyweight;

@IntrinsicState
public class GraphicIntrinsicState {
    private Image image; // Text content or image file path
    private int width, height; // Dimensions
    private String color; // Font color for text or image format for images
    private GraphicType type;
}
