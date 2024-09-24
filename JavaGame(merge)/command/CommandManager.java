package command;
import util.KeyManager;
import java.util.Scanner;
import main.Main;
import util.*;

public class CommandManager {
    public Scanner readCommand;
    public Open openCommand;
    public Help helpCommand;
    private KeyManager keyManager;
    public Say sayCommand;
    public Pickup pickupCommand;
    public ObjectManager objectManager;
    public SearchCommand searchCommand;
    //public Main main;
    public CommandManager(Main main) {
        // initialiserar kommandon, objekthanterare och öppning
        this.objectManager = main.getObjectManager(); // Hämta ObjectManager från Main
        readCommand = new Scanner(System.in);
        keyManager = new KeyManager(main);
        openCommand = new Open(main, objectManager, keyManager);
        helpCommand = new Help(main);
        sayCommand = new Say(main);
        pickupCommand = new Pickup(main, objectManager, keyManager);
        searchCommand = new SearchCommand(main);

    }

    public KeyManager getKeyManager(){
        return keyManager;
    }

    public void getCommand() {
        // läser kommando från användare
        String input = readCommand.nextLine();

        input = input.toLowerCase();

        if (input.isBlank()) {
            System.out.println("enter valid input ");
            return;
        }

        // Så att input finns i två delar för både kommando och objekt
        String[] parts = input.split(" ", 2);
        String command = parts[0];
        String choosenObject;

        if (parts.length > 1) {
            choosenObject = parts[1];
        }else {
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
                //sayCommand.showRiddle();    
                sayCommand.say(choosenObject);
                break;
            case "search":
                searchCommand.run(objectManager);
                break;
            case "exit": 
                System.exit(0);
                break; 
            default:
                System.out.println("not valid command:  " + command);
                break;

        }
    }
}
