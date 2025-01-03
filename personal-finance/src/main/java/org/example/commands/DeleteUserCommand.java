package org.example.commands;

import org.example.financeManager.FinanceHandler;
import org.example.user.Account;
import org.example.user.AccountHandler;
import org.example.userInterface.LoginUI;
import org.example.userInterface.MainUI;

public class DeleteUserCommand extends Command{
    private AccountHandler accountHandler;

    public DeleteUserCommand(AccountHandler accountHandler) {
        super("Delete user", "Delete user");
        this.accountHandler = accountHandler;
    }

    @Override
    public void execute() {
        accountHandler.deleteAccount();
        accountHandler.setCurrent(null);
    }




}
