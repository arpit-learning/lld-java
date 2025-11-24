package com.example.concurrency.executorExample;

import java.util.concurrent.*;

public class TreeSizeCalculator implements Callable<Integer> {
    Node root;
    ExecutorService es;

    public TreeSizeCalculator(Node root, ExecutorService es) {
        this.root = root;
        this.es = es;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);

        ExecutorService es = Executors.newFixedThreadPool(10);
        TreeSizeCalculator heightCal = new TreeSizeCalculator(root, es);
        Future<Integer> hF = es.submit(heightCal);
        int h = hF.get();

        System.out.println(h);
        es.shutdown();
    }

    @Override
    public Integer call() throws ExecutionException, InterruptedException {
        int lfH = 0, rgH = 0;

        if (root.left != null) {
            TreeSizeCalculator leftHeightCal = new TreeSizeCalculator(root.left, es);
            Future<Integer> lfHF = es.submit(leftHeightCal);
            lfH = lfHF.get();
        }

        if (root.right != null) {
            TreeSizeCalculator rightHeightCal = new TreeSizeCalculator(root.right, es);
            Future<Integer> rgHF = es.submit(rightHeightCal);
            rgH = rgHF.get();
        }

        return lfH + rgH + 1;
    }
}