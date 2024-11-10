package commands;

import financeManager.FinanceHandler;

public class AddTransactionCommand extends Command{
    private final FinanceHandler financeHandler;

    public AddTransactionCommand(FinanceHandler financeHandler){
       super( "Add new transaction", "add" );
       this.financeHandler = financeHandler;
    }

    @Override
    public void execute() {
       financeHandler.addTransaction();
    }
}
