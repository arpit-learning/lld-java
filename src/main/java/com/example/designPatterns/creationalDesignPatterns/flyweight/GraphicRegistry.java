package com.example.designPatterns.creationalDesignPatterns.flyweight;

import java.util.HashMap;
import java.util.Map;

public class GraphicRegistry implements FlyweightRegistry {
    Map<GraphicType, GraphicIntrinsicState> registry;

    public GraphicRegistry() {
        registry = new HashMap<>();
    }

    @Override
    public void addFlyweight(GraphicIntrinsicState flyweight) {
        registry.put(flyweight.getType(), flyweight);
    }

    @Override
    public GraphicIntrinsicState getFlyweight(GraphicType graphicType) {
        return registry.get(graphicType);
    }

}
