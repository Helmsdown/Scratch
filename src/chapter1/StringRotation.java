package chapter1;

/**
 * Created by russellb337 on 11/6/14.
 */
public class StringRotation {

    public static void main(String[] args) {
        System.out.println(isRotation("waterbottle", "erbottlewat"));
    }

    private static boolean isRotation(String s1, String s2) {
        int s1Length = s1.length();
        if(s1Length == s2.length()) {
            return (s1+s1).contains(s2);
        }

        return false;

    }
}
