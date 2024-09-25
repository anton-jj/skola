package game;

import java.util.Scanner;

import player.Npc;
import player.Player;
import util.ObjectManager;
import util.printUtil;

public class Game {
    private final ObjectManager objectManager;
    private final Player player;
    private final Scanner scanner;
    private final Npc npc;

    public Game() {
        this.objectManager = new ObjectManager();
        this.player = new Player(objectManager);
        this.scanner = new Scanner(System.in);
        npc = new Npc();

    }

    public void start() {
        boolean playing = true;
        while (player.getKeyCount() != 2 && playing) {
            String input = scanner.nextLine().toLowerCase();
            if (input.isBlank()) {
                System.out.println("Enter valid input");
                continue;
            }

            String[] parts = input.split(" ", 2);
            String command = parts[0];
            String argument = (parts.length > 1) ? parts[1] : "";

            switch (command) {
                case "open":
                    player.open(argument);
                    break;
                case "help":
                    displayHelp();
                    break;
                case "pickup":
                    player.pickup(argument);
                    break;
                case "say":
                    //player.say();
                    break;
                case "search": 
                    player.search();
                    break;
                case "exit":
                    playing = false;
                    break;
                case "talk": 
                    player.talk(npc);
                    break;
                default:
                    System.out.println("Not valid command: " + command);
                    break;
            }

        }
    }

    private void displayHelp() {
        String help = "Type the command \n 1. 'Help' \n 2. 'Open' \n 3. 'Pickup' \n 4. 'Say' \n 5. 'Exit'";
        System.out.print(printUtil.frame(help));
    }
}
