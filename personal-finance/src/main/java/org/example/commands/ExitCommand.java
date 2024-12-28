package org.example.commands;
import java.io.IOException;

import org.example.financeManager.FinanceHandler;
import org.example.utils.TransactionStorage;

public class ExitCommand extends Command{
    TransactionStorage transactionStorage;
    FinanceHandler financeHandler;
    public ExitCommand(FinanceHandler financeHandler){
        super("Exit program", "Exit");
        this.financeHandler = financeHandler;
    }
    @Override
    public void execute() {
        this.transactionStorage = new TransactionStorage(financeHandler.getAccount().getUsername());
        transactionStorage.save(financeHandler.getTransactionHandler().getTransactions());
        System.exit(0);
    }
}
