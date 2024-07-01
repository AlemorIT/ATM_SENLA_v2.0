package service;

import utils.ApplicationStrings;
import utils.Reader;
import view.ConsoleView;

import java.util.Scanner;

public class AccountServiceHandler {

    private final ConsoleView consoleView;
    private final AccountService accountService;
    private String cardNumber;
    Reader consoleReader;
    public Scanner scanner = new Scanner(System.in);

    public AccountServiceHandler(AccountService accountService, ConsoleView consoleView, Reader consoleReader) {
        this.consoleView = consoleView;
        this.accountService = accountService;
        this.consoleReader = consoleReader;

    }
    public void run() {
        handleAuthorization();
        while (true) {

            consoleView.showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    handleBalance();
                    break;
                case 2:
                    handleWithdrawal();
                    break;
                case 3:
                    handleDeposit();
                    break;
                case 4:
                    System.out.println("До свидания!");
                    return;
                default:
                    consoleView.showErrorMessage("Неверный выбор действия.");
            }
        }
    }
    private void handleAuthorization() {
        do{
            cardNumber = consoleReader.ReadString(ApplicationStrings.ApplicationStringsEnum.inputCardNumber.GetTitle());
        } while (!accountService.isValidCardNumber(cardNumber));
        byte counter = 0;
        String pin;
        do {
            pin = consoleReader.ReadString(ApplicationStrings.ApplicationStringsEnum.inputPin.GetTitle());
            counter +=1;
            if(counter == 3){
                accountService.blockAccount(cardNumber);
                System.out.println("Превышено количество попыток. Карта заблокирована на сутки.");
                System.exit(0);
            }
        }while(!accountService.authorizePin(cardNumber, pin));
        if (accountService.authorizeAccount(cardNumber)) {
            consoleView.showSuccessMessage("Авторизация прошла успешно.");
        } else {
            consoleView.showErrorMessage("Неудалось войти. Обратитесь в банк, ваша карта заблокирована");
            System.exit(0);
        }
    }

    private void handleBalance() {
        double balance = accountService.checkBalance(cardNumber);
        if (balance >= 0) {
            consoleView.showBalance(balance);
        }
    }

    private void handleWithdrawal() {
        double amount = consoleReader.ReadDouble(ApplicationStrings.ApplicationStringsEnum.inputWithdrawalAmount.GetTitle());
        if (accountService.withdraw(cardNumber, amount)) {
            consoleView.showSuccessMessage("Снятие средств успешно выполнено.");
        } else {
            consoleView.showErrorMessage("Недостаточно средств на счете.");
        }
    }

    private void handleDeposit() {
        double amount = consoleReader.ReadDouble(ApplicationStrings.ApplicationStringsEnum.inputDepositAmount.GetTitle());
        if (accountService.deposit(cardNumber, amount)) {
            consoleView.showSuccessMessage("Пополнение баланса успешно выполнено.");
        } else {
            consoleView.showErrorMessage("Ошибка пополнения баланса. Сумма должна быть не более 1 000 000.");
        }
    }
}
