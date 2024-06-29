import Controller.ATMController;
import Model.*;
import View.ConsoleView;

public class Main {
    public static void main(String[] args) {
        AccountsRepository fileAccountRepository = new FileAccountRepository();
        AccountService accountService = new AccountService(fileAccountRepository);
        ConsoleView consoleView = new ConsoleView();
        ATMController atmController = new ATMController(consoleView, accountService);

        atmController.run();
    }
}