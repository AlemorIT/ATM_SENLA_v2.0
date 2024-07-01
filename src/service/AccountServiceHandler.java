package service;

import view.ConsoleView;
import utils.InputData;

public class AccountServiceHandler {
    private final ConsoleView consoleView;
    private final AccountService accountService;
    private String cardNumber;
    InputData inputData;

    public AccountServiceHandler(AccountService accountService, ConsoleView consoleView, InputData inputData) {
        this.consoleView = consoleView;
        this.accountService = accountService;
        this.inputData = inputData;
    }
    public void run() {
        handleAuthorization();
        while (true) {

            consoleView.showMenu();
            int choice = inputData.scanner.nextInt();
            inputData.scanner.nextLine();
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
            cardNumber = inputData.inputCardNumber();
        } while (!accountService.isValidCardNumber(cardNumber));
        byte counter = 0;
        String pin;
        do {
            pin = inputData.inputPin();
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
        double amount = inputData.inputWithdrawalAmount();
        if (accountService.withdraw(cardNumber, amount)) {
            consoleView.showSuccessMessage("Снятие средств успешно выполнено.");
        } else {
            consoleView.showErrorMessage("Недостаточно средств на счете.");
        }
    }

    private void handleDeposit() {
        double amount = inputData.inputDepositAmount();
        if (accountService.deposit(cardNumber, amount)) {
            consoleView.showSuccessMessage("Пополнение баланса успешно выполнено.");
        } else {
            consoleView.showErrorMessage("Ошибка пополнения баланса. Сумма должна быть не более 1 000 000.");
        }
    }
}
