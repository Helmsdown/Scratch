package chapter1;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by russellb337 on 10/21/14.
 */
public class UniqueCharacters {

    public static void main(String[] args) {
        hasUniqueCharacters("abcd");
        hasUniqueCharacters("aaaa");

        hasUniqueCharacters_NoDataStructures("abcd");
        hasUniqueCharacters_NoDataStructures("aaaa");
        hasUniqueCharacters_NoDataStructures("abcb");
    }

    private static boolean hasUniqueCharacters(String str) {
        boolean result = true;

        Set<Character> knownCharacters = new HashSet<>();

        char[] chars = str.toCharArray();
        for (char c : chars) {
            if(knownCharacters.contains(c)) {
                result = false;
                break;
            }

            knownCharacters.add(c);
        }

        String statement = result ? "does " : "does not ";
        System.out.println("The string \"" + str + "\" " + statement + "have unique characters");
        return result;
    }

    private static boolean hasUniqueCharacters_NoDataStructures(String str) {
        boolean result = true;

        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = i+1; j < chars.length; j++) {
                if(chars[i] == chars[j]) {
                    result = false;
                    break;
                }
            }
        }

        String statement = result ? "does " : "does not ";
        System.out.println("The string \"" + str + "\" " + statement + "have unique characters");
        return result;
    }
}
