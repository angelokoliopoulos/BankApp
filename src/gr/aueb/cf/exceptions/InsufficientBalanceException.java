package gr.aueb.cf.exceptions;

public class InsufficientBalanceException extends Exception{
    //Serial version unique id is a mechanism that seperates the versions of a class.
    private static final long serialVersionUID = 12345L;

    public InsufficientBalanceException(double balance, double amount){
        super("Insufficient balance " + balance + "for amount "+ amount);
    }

}
