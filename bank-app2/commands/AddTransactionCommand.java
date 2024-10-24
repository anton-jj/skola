package commands;

import financeManager.FinanceManger;

public class AddTransactionCommand extends Command{
    private final FinanceManger financeManger;

    public AddTransactionCommand(FinanceManger financeManger){
       super( "Add new transaction", "add" );
       this.financeManger = financeManger;
    }

    @Override
    public void execute() {
       financeManger.addTransaction();
    }

}
