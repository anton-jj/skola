package commands;

import financeManager.FinanceHandler;
import financeManager.ReportGenerator;

public class ReportCommand extends  Command{
private final FinanceHandler financeHandler;

public ReportCommand(FinanceHandler financeHandler){
    super("Show Report", "Report");
    this.financeHandler = financeHandler;
}
    @Override
    public void execute() {
        financeHandler.report();
    }
}