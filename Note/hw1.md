## Topic : String
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
public static void main(String[] args) {
    String s = "https://www.amazon.com/demo?test=abc";
    System.out.println(Arrays.toString(s.split("[:/.?=]+")));
}
```

4) Given a list of string array, combine them into one string sentence, return the string sentence
```java
public static void main(String[] args) {
    String[] s = {"wwt", "likes", "hotpot"};
    StringBuilder sb = new StringBuilder();
    for (String i : s) {
        sb.append(i).append(" ");
    }
    System.out.println(sb.toString().trim());
}
```

## Topic: final
Problems: define a final class and final method and final variable, 
modify the value of the variable in final method

```java
public final class MyClass {
    
    private final int val;

    public MyClass(int value){
        val = value;
    }

    public final void printVal(){
        System.out.println(val);
    }

    public static void main(String[] args) {
        MyClass object = new MyClass(1);
        object.printVal();
    }
}
```
## Topic: Static

Problems:

1. Given a database table “Book” with columns (id, isbn, name, author, 
publish date), define a java class that matches this table and then use a 
static block to initialize this table with some records

```java
public class Book {
    private int id;
    private String isbn;
    private String name;
    private String author;
    private String publicDate;

    public Book(int id, String isbn, String name, String author, String publicDate){
        this.id = id;
        this.isbn = isbn;
        this.name = name;
        this.author = author;
        this.publicDate = publicDate;
    }

    public static List<Book> bookList = new ArrayList<>();

    static {
        bookList.add(new Book(1, "9780987654321", "The Great Gatsby", "F. Scott Fitzgerald", "04/10/1924"));
        bookList.add(new Book(2, "9789876543210", "The Catcher in the Rye", "J.D. Salinger", "07/16/1951"));
    }
}
```


2. Define a Java class “BookSeller” and then define a static inner class “Book”, and use a static method “sellBooks” to initialize several books, and in the main method display all the books by calling the “sellBooks” method
```java

```

