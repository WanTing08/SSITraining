package hw1.topic3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/*
    Given a database table “Book” with columns (id, isbn, name, author, publish date), define a java class that matches
    this table and then use a static block to initialize this table with some records
 */
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
