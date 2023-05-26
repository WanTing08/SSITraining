package hw2.topic_java8;

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
