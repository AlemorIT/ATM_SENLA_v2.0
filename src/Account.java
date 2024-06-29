import java.io.Serializable;
import java.time.LocalDateTime;

public class Account implements Serializable {
    private String cardNumber;
    private String pin;
    private double balance;
    private boolean blocked;
    private LocalDateTime blockedUntil;

    public Account(String cardNumber, String pin, double balance) {
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.balance = balance;
        this.blocked = false;
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
        return blockedUntil;
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
