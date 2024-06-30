package Model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Account implements Serializable {
    private final String cardNumber;
    private final String pin;
    private double balance;
    private boolean blocked;
    private LocalDateTime blockedUntil;

    public Account(String cardNumber, String pin, double balance, boolean blocked, LocalDateTime blockedUntil) {
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.balance = balance;
        this.blocked = blocked;
        this.blockedUntil = blockedUntil;
    }

    // Getters and setters
    public String getCardNumber() {
        return cardNumber;
    }

    public String getPin() {
        return pin;
    }

    public double getBalance() {
        return balance;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public LocalDateTime getBlockedUntil() {
        if (isBlocked()){
            return blockedUntil;
        }
        else{
            return LocalDateTime.now();
        }
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public void setBlockedUntil(LocalDateTime blockedUntil) {
        this.blockedUntil = blockedUntil;
    }
}
