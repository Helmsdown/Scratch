package chapter1;

import java.util.Arrays;

/**
 * Created by russellb337 on 11/4/14.
 */
public class EscapeWhitespace {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(escapeWhitespace(new char[]{'a', ' ', 'b', ' ', ' '}, 3)));
        System.out.println(Arrays.toString(escapeWhitespace(new char[]{'a', 'b', 'c', ' '}, 3)));
        System.out.println(Arrays.toString(escapeWhitespace(new char[]{'a', ' ', 'b', 'c', ' ', ' ', ' '}, 4)));
    }

    private static char[] escapeWhitespace(char[] chars, int trueLength) {

        int numSpaces = countSpaces(chars, trueLength);
        int writePosition = trueLength + (2*numSpaces) - 1;

        for (int i = trueLength-1; i > 0; i--) {
            if(chars[i] == ' ') {
                chars[writePosition] = '0';
                chars[writePosition-1] = '2';
                chars[writePosition-2] = '%';
                writePosition-=3;
            } else {
                chars[writePosition] = chars[i];
                writePosition--;
            }
        }
        return chars;
    }

    private static int countSpaces(char[] chars, int trueLength) {

        int count = 0;
        for (int i = 0; i < trueLength; i++) {
            if(chars[i] == ' ') {
                count++;
            }
        }

        return count;
    }
}
