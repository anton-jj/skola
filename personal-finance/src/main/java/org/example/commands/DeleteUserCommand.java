package org.example.commands;

import org.example.financeManager.FinanceHandler;
import org.example.user.Account;
import org.example.user.AccountHandler;

public class DeleteUserCommand extends Command{
    private Account currentAccount;
    private AccountHandler ah;
    
    public DeleteUserCommand(Account currentAccount) {
        super("Delete user", "Delete user");
        this.currentAccount = currentAccount;
    }

    public void execute(AccountHandler ah) {
        ah.deleteAccount(currentAccount.getUsername());
    }
    @Override
    public void execute() {

    }
}
