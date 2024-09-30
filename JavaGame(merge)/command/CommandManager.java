package command;

import java.util.Scanner;

import main.Main;
import util.KeyManager;
import util.ObjectManager;

public class CommandManager {
    public Scanner readCommand;
    public Open openCommand;
    public Help helpCommand;
    private KeyManager keyManager;
    public Say sayCommand;
    public Pickup pickupCommand;
    public ObjectManager objectManager;
    public Search searchCommand;

    public CommandManager(Main main) {
        objectManager = main.objectManager;
        readCommand = new Scanner(System.in);
        keyManager = new KeyManager();
        openCommand = new Open(main, objectManager, keyManager);
        helpCommand = new Help();
        sayCommand = new Say(main);
        pickupCommand = new Pickup(main, objectManager, keyManager);
        searchCommand = new Search();
    }

    public KeyManager getKeyManager() {
        return keyManager;
    }
    public void getCommand() {
        String input = readCommand.nextLine();
        input = input.toLowerCase().trim();
        if (input.isBlank()) {
            System.out.println("Enter valid input ");
            return;
        }
        String[] parts = input.split(" ", 2);
        String command = parts[0];
        String choosenObject;
        if (parts.length > 1) {
            choosenObject = parts[1]; 
        } else {
            choosenObject = "";
        }
        switch (command) {
            case "open":
                openCommand.checkKey(choosenObject);
                break;
            case "help":
                helpCommand.help();
                break;
            case "pickup":
                pickupCommand.pickup(choosenObject);
                break;
            case "say":
                if (keyManager.getKeyCount() < 2) {
                    System.out.println("Who are you talking to?");
                    break;
                }
                sayCommand.say(choosenObject);
                break;
            case "search":
                searchCommand.search(objectManager);
                break;
            case "exit":
                System.exit(0);
                break;
            default:
                System.out.println("not valid command: " + command + "\nTry 'help'");
                break;
        }
    }
}
