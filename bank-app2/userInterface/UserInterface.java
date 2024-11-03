
package userInterface;

import commands.Command;
import commands.CommandHandler;
import financeManager.FinanceHandler;
import utils.InputHandler;

public class UserInterface  {
   private final CommandHandler commandHandler;
   private final InputHandler inputHandler;

   public UserInterface(FinanceHandler financeManager) {
      this.commandHandler = new CommandHandler(financeManager);
      this.inputHandler = new InputHandler();
   }

   public void start() {
      while (true) {
      menu();
      int input = inputHandler.readIndex();
      commandHandler.executeCommand(input);
   }
   }

   private void menu() {
      System.out.println("--------Personal finance--------");
      for(Command command : commandHandler.getCommandMap().values()) {
         System.out.printf("%d. %s%n", command.getCommandId(), command.getDescription(), command.getName());
      }
      System.out.println("--------------------------------");
   }

   }
