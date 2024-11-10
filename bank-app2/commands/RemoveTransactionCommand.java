package commands;

import financeManager.FinanceHandler;

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
