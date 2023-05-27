package hw2.topic_ExceptionHandling;
/*
Define two exceptions “CardTypeException” and “AddressException”. Create a separate class “ExceptionHandler”
which contains one method “handleException”. The method takes input of cardType and address. If cardType is “AMEX”,
throw CardTypeException. If address is outside US, return AddressException, for other errors, just return generic exception.
Your exception should be caught and you should display message to tell which exception is returned.
 */

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