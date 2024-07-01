package Repository;

import Model.Account;

public interface AccountsRepository {
    void saveAccount(Account account);
    Account getAccount(String cardNumber);
    void updateAccount(Account account);
}
