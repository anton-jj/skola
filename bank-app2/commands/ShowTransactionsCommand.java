package commands;
import financeManager.FinanceManger;

public class ShowTransactionsCommand extends Command{
  private final FinanceManger financeManger;

  public ShowTransactionsCommand(FinanceManger financeManager){
      super("Show transactions", "Transactions");
      this.financeManger = financeManager;
      }

    @Override
    public void execute(){
      financeManger.listTransactions();
      }
  }
