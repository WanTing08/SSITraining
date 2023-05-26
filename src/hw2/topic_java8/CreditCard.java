package hw2.topic_java8;

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

