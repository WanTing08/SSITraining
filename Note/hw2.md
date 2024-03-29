## Topic: Serializable
Problems: Define a “Employee” POJO class and make it serializable

```java
public class Employee implements Serializable{
    private String name;
    private int age;

    public Employee(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
```

## Topic: Exception Handling

Problems:

Define two exceptions “CardTypeException” and “AddressException”. Create a separate class “ExceptionHandler” which contains one method “handleException”. The method takes input of cardType and address. If cardType is “AMEX”, throw CardTypeException. If address is outside US, return AddressException, for other errors, just return generic exception. Your exception should be caught and you should display message to tell which exception is returned.

```java
class CardTypeException extends Exception{
    public CardTypeException(String message){
        super(message);
    }
}

class AddressException extends Exception{
    public AddressException(String message){
        super(message);
    }
}

class ExceptionHandler {
    public static void handleException(String cardType, String address){
        try{
            if(cardType.equals("AMEX")){
                throw new CardTypeException("Invalid card type:" + cardType);
            }
            else if(!address.equalsIgnoreCase("US")){
                throw new AddressException("outside US" + address);
            }else{
                throw new Exception("Generic exception occurred.");
            }
        }catch (CardTypeException e){
            System.out.println("CardTypeException:" + e.getMessage());
        }catch (AddressException e){
            System.out.println("AddressException:" + e.getMessage());
        }catch (Exception e){
            System.out.println("Generic Exception:" + e.getMessage());
        }
    }
}

public class Main{
    public static void main(String[] args) {
        String cardType = "AMEX";
        String address = "Canada";

        ExceptionHandler.handleException(cardType, address);
    }
}
```
## Topic: ExecutorService
Problems:
Define a inner class A has method “getMethod()” which return string “A.getMethod” and another inner class B has method “getMethod()” which return string “B.getMethod”. write another method “runSameTime()” which should let A and B getMethod to run at the same time, but the “runSameTime()” method should return a string “B.getMethod A.getMethod”

```java
public class OuterClass {
    public class A{
        public String getMthod(){
            return "A.getMethod()";
        }
    }

    public class B{
        public String getMethod(){
            return "B.getmethod()";
        }
    }

    public String runSameTime() throws InterruptedException{
        final StringBuilder sb = new StringBuilder();

        Thread threadA = new Thread(() -> {
            A a = new A();
            sb.append(a.getMthod());
        });

        Thread threadB = new Thread(() -> {
            B b = new B();
            sb.append(b.getMethod());
        });

        threadA.start();
        threadB.start();

        threadA.join();
        threadB.join();

        return sb.toString();
    }

    public static void main(String[] args) throws InterruptedException{
        OuterClass outer = new OuterClass();
        String result = outer.runSameTime();
        System.out.println(result);
    }
}
```

## Topic: Java 8
Problems:

1. Define an interface “CreditCard” which contains fields (holderName, cardNumber, accountBalance, cardType), and not-implemented method “isCardAcceptable” with argument cardType. Define two classes “VisaCard” and “MasterCard” both should inherit this “CreditCard” interface and you should define constructor for both classes and implement the “isCardAcceptable” method. Now Add a default method “payBill(double bill)” and static method “refund(double amount)” to the interface. Verify that VisaCard and MasterCard class can read these two methods (use Main method to verify).
```java
public interface CreditCard {
    String getHolderName();
    void setHolderName(String holderName);

    String getCardNumber();
    void setCardNumber(String cardNumber);

    double getAccountBalance();
    void setAccountBalance(double accountBalance);

    String getCardType();
    void setCardType(String cardType);

    boolean isCardAcceptable(String cardType);

    default void payBill(double bill){
        System.out.println(bill);
    }

    static void refund(double amount){
        System.out.println(amount);
    }
}
```
```java
public class VisaCard implements CreditCard {
    private String holderName;
    private String cardNumber;
    private double accountBalance;
    private String cardType;

    public VisaCard(String holderName, String cardNumber, double accountBalance, String cardType) {
        this.holderName = holderName;
        this.cardNumber = cardNumber;
        this.accountBalance = accountBalance;
        this.cardType = cardType;
    }

    @Override
    public String getHolderName() {
        return holderName;
    }

    @Override
    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    @Override
    public String getCardNumber() {
        return cardNumber;
    }

    @Override
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public double getAccountBalance() {
        return accountBalance;
    }

    @Override
    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    @Override
    public String getCardType() {
        return cardType;
    }

    @Override
    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public boolean isCardAcceptable(String cardType) {
        return cardType.equals("VisaCard");
    }
}
```
```java
public class MasterCard implements CreditCard {
    private String holderName;
    private String cardNumber;
    private double accountBalance;
    private String cardType;

    public MasterCard(String holderName, String cardNumber, double accountBalance, String cardType) {
        this.holderName = holderName;
        this.cardNumber = cardNumber;
        this.accountBalance = accountBalance;
        this.cardType = cardType;
    }

    @Override
    public String getHolderName() {
        return holderName;
    }

    @Override
    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    @Override
    public String getCardNumber() {
        return cardNumber;
    }

    @Override
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public double getAccountBalance() {
        return accountBalance;
    }

    @Override
    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    @Override
    public String getCardType() {
        return cardType;
    }

    @Override
    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public boolean isCardAcceptable(String cardType) {
        return cardType.equals("MasterCard");
    }
}
```
```java
public class Main {
    public static void main(String[] args) {
        VisaCard visaCard = new VisaCard("Wanting Wang", "441798761342", 1000.0, "VisaCard");
        MasterCard masterCard = new MasterCard("Taylor Swift", "891722910523", 2000.0, "MasterCard");

        visaCard.payBill(120.0);
        masterCard.payBill(1100.0);

        CreditCard.refund(70.0);
    }
}
```
2. Use functional interface to implement Java 8 stream.map() function. Define a “MyStream” class containing a functional interface and a static method “MyMap”.
In main method, test your code by calling: MyStream.MyMap(list, o -> o *3) to multiple each element in the “list” by 3.

```java
public class MyStream {
    @FunctionalInterface
    interface MyFunction<I, O>{
        O apply(I i);
    }

    static <I, O> List<O> myMap(List<I> list, MyFunction<I, O> myFunction){
        List<O> result = new ArrayList<>();
        for(I i : list){
            O mapped = myFunction.apply(i);
            result.add(mapped);
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        List<Integer> mapped = myMap(list, o -> o * 3);
        System.out.println(mapped);
    }
}
```
3. "walabcwalexywalxzsfwalmx”  -- replace "wal" with "sams"
```java
public static void main(String[] args) {
    String s = "walabcwalexywalxzsfwalmx";
    System.out.println(s.replace("wal", "sams"));
}
```

4. "Eclipse eclipse Eclipse eclipse amc clip ECLIPSE" – count the occurrence of each unique word (ignore case), return result as a map. For example (eclipse->5, amc->1, clip->1)

```java
public static Map<String, Integer> countWords(String sentence){
    String[] words = sentence.toLowerCase().split("\\s+");
    Map<String, Integer> wordCounts = new HashMap<>();
    for(String word : words){
        Integer count = wordCounts.getOrDefault(word, 0);
        wordCounts.put(word, count + 1);
    }
    return wordCounts;
    
pubic static void main(String[] args) {
    String sentence = "Eclipse eclipse Eclipse eclipse amc clip ECLIPSE";
    Map<String, Integer> wordCounts = countWords(sentence);
    for (Map.Entry<String, Integer> entry : wordCounts.entrySet()){
        System.out.println(entry.getKey()+": "+entry.getValue());
    }
}
```