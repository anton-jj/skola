
package userInterface;

import commands.Command;
import commands.CommandHandler;
import financeManager.FinanceHandler;

public class UserInterface  {
   private final CommandHandler commandHandler;
   private final InputHandler inputH;
   private final ConsoleOutput output;

   public UserInterface(FinanceHandler financeManager) {
      this.commandHandler = new CommandHandler(financeManager);
      this.inputH = new InputHandler();
      this.output = new ConsoleOutput();
   }

   public void start() {
      while (true) {
      menu();
      int input = inputH.handleMenuPrompt();
      commandHandler.executeCommand(input);
   }
   }

   private void menu() {
      output.displayMessage("--------Personal finance--------");
      for(Command command : commandHandler.getCommandMap().values()) {
    	  output.displatComamnds(command);
      }
      output.displayMessage("--------------------------------");
   }

   }
