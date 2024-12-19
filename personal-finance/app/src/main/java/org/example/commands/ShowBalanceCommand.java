package org.example.commands;

import org.example.financeManager.FinanceHandler;

public class ShowBalanceCommand extends Command {
    private final FinanceHandler financeHandler;

    public ShowBalanceCommand(FinanceHandler financeHandler) {
        super("Shows balance", "Balance");
        this.financeHandler = financeHandler;
    }

    @Override
    public void execute() {
        financeHandler.getBalance();
    }
}
