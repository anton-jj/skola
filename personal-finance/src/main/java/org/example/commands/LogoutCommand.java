package org.example.commands;

import org.example.user.AccountHandler;
import org.example.userInterface.LoginUI;
import org.example.userInterface.MainUI;

public class LogoutCommand extends Command {
    AccountHandler accountHandler;

    public LogoutCommand(AccountHandler accountHandler){
        super("Logout", "Logout and switch user");
        this.accountHandler = accountHandler;
    }

    @Override
    public void execute() {
        accountHandler.setCurrent(null);
    }
}
