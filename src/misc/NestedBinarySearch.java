package misc;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by russellb337 on 11/25/14.
 */
public class NestedBinarySearch {



    public static Tuple<Integer, Integer> doubleArrayBinarySearch(int[][] array, int searchValue) {

        int currentMin;
        int currentMax = (array.length*array[0].length)-1;

        Tuple<Integer, Integer> result = null;
        int currentMiddle = currentMax / 2;

        while(true) {

            int x = currentMiddle / array.length;
            int y = currentMiddle % array[0].length;
            int valueAtCurrentMiddle = array[x][y];

            if(valueAtCurrentMiddle == searchValue) {
                result = new Tuple<>(x, y);
                break;
            } else if (valueAtCurrentMiddle < searchValue) {
                //we need to move to the right of the logical array
                currentMin = currentMiddle;
                currentMiddle += (currentMax - currentMiddle) / 2;
                if(currentMin == currentMiddle) break;
            } else if (valueAtCurrentMiddle > searchValue) {
                //we need to move to the left of the logical array
                currentMax = currentMiddle;
                currentMiddle /= 2;
                if(currentMax == currentMiddle) break;
            }
        }

        return result;
    }



    public static class Tuple<X, Y> {
        public final X x;
        public final Y y;
        public Tuple(X x, Y y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Tuple{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Tuple tuple = (Tuple) o;

            if (x != null ? !x.equals(tuple.x) : tuple.x != null) return false;
            if (y != null ? !y.equals(tuple.y) : tuple.y != null) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = x != null ? x.hashCode() : 0;
            result = 31 * result + (y != null ? y.hashCode() : 0);
            return result;
        }
    }

    public static void main(String[] args) {
        int[][] array = new int[4][4];

        int n = 1;
        Random r = new Random(System.currentTimeMillis());

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {

                array[i][j] = n;
                n+=2;
            }
        }

        printArray(array);
        Tuple<Integer, Integer> integerIntegerTuple = doubleArrayBinarySearch(array, 4);

        System.out.println("Found value at " + integerIntegerTuple);

    }

    public static void printArray(int[][] array) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            builder.append(i).append(": ");
            builder.append(Arrays.toString(array[i]));
            builder.append("\n");
        }

        System.out.println(builder.toString());
    }

}
