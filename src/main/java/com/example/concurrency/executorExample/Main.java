package com.example.concurrency.executorExample;

import com.example.concurrency.basicExample.PrintingNumbersRunner;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(10);
        for (int i = 1; i <= 100; i++) {
            PrintingNumbersRunner pr = new PrintingNumbersRunner(i);
            es.submit(pr);
        }

        ExecutorService es2 = Executors.newFixedThreadPool(1);
        ArrayCreator ac = new ArrayCreator(100);
        Future<ArrayList<Integer>> alF = es2.submit(ac);

        ArrayList<Integer> al = alF.get();

        System.out.println(al);
        es.shutdown();
        es2.shutdown();
    }
}
