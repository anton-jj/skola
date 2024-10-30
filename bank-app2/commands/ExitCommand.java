package commands;
import financeManager.FinanceHandler;
import utils.*;

import java.io.IOException;

public class ExitCommand extends Command{
    TransactionStorage transactionStorage;
    FinanceHandler financeHandler;
    public ExitCommand(FinanceHandler financeHandler){
        super("Exit program", "Exit");
        this.financeHandler = financeHandler;
        this.transactionStorage = new TransactionStorage();
    }
    @Override
    public void execute() {
        try {
            transactionStorage.save(financeHandler.getTransactionHandler().getTransactions());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.exit(0);
    }
}
