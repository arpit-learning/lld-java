package com.example.concurrency.executorExample;

import java.util.ArrayList;
import java.util.concurrent.Callable;

public class ArrayCreator implements Callable<ArrayList<Integer>> {
    private int n;

    public ArrayCreator(int n) {
        this.n = n;
    }

    @Override
    public ArrayList<Integer> call() {
        ArrayList<Integer> al = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            al.add(i);
        }

        return al;
    }
}
