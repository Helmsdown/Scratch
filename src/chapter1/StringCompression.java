package chapter1;

/**
 * Created by russellb337 on 11/4/14.
 */
public class StringCompression {

    public static void main(String[] args) {
        System.out.println(compressString("aaabbbbccccc"));
        System.out.println(compressString("abcdefg"));
    }

    private static String compressString(String input) {
        StringBuilder result = new StringBuilder();

        char curChar = input.charAt(0);
        int curCharCount = 1;
        result.append(curChar);

        for (int i = 1; i < input.length(); i++) {
            char newChar = input.charAt(i);

            if(newChar == curChar) {
                curCharCount++;
            } else {
                result.append(curCharCount).append(newChar);
                curChar = newChar;
                curCharCount = 1;
            }
        }

        result.append(curCharCount);

        return result.length() > input.length() ? input : result.toString();
    }
}
