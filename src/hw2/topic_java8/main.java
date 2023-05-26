package hw2.topic_java8;

public class main {
    public static void main(String[] args) {
        VisaCard visaCard = new VisaCard("Wanting Wang", "441798761342", 1000.0, "VisaCard");
        MasterCard masterCard = new MasterCard("Taylor Swift", "891722910523", 2000.0, "MasterCard");

        visaCard.payBill(120.0);
        masterCard.payBill(1100.0);

        CreditCard.refund(70.0);
    }
}
