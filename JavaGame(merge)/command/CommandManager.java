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
    private Say sayCommand;
    public Pickup pickupCommand;
    public ObjectManager objectManager;
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

    }

    public KeyManager getKeyManager(){
        return keyManager;
    }

    public void getCommand() {
        // läser kommando från användare
        String input = readCommand.nextLine();
        // Omvandlar det till små bokstäver för at säkra att det alltid kommer in i
        // samma form
        input = input.toLowerCase();
        // kollar om tomt eller bara whitespace
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

        // Tilldelar kommando och objekt från split

        // switch istället för if vet inte vad vi vill ha
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
                sayCommand.say(choosenObject);    
                break;
            default:
                System.out.println("not valid command:  " + command);
                break;

        }
    }
}
