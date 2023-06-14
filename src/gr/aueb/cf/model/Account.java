package gr.aueb.cf.model;

import gr.aueb.cf.exceptions.InsufficientBalanceException;
import gr.aueb.cf.exceptions.NegativeAmountException;
import gr.aueb.cf.exceptions.SsnNotValidException;

public  class Account extends IdentifiableEntity {
    private User holder;
    private String iban;
    private double balance;
    public Account(){}

    public Account(User holder, String iban, double balance) {
        this.holder = holder;
        this.iban = iban;
        this.balance = balance;
    }


    public User getHolder() {
        return holder;
    }

    public void setHolder(User holder) {
        this.holder = holder;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "holder=" + holder +
                ", iban='" + iban + '\'' +
                ", balance=" + balance +
                '}';
    }

    /**
     *
     * @param amount
     * @throws NegativeAmountException
     */

    public void deposit(double amount) throws NegativeAmountException {
        try{
            if(amount < 0){
                throw new NegativeAmountException(amount);
            }

            balance += amount;
        }catch(NegativeAmountException e){
            System.err.println("Error: Negative amount");
        }
    }

    /**
     *
     * @param amount
     * @param ssn
     * @throws InsufficientBalanceException
     * @throws SsnNotValidException
     * @throws NegativeAmountException
     */


    public void withDraw(double amount,String ssn)
            throws InsufficientBalanceException, SsnNotValidException,NegativeAmountException
    {
        try{
            if(amount > this.getBalance()){
                throw new InsufficientBalanceException(this.getBalance(),amount);
            }if(amount < 0){
                throw new NegativeAmountException(amount);
            }if(!isSsnValid(ssn)){
                throw new SsnNotValidException(ssn);
            }
            setBalance(getBalance() - amount);
        }catch(InsufficientBalanceException | NegativeAmountException | SsnNotValidException e){
            System.err.println("Not enough money ");
        }
    }


    protected boolean isSsnValid(String ssn){
        if(ssn == null || getHolder().getSsn() == null){
            return false;
        }

        return holder.getSsn().equals(ssn);
    }



}
