package com.example.concurrency.basicExample;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort implements Runnable {
    private final ArrayList<Integer> list;
    private final int s;
    private final int e;

    public MergeSort(ArrayList<Integer> list, int s, int e) {
        this.list = list;
        this.s = s;
        this.e = e;
    }

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 3, 6, 5, 6, 12, 3, 5, 23, 5, 2, 2));
        MergeSort ms = new MergeSort(list, 0, list.size() - 1);

        System.out.println(list);
        ms.mergeSort();
        System.out.println(list);
    }

    public void merge(ArrayList<Integer> list, int s, int m, int e) {
        int i = s, j = m + 1;
        ArrayList<Integer> temp = new ArrayList<>();
        while (i <= m && j <= e) {
            if (list.get(i) <= list.get(j)) {
                temp.add(list.get(i));
                i++;
            } else {
                temp.add(list.get(j));
                j++;
            }
        }

        while (i <= m) {
            temp.add(list.get(i));
            i++;
        }

        while (j <= e) {
            temp.add(list.get(j));
            j++;
        }

        for (int k = s; k <= e; k++) {
            list.set(k, temp.get(k - s));
        }
    }

    @Override
    public void run() {
        try {
            mergeSort();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void mergeSort() throws InterruptedException {
        if (e <= s) {
            return;
        }
        System.out.println(Thread.currentThread().getName() + " " + s + " " + e);
        int mid = s + (e - s) / 2;
        MergeSort a = new MergeSort(list, s, mid);
        MergeSort b = new MergeSort(list, mid + 1, e);
        Thread t1 = new Thread(a);
        Thread t2 = new Thread(b);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        merge(list, s, mid, e);
    }
}
