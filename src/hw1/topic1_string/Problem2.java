package hw1.topic1_string;

/*
    Given two strings, compare if these two strings are equal by comparing each character
 */
public class Problem2 {
    public static boolean compareString(String s1, String s2){
        if(s1.length() != s2.length()) return false;

        for (int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        String s1 = "abcdefg";
        String s2 = "abcdrfg";
        System.out.println(compareString(s1, s2));
    }
}
