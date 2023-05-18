package hw1.topic1;

import java.util.Arrays;

/*
    Given string “https://www.amazon.com/demo?test=abc”, return [“https”,”www”,”amazon”,”com”,”demo”,”test”,”abc”]
 */
public class Problem3 {
    public static void main(String[] args) {
        String s = "https://www.amazon.com/demo?test=abc";
        System.out.println(Arrays.toString(s.split("[:/.?=]+")));
    }
}
