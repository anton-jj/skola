package command;

import java.util.Scanner;

import main.Main;
import util.KeyManager;
import util.ObjectManager;

public class CommandManager {
    /**
     * skapar klasser och objekt för olika kommandon
     */
    public Scanner readCommand;
    public Open openCommand;
    public Help helpCommand;
    private KeyManager keyManager;
    public Say sayCommand;
    public Pickup pickupCommand;
    public ObjectManager objectManager;
    public Search searchCommand;

    public CommandManager(Main main) {
        // initsierar kammandon och objekthanterare och skickar main för interageras med
        // olika delar av spoelet
        objectManager = main.objectManager;
        readCommand = new Scanner(System.in);
        keyManager = new KeyManager();
        openCommand = new Open(main, objectManager, keyManager);
        helpCommand = new Help();
        sayCommand = new Say(main);
        pickupCommand = new Pickup(main, objectManager, keyManager);
        searchCommand = new Search();
    }
    // returnerar KeyMAnagern för att hantera nycklar i spelet.
    // dettta reurnerar en keymanager instans
    public KeyManager getKeyManager() {
        return keyManager;
    }
    /**
     * ansvarar för att ta emot input samnt
     * validera inputen
     * samt anropar lämplig metod baserat på det
     */
    public void getCommand() {
        String input = readCommand.nextLine();
        input = input.toLowerCase();

        if (input.isBlank()) {
            System.out.println("enter valid input ");
            return;
        }

        String[] parts = input.split(" ", 2);

        String command = parts[0]; // kommandot
        String choosenObject;
        if (parts.length > 1) {
            choosenObject = parts[1]; // objektet som användaren valt
        } else {
            choosenObject = "";
        }
        /**
         * switch för att anropa metoder per kommando
         */
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
                if(keyManager.getKeyCount() < 2){
                    System.out.println("Who are ypu talking to?");
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
