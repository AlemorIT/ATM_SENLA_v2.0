package Controller;

import Model.AccountService;
import View.ConsoleView;

public class ATMController {
    private final ConsoleView consoleView;
    private final AccountService accountService;
    private String cardNumber;
    public ATMController(ConsoleView consoleView, AccountService accountService) {
        this.consoleView = consoleView;
        this.accountService = accountService;
    }

    public void run() {
        handleAuthorization();
        while (true) {

            consoleView.showMenu();
            int choice = consoleView.scanner.nextInt();
            consoleView.scanner.nextLine();
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
            cardNumber = consoleView.inputCardNumber();
        } while (!accountService.isValidCardNumber(cardNumber));
        String pin = consoleView.inputPin();
        if (accountService.authorizeAccount(cardNumber, pin)) {
            consoleView.showSuccessMessage("Авторизация прошла успешно.");
        } else {
            consoleView.showErrorMessage("Неверный номер карты или ПИН-код.");
        }
    }

    private void handleBalance() {
        double balance = accountService.checkBalance(cardNumber);
        if (balance >= 0) {
            consoleView.showBalance(balance);
        }
    }

    private void handleWithdrawal() {
        double amount = consoleView.inputWithdrawalAmount();
        if (accountService.withdraw(cardNumber, amount)) {
            consoleView.showSuccessMessage("Снятие средств успешно выполнено.");
        } else {
            consoleView.showErrorMessage("Недостаточно средств на счете.");
        }
    }

    private void handleDeposit() {
        double amount = consoleView.inputDepositAmount();
        if (accountService.deposit(cardNumber, amount)) {
            consoleView.showSuccessMessage("Пополнение баланса успешно выполнено.");
        } else {
            consoleView.showErrorMessage("Ошибка пополнения баланса. Сумма должна быть не более 1 000 000.");
        }
    }
}
