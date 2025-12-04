package com.example.generics;

import java.util.ArrayList;
import java.util.List;

public class Inventory<T extends Item> {
    List<T> items = new ArrayList<>();
}
