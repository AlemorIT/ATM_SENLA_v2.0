package Controller;

import utils.InputData;
import Service.AccountServiceHandler;
import Repository.AccountsRepository;
import Repository.FileAccountRepository;
import Service.AccountService;
import View.ConsoleView;

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
