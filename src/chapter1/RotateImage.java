package chapter1;

import java.util.Random;

/**
 * Created by russellb337 on 11/4/14.
 */
public class RotateImage {


    public static void main(String[] args) {
        int[][] image = createImage(5);
        System.out.println("[Starting Image]");
        printImage(image);

        rotateImage(image, 5);

        System.out.println("\n[Final Image]");
        printImage(image);
    }

    private static void rotateImage(int[][] image, int n) {

        int nPasses = n / 2; //the number of passes to make, integer division
        int nPixelsToMove = n - 1; //you start off moving one less than the length of the the matrix

        for (int pass = 0; pass < nPasses; pass++) {

            int yCoord = pass;
            for (int pixelIndex = 0; pixelIndex < nPixelsToMove; pixelIndex++) {
                int xCoord = pixelIndex + pass;
                rotatePixels(image, xCoord, yCoord);
            }

            nPixelsToMove -= 2; //each layer should have two less pixels to move
        }
    }

    private static void rotatePixels(int[][] image, int startX, int startY) {
        int currentX = startX;
        int currentY = startY;
        int destinationX = newX(startY, image[0].length);
        int destinationY = newY(startX);

        int valueToSave = image[destinationX][destinationY];
        int valueToMove = image[currentX][currentY];
        for (int i = 0; i < 4; i++) {
            image[destinationX][destinationY] = valueToMove;

            currentX = destinationX;
            currentY = destinationY;
            destinationX = newX(currentY, image[0].length);
            destinationY = newY(currentX);
            valueToMove = valueToSave;
            valueToSave = image[destinationX][destinationY];
        }
    }

    private static int newX(int y, int n) {
        return (n - 1) - y;
    }

    private static int newY(int x) {
        return x;
    }

    private static void printImage(int[][] image) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < image[0].length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                builder.append(String.format("%02d", image[j][i])).append(",");
            }
            builder.append("\n");
        }

        System.out.println(builder);

    }

    private static int[][] createImage(int n) {
        Random r = new Random(System.currentTimeMillis());

        int[][] pixels = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                pixels[j][i] = r.nextInt(100);
            }
        }

        return pixels;
    }
}
