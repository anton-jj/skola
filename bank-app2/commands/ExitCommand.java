package commands;
import financeManager.FinanceHandler;
import utils.*;

import java.io.IOException;

public class ExitCommand extends Command{
    FileManager fileManager;
    FinanceHandler financeHandler;
    public ExitCommand(FinanceHandler financeHandler){
        super("Exit program", "Exit");
        this.financeHandler = financeHandler;
        this.fileManager = new FileManager();
    }
    @Override
    public void execute() {
        try {
            fileManager.saveData(financeHandler.getTransactions());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.exit(0);
    }
}
