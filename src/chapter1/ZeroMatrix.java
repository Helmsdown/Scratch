package chapter1;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by russellb337 on 11/5/14.
 */
public class ZeroMatrix {

    public static void main(String[] args) {
        int[][] matrix = createMatrix(6, 5);
        System.out.println("[Starting Matrix]");
        printImage(matrix);

        zeroOut(matrix);

        System.out.println("\n[Ending Matrix]");
        printImage(matrix);
    }

    private static void zeroOut(int[][] matrix) {
        Set<Integer> rowsToZero = new HashSet<>();
        Set<Integer> columnsToZero = new HashSet<>();

        for (int column = 0; column < matrix.length; column++) {
            for (int row = 0; row < matrix[0].length; row++) {
                if(matrix[column][row] == 0) {
                    System.out.println(column + "," + row);
                    columnsToZero.add(column);
                    rowsToZero.add(row);
                }
            }
        }

        for (Integer column : columnsToZero) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[column][i] = 0;
            }
        }

        for (Integer row : rowsToZero) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][row] = 0;
            }
        }
    }

    private static int[][] createMatrix(int n, int m) {
        Random r = new Random(System.currentTimeMillis());

        int[][] pixels = new int[n][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                pixels[j][i] = r.nextInt(10);
            }
        }

        return pixels;
    }

    private static void printImage(int[][] image) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < image[0].length; i++) {
            for (int j = 0; j < image.length; j++) {
                builder.append(String.format("%02d", image[j][i])).append(",");
            }
            builder.append("\n");
        }

        System.out.println(builder);

    }
}
