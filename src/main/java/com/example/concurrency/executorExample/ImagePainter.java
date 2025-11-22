package com.example.concurrency.executorExample;

import java.util.concurrent.*;

class ImageQuadrantPainter implements Callable<int[][]> {
    int startRow, endRow, startCol, endCol, color;
    private int[][] image;

    public ImageQuadrantPainter(int startRow, int endRow, int startCol, int endCol, int color) {
        this.startRow = startRow;
        this.endRow = endRow;
        this.startCol = startCol;
        this.endCol = endCol;
        this.color = color;
        this.image = new int[endRow - startRow + 1][endCol - startCol + 1];
    }

    @Override
    public int[][] call() {
        //Todo: Iterate over the quadrant to fill it with given color
        for (int i = startRow; i <= endRow; i++) {
            for (int j = startCol; j <= endCol; j++) {
                this.image[i][j] = color;
            }
        }

        return this.image;
    }
}

public class ImagePainter {
    private int[][] image;

    public ImagePainter(int[][] image) {
        this.image = image;
    }

    public static void main(String[] args) throws InterruptedException {
        int[][] image = new int[4][4]; // Example 4x4 image
        ImagePainter painter = new ImagePainter(image);
        painter.paintImage(1);

        int[][] paintedImage = painter.getImage();
        // Print the painted image (for demonstration purposes)
        for (int[] row : paintedImage) {
            for (int pixel : row) {
                System.out.print(pixel + " ");
            }
            System.out.println();
        }
    }

    public void paintImage(int color) throws InterruptedException {
        int rows = image.length;
        int cols = image[0].length;
        int halfRows = (rows + 1) / 2;
        int halfCols = (cols + 1) / 2;

        ExecutorService executor = Executors.newFixedThreadPool(4);
        ImageQuadrantPainter quadPainter1 = new ImageQuadrantPainter(0, halfRows - 1, 0, halfCols - 1, color);
        ImageQuadrantPainter quadPainter2 = new ImageQuadrantPainter(0, halfRows - 1, 0, halfCols - 1, 2 * color);
        ImageQuadrantPainter quadPainter3 = new ImageQuadrantPainter(0, halfRows - 1, 0, halfCols - 1, 3 * color);
        ImageQuadrantPainter quadPainter4 = new ImageQuadrantPainter(0, halfRows - 1, 0, halfCols - 1, 4 * color);
        // A sample quadrant call will look like this, here we are using the lambda function to pass a runnable!
        Future<int[][]> q1F = executor.submit(quadPainter1); // Top-left quadrant
        Future<int[][]> q2F = executor.submit(quadPainter2); // Top-left quadrant
        Future<int[][]> q3F = executor.submit(quadPainter3); // Top-left quadrant
        Future<int[][]> q4F = executor.submit(quadPainter4); // Top-left quadrant

        try {
            // Todo: Wait for the tasks to finish by calling the .get() method of future objects
            int[][] q1 = q1F.get();
            int[][] q2 = q2F.get();
            int[][] q3 = q3F.get();
            int[][] q4 = q4F.get();

            for (int i = 0; i < q1.length; i++) {
                for (int j = 0; j < q1[0].length; j++) {
                    this.image[i][j] = q1[i][j];
                }
            }

            for (int i = 0; i < q2.length; i++) {
                for (int j = 0; j < q2[0].length; j++) {
                    this.image[i][halfCols + j] = q2[i][j];
                }
            }

            for (int i = 0; i < q3.length; i++) {
                for (int j = 0; j < q3[0].length; j++) {
                    this.image[halfRows + i][j] = q3[i][j];
                }
            }

            for (int i = 0; i < q4.length; i++) {
                for (int j = 0; j < q4[0].length; j++) {
                    this.image[halfRows + i][halfCols + j] = q4[i][j];
                }
            }

        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        //Todo: Shutdown the executor once all tasks have been done
        executor.shutdown();
    }

    public int[][] getImage() {
        return image;
    }
}








