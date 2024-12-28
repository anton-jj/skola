package org.example.commands;

import org.example.financeManager.FinanceHandler;

public class RemoveTransactionCommand extends Command{
   private final FinanceHandler financeHandler;

    public RemoveTransactionCommand(FinanceHandler financeHandler) {
        super("Remove a transaction", "Remove");
        this.financeHandler = financeHandler;
    }

    @Override
    public void execute() {
        financeHandler.removeTransaction();
    }
}
