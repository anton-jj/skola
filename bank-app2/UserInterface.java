import commands.*;
import financeManager.FinanceManger;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserInterface implements CommandService {
   private final Scanner scanner;
   private final FinanceManger financeManager;
   private final Map<Integer, Command> commands;

   public UserInterface(FinanceManger financeManager) {
      this.financeManager = financeManager;
      this.scanner = new Scanner(System.in);
      this.commands = new HashMap<>();
      createCommands();
   }

   private void createCommands() {
      initializeCommand(new ShowBalanceCommand(financeManager));
      initializeCommand(new RemoveTransactionCommand(financeManager));
      initializeCommand(new AddTransactionCommand(financeManager));
   }

   public void start() {
      menu();
      int input = getUserInput(scanner);
      executeCommand(input);

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
      for(Command command : commands.values()) {
         System.out.printf("%d. %s%n", command.getCommandId(), command.getDescription(), command.getName());
      }
      System.out.println("--------------------------------");
   }

   @Override
   public void initializeCommand(Command command) {
      commands.put(command.getCommandId(), command);
   }

   @Override
   public void executeCommand(int id) {
      Command command = commands.get(id);
      if (commands != null) {
         command.execute();
      }
   }
}
