package com.example.designPatterns.creationalDesignPatterns.flyweight;

@ExtrinsicState
public class GraphicExtrinsicState {
    private GraphicIntrinsicState graphicIntrinsicState;
    private int x, y; // Coordinates

    public GraphicIntrinsicState getGraphicIntrinsicState() {
        return graphicIntrinsicState;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
