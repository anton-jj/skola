package commands;

import financeManager.FinanceManger;

import java.util.HashMap;
import java.util.Map;
public class CommandHandler implements CommandService {
    private FinanceManger financeManger;
    private final Map<Integer, Command> commandMap;
    
    public CommandHandler(FinanceManger financeManger){
        this.financeManger = financeManger;
        this.commandMap = new HashMap<>();
        createCommands();
    }
    public  Map<Integer, Command> getCommandMap(){
        return commandMap;
    }
    private void createCommands() {
        initializeCommand(new ShowBalanceCommand(financeManger));
        initializeCommand(new RemoveTransactionCommand(financeManger));
        initializeCommand(new AddTransactionCommand(financeManger));
        initializeCommand(new ShowTransactionsCommand(financeManger));
    }
    @Override
    public void initializeCommand(Command command) {
        commandMap.put(command.getCommandId(), command);
    }

    @Override
    public void executeCommand(int id) {
        Command command = commandMap.get(id);
        if (command != null) {
            command.execute();
        }
    }
}
