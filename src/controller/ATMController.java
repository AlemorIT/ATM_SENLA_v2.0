package controller;

import utils.InputData;
import service.AccountServiceHandler;
import repository.AccountsRepository;
import repository.FileAccountRepository;
import service.AccountService;
import view.ConsoleView;

public class ATMController {
    AccountsRepository fileAccountRepository = new FileAccountRepository();
    AccountService accountService = new AccountService(fileAccountRepository);
    ConsoleView consoleView = new ConsoleView();
    InputData inputData = new InputData();
    public void execute(){
        AccountServiceHandler serviceHandler = new AccountServiceHandler(accountService, consoleView, inputData);
        serviceHandler.run();
    }
}
