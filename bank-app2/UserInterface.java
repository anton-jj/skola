import commands.*;
import financeManager.FinanceHandler;

import java.util.Scanner;

public class UserInterface  {
   private final Scanner scanner;
   private final FinanceHandler financeManager;
   private final CommandHandler commandHandler;

   public UserInterface(FinanceHandler financeManager) {
      this.financeManager = financeManager;
      this.commandHandler = new CommandHandler(financeManager);
      this.scanner = new Scanner(System.in);
   }

   public void start() {
      while (true) {
      menu();
      int input = getUserInput(scanner);
      commandHandler.executeCommand(input);
   }
   }

   private int getUserInput(Scanner scanner) {
      while (true) {
         try {
            System.out.print("Enter option: ");
            return scanner.nextInt();
         } catch (NumberFormatException e) {
            System.out.println("Not valid input, Please enter a number");
         }
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
