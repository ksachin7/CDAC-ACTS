package eclipse_workspace.day10.bank;

import eclipse_workspace.day10.bank.exception.MinBalException;

public interface Withdrawable {
    double withdraw(double amount) throws MinBalException;
}