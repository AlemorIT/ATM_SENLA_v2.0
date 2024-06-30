package Model;

import java.time.LocalDateTime;

public class AccountService {
    private final AccountsRepository fileAccountRepository;

    public AccountService(AccountsRepository fileAccountRepository) {
        this.fileAccountRepository = fileAccountRepository;
    }
    public boolean authorizePin(String cardNumber, String pin){
        Account account = fileAccountRepository.getAccount(cardNumber);
        return account.getPin().equals(pin);
    }
    public boolean authorizeAccount(String cardNumber) {
        Account account = fileAccountRepository.getAccount(cardNumber);
        if (account == null) {
            return false;
        }
        if (account.isBlocked()) {
            if (account.getBlockedUntil().isAfter(LocalDateTime.now())) {
                return false;
            } else {
                account.setBlocked(false);
                fileAccountRepository.updateAccount(account);
            }
        }
        return true;
    }
    public boolean isValidCardNumber(String cardNumber) {
        //The Luhn Formula:
        //Drop the last digit from the number. The last digit is what we want to check against
        //Reverse the numbers
        //Multiply the digits in odd positions (1, 3, 5, etc.) by 2 and subtract 9 to all any result higher than 9
        //Add all the numbers together
        //The check digit (the last number of the card) is the amount that you would need to add to get a multiple of 10 (Modulo 10)
        // Проверка соответствия формату "XXXX-XXXX-XXXX-XXXX"
        cardNumber = cardNumber.replace("-","");
        int last_digit = Character.getNumericValue(cardNumber.charAt(cardNumber.length() - 1));
        cardNumber = cardNumber.substring(0, cardNumber.length() - 1);
        cardNumber = new StringBuilder(cardNumber).reverse().toString();
        int sum = 0;
        for (int i = 0; i < cardNumber.length(); i++) {
            int number = Character.getNumericValue(cardNumber.charAt(i));
            if (i % 2 == 1) {
                number *= 2;
                if (number > 9) {
                    number -= 9;
                }
                sum+=number;
            }
        }
        return sum % 10 == last_digit;
    }


    public double checkBalance(String cardNumber) {
        Account account = fileAccountRepository.getAccount(cardNumber);
        if (account != null) {
            return account.getBalance();
        }
        return -1;
    }

    public boolean withdraw(String cardNumber, double amount) {
        Account account = fileAccountRepository.getAccount(cardNumber);
        if (account != null && amount <= account.getBalance()) {
            account.setBalance(account.getBalance() - amount);
            fileAccountRepository.updateAccount(account);
            return true;
        }
        return false;
    }

    public boolean deposit(String cardNumber, double amount) {
        if (amount <= 1000000) {
            Account account = fileAccountRepository.getAccount(cardNumber);
            if (account != null) {
                account.setBalance(account.getBalance() + amount);
                fileAccountRepository.updateAccount(account);
                return true;
            }
        }
        return false;
    }

    public void blockAccount(String cardNumber) {
        Account account = fileAccountRepository.getAccount(cardNumber);
        if (account != null) {
            account.setBlocked(true);
            account.setBlockedUntil(LocalDateTime.now().plusDays(1));
            fileAccountRepository.updateAccount(account);
        }
    }
}

