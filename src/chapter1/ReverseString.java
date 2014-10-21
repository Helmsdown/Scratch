package chapter1;

import java.util.Arrays;

/**
 * Created by russellb337 on 10/21/14.
 */
public class ReverseString {

    public static void main(String[] args) {
        char[] str = {'a', 'b', 'c', 'd', '\0'};
        reverseStringInPlace(str);
        System.out.println(Arrays.toString(str));

        str = new char[]{'a', 'b', 'c', 'd', 'e', '\0'};
        reverseStringInPlace(str);
        System.out.println(Arrays.toString(str));
    }

    private static void reverseStringInPlace(char[] str) {

        int frontIndex = 0;
        int endIndex = str.length-2; //minus 2 to skip the null character at the end

        while(frontIndex < endIndex) {

            char temp = str[frontIndex];
            str[frontIndex] = str[endIndex];
            str[endIndex] = temp;

            frontIndex++;
            endIndex--;
        }

    }
}
