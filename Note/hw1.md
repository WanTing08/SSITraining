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
public class BookSeller {
    public static class Book {
        private String title;
        private String author;

        public Book(String title, String author) {
            this.title = title;
            this.author = author;
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }
    }

    public static void sellBooks() {
        Book[] books = {
                new Book("The Great Gatsby", "F. Scott Fitzgerald"),
                new Book("The Catcher in the Rye", "J.D. Salinger")
        };

        System.out.println("Available Books:");
        for (Book book : books) {
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
            System.out.println();
        }
    }

    public static void main(String[] args) {
        sellBooks();
    }
}
```

## Topic: OOP
Problems:
1. Define an interface “DatabaseConnection” and then define class 
“OracleConnection”, “MySqlConnection”, “SqlServerConnection”. 
They should all implements the “getConnection” method from the 
interface. The method should initialize data source and return a 
database connection.
```java
public interface DatabaseConnection {
    Connection getConnection();
}

public class OracleConnection implements DatabaseConnection {
    @Override
    public Connection getConnection() {
        try {
            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            String username = "root";
            String password = "123456";
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

public class MySqlConnection implements DatabaseConnection {
    @Override
    public Connection getConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/mydatabase";
            String username = "root";
            String password = "123456";
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

public class SqlServerConnection implements DatabaseConnection {
    @Override
    public Connection getConnection() {
        try {
            String url = "jdbc:sqlserver://localhost:1433;databaseName=mydatabase";
            String username = "root";
            String password = "123456";
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
```
2. Define an abstract class “CreditCard” which contains fields (holderName, cardNumber, accountBalance, cardType), and not-implemented method “isCardAcceptable” with argument cardType, and implemented method “payBill(double bill)”. Define two classes “VisaCard” and “MasterCard” both should inherit this “CreditCard” class and you should define constructor for both classes and implement the “isCardAcceptable” method.
```java
public abstract class CreditCard {
    protected String holderName;
    protected String cardNumber;
    protected double accountBalance;
    protected String cardType;

    public CreditCard(String holderName, String cardNumber, double accountBalance, String cardType) {
        this.holderName = holderName;
        this.cardNumber = cardNumber;
        this.accountBalance = accountBalance;
        this.cardType = cardType;
    }

    public abstract boolean isCardAcceptable(String cardType);

    public void payBill(double bill) {
        if (accountBalance >= bill) {
            System.out.println("Payment successful!");
            accountBalance -= bill;
            System.out.println("Remaining account balance: " + accountBalance);
        } else {
            System.out.println("Insufficient funds. Payment failed!");
        }
    }
}

public class VisaCard extends CreditCard {
    public VisaCard(String holderName, String cardNumber, double accountBalance) {
        super(holderName, cardNumber, accountBalance, "Visa");
    }

    @Override
    public boolean isCardAcceptable(String cardType) {
        return cardType.equals("Visa");
    }
}

public class MasterCard extends CreditCard {
    public MasterCard(String holderName, String cardNumber, double accountBalance) {
        super(holderName, cardNumber, accountBalance, "MasterCard");
    }

    @Override
    public boolean isCardAcceptable(String cardType) {
        return cardType.equals("MasterCard");
    }
}
```
4. Implement static and dynamic polymorphism.

```java
public class Vehicle {
    public void start() {
        System.out.println("Vehicle started");
    }

    public void start(String ignitionType) {
        System.out.println("Vehicle started using " + ignitionType);
    }
}
```
```java
public class Main {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.start();               
        vehicle.start("key");          
    }
}
```
```java
public class Car extends Vehicle {
    @Override
    public void start() {
        System.out.println("Car started");
    }
}
```
```java
public class Main {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        Car car = new Car();

        vehicle.start();        
        car.start();            
    }
}
```

## Topic: Design Pattern
Problems
1. Create a singleton class called “AppleDesignerFactory”
```java
public class AppleDesignerFactory {
    private static AppleDesignerFactory instance;
    private String designerName;

    private AppleDesignerFactory() {
        designerName = "Apple Design Team";
    }

    public static AppleDesignerFactory getInstance() {
        if (instance == null) {
            synchronized (AppleDesignerFactory.class) {
                if (instance == null) {
                    instance = new AppleDesignerFactory();
                }
            }
        }
        return instance;
    }

    public String getDesignerName() {
        return designerName;
    }
}

```
2. Create a factory pattern called “CurrencyExchange” which takes in the country name and return the currency object for that country.
```java
public interface Currency {
    String getCurrencySymbol();
}

public class USDollar implements Currency {
    @Override
    public String getCurrencySymbol() {
        return "$";
    }
}

public class Euro implements Currency {
    @Override
    public String getCurrencySymbol() {
        return "€";
    }
}

public class CurrencyExchange {
    public static Currency getCurrency(String country) {
        if (country.equalsIgnoreCase("USA")) {
            return new USDollar();
        } else if (country.equalsIgnoreCase("Germany")) {
            return new Euro();
        }

        throw new IllegalArgumentException("Currency not supported for country: " + country);
    }
}

```
3. Implement the (in-class) PARKING LOT OOP design system -> your implementation should include main method and is runnable.

```java
abstract class Vehicle {
    private String licensePlate;
    private String brand;
    private String color;

    public Vehicle(String licensePlate, String brand, String color) {
        this.licensePlate = licensePlate;
        this.brand = brand;
        this.color = color;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }
}

class Car extends Vehicle {
    public Car(String licensePlate, String brand, String color) {
        super(licensePlate, brand, color);
    }
}

class Motorcycle extends Vehicle {
    public Motorcycle(String licensePlate, String brand, String color) {
        super(licensePlate, brand, color);
    }
}

class ParkingLot {
    private int capacity;
    private List<Vehicle> vehicles;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        vehicles = new ArrayList<>();
    }

    public boolean parkVehicle(Vehicle vehicle) {
        if (vehicles.size() < capacity) {
            vehicles.add(vehicle);
            System.out.println("Vehicle with license plate " + vehicle.getLicensePlate() + " parked successfully.");
            return true;
        } else {
            System.out.println("Parking lot is full. Cannot park vehicle with license plate " + vehicle.getLicensePlate());
            return false;
        }
    }

    public void printOccupiedSpaces() {
        System.out.println("Occupied parking spaces:");
        for (Vehicle vehicle : vehicles) {
            System.out.println("License Plate: " + vehicle.getLicensePlate() + " | Brand: " + vehicle.getBrand() + " | Color: " + vehicle.getColor());
        }
    }
}

// Main class to run the parking lot system
public class Main {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(3);

        Car car1 = new Car("ABC123", "Toyota", "Red");
        Car car2 = new Car("XYZ456", "Honda", "Blue");
        Motorcycle motorcycle1 = new Motorcycle("DEF789", "Suzuki", "Black");

        parkingLot.parkVehicle(car1);
        parkingLot.parkVehicle(car2);
        parkingLot.parkVehicle(motorcycle1);

        parkingLot.printOccupiedSpaces();
    }
}
```

## Topic: Collection
Problems:
1. (Set)Find true friends: Given two arraylists containing friend names, find the true friends that appear in both list.
```java

public static void main(String[] args) {
    ArrayList<String> list1 = new ArrayList<>();
    list1.add("wwt");
    list1.add("wwt1");
    list1.add("wwt2");
    list1.add("wwt3");
    ArrayList<String> list2 = new ArrayList<>();
    list2.add("wwt2");
    list2.add("wwt3");
    list2.add("wwt");
    
    list1.retainAll(list2);
    System.out.println("True friends: " + list1);
}
```
2. (Map)Given a string, output duplicate characters and their counts
```java
public class Main {
    public static void main(String[] args) {
        String input = "Hello, World!";
        
        Map<Character, Integer> charCounts = new HashMap<>();
        
        for (char c : input.toCharArray()) {
            if (Character.isLetterOrDigit(c)) { 
                charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
            }
        }
        
        System.out.println("Duplicate characters and their counts:");
        for (Map.Entry<Character, Integer> entry : charCounts.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }
}
```
3. Use a map to simulate database table, key should be the primary key (assume only one column), value is the record, your simulation should include CRUD operation methods
```java
public class DatabaseSimulation {
    private Map<Integer, Record> table;

    public DatabaseSimulation() {
        table = new HashMap<>();
    }

    public void insertRecord(int primaryKey, Record record) {
        if (!table.containsKey(primaryKey)) {
            table.put(primaryKey, record);
            System.out.println("Record inserted successfully.");
        } else {
            System.out.println("Record with the given primary key already exists.");
        }
    }
    
    public Record getRecord(int primaryKey) {
        return table.get(primaryKey);
    }
    
    public void updateRecord(int primaryKey, Record updatedRecord) {
        if (table.containsKey(primaryKey)) {
            table.put(primaryKey, updatedRecord);
            System.out.println("Record updated successfully.");
        } else {
            System.out.println("Record with the given primary key does not exist.");
        }
    }
    
    public void deleteRecord(int primaryKey) {
        if (table.containsKey(primaryKey)) {
            table.remove(primaryKey);
            System.out.println("Record deleted successfully.");
        } else {
            System.out.println("Record with the given primary key does not exist.");
        }
    }
    
    public static class Record {
        private String data;

        public Record(String data) {
            this.data = data;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }
    }
    
    public static void main(String[] args) {
        DatabaseSimulation database = new DatabaseSimulation();
        
        database.insertRecord(1, new Record("Data 1"));
        database.insertRecord(2, new Record("Data 2"));
        
        Record record1 = database.getRecord(1);
        if (record1 != null) {
            System.out.println("Retrieved data: " + record1.getData());
            record1.setData("Updated Data 1");
            database.updateRecord(1, record1);
        }
        
        database.deleteRecord(2);
        
        Record deletedRecord = database.getRecord(2);
        if (deletedRecord != null) {
            System.out.println("Retrieved data: " + deletedRecord.getData());
        } else {
            System.out.println("Record not found.");
        }
    }
}

```