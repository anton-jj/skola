package commands;

import financeManager.FinanceManger;

public class RemoveTransactionCommand extends Command{
   private final FinanceManger financeManger;

    public RemoveTransactionCommand(FinanceManger financeManger) {
        super("Remove a transaction", "Remove");
        this.financeManger = financeManger;
    }


    @Override
    public void execute() {
        financeManger.removeTransaction();
    }
}
