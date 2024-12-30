package org.example.commands;
import java.io.IOException;

import org.example.financeManager.FinanceHandler;
import org.example.utils.Database;
import org.example.utils.DatabaseTransactionStorage;
import org.example.utils.TransactionStorage;

public class ExitCommand extends Command{
    DatabaseTransactionStorage transactionStorage;
    FinanceHandler financeHandler;
    Database db ;
    public ExitCommand(FinanceHandler financeHandler){
        super("Exit program", "Exit");
        this.financeHandler = financeHandler;
        this.db = Database.getInstance();
    }
    @Override
    public void execute() {
        this.transactionStorage = new DatabaseTransactionStorage(db.getConnection(), financeHandler.getAccount());
        transactionStorage.save(financeHandler.getTransactionHandler().getTransactions());
        System.exit(0);
    }
}
