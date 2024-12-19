package org.example.commands;
import org.example.financeManager.FinanceHandler;

public class ShowTransactionsCommand extends Command{
  private final FinanceHandler financeHandler;

  public ShowTransactionsCommand(FinanceHandler financeManager){
      super("Show transactions", "Transactions");
      this.financeHandler = financeManager;
      }

    @Override
    public void execute(){
      financeHandler.listTransactions();
      }
  }
