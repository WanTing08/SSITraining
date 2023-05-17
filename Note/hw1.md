## Topic 1
Problems:

1) Given string “Algorithms”, return  “go” and “Algo” using substring
```java
public static void main(String[] args) {
    String s = "Algorithms";
    System.out.println(s.substring(2, 4));
    System.out.println(s.substring(0, 4));
}
```

2) Given two strings, compare if these two strings are equal by comparing each character
```java
public static boolean compareString(String s1, String s2){
    if(s1.length() != s2.length()) return false;
    for (int i = 0; i < s1.length(); i++) {
        if(s1.charAt(i) != s2.charAt(i)) return false;
    }
    return true;
}
```

3) Given string “https://www.amazon.com/demo?test=abc”, return [“https”,”www”,”amazon”,”com”,”demo”,”test”,”abc”]
```java

```

4) Given a list of string array, combine them into one string sentence, return the string sentence
