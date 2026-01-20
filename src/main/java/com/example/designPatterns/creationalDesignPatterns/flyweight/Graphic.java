package com.example.designPatterns.creationalDesignPatterns.flyweight;

public class Graphic {
    private GraphicIntrinsicState graphicIntrinsicState;
    private GraphicExtrinsicState graphicExtrinsicState;

    public GraphicIntrinsicState getGraphicIntrinsicState() {
        return graphicIntrinsicState;
    }

    public GraphicExtrinsicState getGraphicExtrinsicState() {
        return graphicExtrinsicState;
    }

}

