package chapter1;

import java.util.*;

/**
 * Created by russellb337 on 10/21/14.
 */
public class StringPermutation {

    public static void main(String[] args) {
        System.out.println(isPermutation_sorting("abc", "bac"));
        System.out.println(isPermutation_sorting("xxx", "yyy"));

        System.out.println(isPermutation_map("abc", "bac"));
        System.out.println(isPermutation_map("xxx", "yyy"));
    }

    private static boolean isPermutation_sorting(String a, String b) {
        return sortString(a).equals(sortString(b));
    }

    private static String sortString(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
    
    private static boolean isPermutation_map(String a, String b) {

        Map<Character, Integer> mapA = createCountMap(a);
        Map<Character, Integer> mapB = createCountMap(b);

        //create a set of all the unique characters in both strings
        Set<Character> characters = new HashSet<>(mapA.keySet());
        characters.addAll(mapB.keySet());

        for (Character character : characters) {
            //compare the counts in both strings
            if(mapA.get(character) != mapB.get(character)) {
                return false;
            }
        }
        
        return true;
    }

    private static Map<Character,Integer> createCountMap(String a) {
        Map<Character, Integer> result = new HashMap<>();
        for (char c : a.toCharArray()) {
            Integer count = result.get(c);
            
            if(count == null) {
                result.put(c, 1);
            } else {
                result.put(c, count++);
            }
        }
        
        return result;
    }
}
