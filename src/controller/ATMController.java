package controller;

import utils.ConsoleReader;
import service.AccountServiceHandler;
import repository.AccountsRepository;
import repository.FileAccountRepository;
import service.AccountService;
import utils.Reader;
import view.ConsoleView;

public class ATMController {

    AccountsRepository fileAccountRepository = new FileAccountRepository();
    AccountService accountService = new AccountService(fileAccountRepository);
    ConsoleView consoleView = new ConsoleView();
    Reader reader = new ConsoleReader();

    public void execute(){
        AccountServiceHandler serviceHandler = new AccountServiceHandler(accountService, consoleView, reader);
        serviceHandler.run();
    }
}
