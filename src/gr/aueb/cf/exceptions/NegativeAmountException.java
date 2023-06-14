package gr.aueb.cf.exceptions;

public class NegativeAmountException extends Exception{
    private static long SerialVersionUID = 12345L;

    public NegativeAmountException(double amount){
        super("Amount "+ amount + "is negative.");
    }
}
