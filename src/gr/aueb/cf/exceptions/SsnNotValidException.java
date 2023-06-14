package gr.aueb.cf.exceptions;

public class SsnNotValidException extends Exception{
    private static final long serialVersionUID = 12345L;
    public SsnNotValidException(String ssn){
        super("Ssn "+ ssn + " is not valid");
    }
}
