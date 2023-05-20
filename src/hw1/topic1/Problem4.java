package hw1.topic1;

/*
    Given a list of string array, combine them into one string sentence, return the string sentence
 */
public class Problem4 {
    public static void main(String[] args) {
        String[] s = {"wwt", "likes", "hotpot"};
        StringBuilder sb = new StringBuilder();
        for (String i : s) {
            sb.append(i).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
