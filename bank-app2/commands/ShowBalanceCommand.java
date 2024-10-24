package commands;

import financeManager.FinanceManger;

public class ShowBalanceCommand extends Command {
    private final FinanceManger financeManger;

    public ShowBalanceCommand(FinanceManger financeManger) {
        super("Shows balance", "Balance");
        this.financeManger = financeManger;
    }

    @Override
    public void execute() {
        financeManger.getBalance();
    }
}
