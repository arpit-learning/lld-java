package com.example.generics;

public abstract class Item {
    private static String next_id = "1";
    private String id;
    private String name;
    private double price;

    public Item(String name, double price) {
        this.id = next_id;
        next_id = String.valueOf(Integer.parseInt(next_id) + 1);
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
