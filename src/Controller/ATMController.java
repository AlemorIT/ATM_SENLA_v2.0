package Controller;

import Model.InputData;
import Model.ServiceHandler;
import Repository.*;
import Service.AccountService;
import View.ConsoleView;

public class ATMController {
    AccountsRepository fileAccountRepository = new FileAccountRepository();
    AccountService accountService = new AccountService(fileAccountRepository);
    ConsoleView consoleView = new ConsoleView();
    InputData inputData = new InputData();
    public void execute(){
        ServiceHandler serviceHandler = new ServiceHandler(accountService, consoleView, inputData);
        serviceHandler.run();
    }
}
