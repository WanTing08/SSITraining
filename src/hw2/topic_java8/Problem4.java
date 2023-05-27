package hw2.topic_java8;

import java.util.HashMap;
import java.util.Map;

/*
    "Eclipse eclipse Eclipse eclipse amc clip ECLIPSE" – count the occurrence of each unique word (ignore case),
    return result as a map. For example (eclipse->5, amc->1, clip->1)
 */
public class Problem4 {
    public static Map<String, Integer> countWords(String sentence){
        String[] words = sentence.toLowerCase().split("\\s+");
        Map<String, Integer> wordCounts = new HashMap<>();
        for(String word : words){
            Integer count = wordCounts.getOrDefault(word, 0);
            wordCounts.put(word, count + 1);
        }
        return wordCounts;
    }

    public static void main(String[] args) {
        String sentence = "Eclipse eclipse Eclipse eclipse amc clip ECLIPSE";
        Map<String, Integer> wordCounts = countWords(sentence);
        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
