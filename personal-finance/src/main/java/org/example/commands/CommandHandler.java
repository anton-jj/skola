package org.example.commands;

import java.util.HashMap;
import java.util.Map;

import org.example.financeManager.FinanceHandler;
import org.example.user.AccountHandler;

public class CommandHandler implements CommandService {
	private FinanceHandler financeHandler;
	private final Map<Integer, Command> commandMap;
	private  AccountHandler accountHandler;

	public CommandHandler(FinanceHandler financeHandler, AccountHandler accountHandler){
		this.financeHandler = financeHandler;
		this.commandMap = new HashMap<>();
		this.accountHandler = accountHandler;
		createCommands();
	}

	public  Map<Integer, Command> getCommandMap(){
		return commandMap;
	}

	private void createCommands() {
		initializeCommand(new ShowBalanceCommand(financeHandler));
		initializeCommand(new RemoveTransactionCommand(financeHandler));
		initializeCommand(new AddTransactionCommand(financeHandler));
		initializeCommand(new ShowTransactionsCommand(financeHandler));
		initializeCommand(new ReportCommand(financeHandler));
		initializeCommand(new ExitCommand(financeHandler));
		initializeCommand(new LogoutCommand(accountHandler));
		initializeCommand(new DeleteUserCommand(accountHandler));
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
