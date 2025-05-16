package com.cdac.acts.bank.exception;

public class InsufficientBalanceException extends Exception{

    public InsufficientBalanceException(String msg){
        super(msg);
    }
}
