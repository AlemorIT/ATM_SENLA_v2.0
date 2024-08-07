package repository;

import model.Account;
import utils.ApplicationSettings;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class FileAccountRepository implements AccountsRepository {

    @Override
    public void saveAccount(Account account) {
        Map<String, Account> accounts = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(ApplicationSettings.DATA_FILE.GetTitle()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                accounts.put(parts[0], new Account(parts[0], parts[1], Double.parseDouble(parts[2]), Boolean.parseBoolean(parts[3]), LocalDateTime.parse(parts[4])));
            }
        } catch (IOException e) {
            System.err.println("Error loading account data: " + e.getMessage());
        }
        accounts.put(account.getCardNumber(), account);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ApplicationSettings.DATA_FILE.GetTitle()))) {
            for (Account acc : accounts.values()) {
                writer.write(acc.getCardNumber() + " " + acc.getPin() + " " + acc.getBalance() + " " + acc.isBlocked() + " " + acc.getBlockedUntil());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error saving account data: " + e.getMessage());
        }
    }

    @Override
    public Account getAccount(String cardNumber) {
        try (BufferedReader reader = new BufferedReader(new FileReader(ApplicationSettings.DATA_FILE.GetTitle()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts[0].equals(cardNumber)) {
                    return new Account(parts[0], parts[1], Double.parseDouble(parts[2]), Boolean.parseBoolean(parts[3]), LocalDateTime.parse(parts[4]));
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading account data: " + e.getMessage());
        }
        return null;
    }

    @Override
    public void updateAccount(Account account) {
        saveAccount(account);
    }
}
