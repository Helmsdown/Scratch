package misc;

import java.util.*;

/**
 * Created by russellb337 on 11/10/14.
 *
 * Write a function that takes an array of unique integers, and a target integer. The function should return
 * a list of tuples of values in the array that add up to the target integer.
 *
 * For example: [0,1,2,3,4,5], 5 -> (0, 5), (1,4), (2,3), (3,2), (4,1), (5,0)
 *
 *
 */
public class TargetSumTuples {

    private static List<Tuple<Integer, Integer>> targetTuples(int[] array, int targetSum) {

        List<Tuple<Integer, Integer>> results = new ArrayList<>();
        Set<Integer> numbersAlreadySeen = new HashSet<>();

        for (int i = 0; i < array.length; i++) {
            int number = array[i];
            int matchingNumber = targetSum - number;

            //store that we've seen this number in the set
            numbersAlreadySeen.add(number);

            if(numbersAlreadySeen.contains(matchingNumber)) {
                results.add(new Tuple<>(number, matchingNumber));
                results.add(new Tuple<>(matchingNumber, number));
            }
        }

        return results;
    }


    public static void main(String[] args) {

        List<Tuple<Integer, Integer>> tuples = targetTuples(new int[]{0, 1, 2, 3, 4, 5,5, -5, 10}, 5);
        for (Tuple<Integer, Integer> tuple : tuples) {
            System.out.println(tuple);
        }
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


}
