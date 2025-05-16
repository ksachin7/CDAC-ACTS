package com.cdac.acts.bank;

import com.cdac.acts.bank.exception.MinBalException;

public interface Withdrawable {
    double withdraw(double amount) throws MinBalException;
}