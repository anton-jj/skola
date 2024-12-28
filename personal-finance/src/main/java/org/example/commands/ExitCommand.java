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
        try {
            transactionStorage.save(financeHandler.getTransactionHandler().getTransactions());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.exit(0);
    }
}
