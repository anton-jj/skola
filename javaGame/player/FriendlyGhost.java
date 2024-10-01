package player;

import java.util.Random;
import java.util.Scanner;

import game.Game;
import game.Room;
import util.printUtil;

public class FriendlyGhost extends Npc {
    private String[] messages = {
        "Boo! need some help?",
        "I really can guide you:)",
        "Remeber to search around you!",
        "You can look around to find things"
    };
    private Random random;
    private Game game;

    public FriendlyGhost(Game game) {
        super("ivan", "a cute little ghost", 200, 10);
        this.game = game;
        this.random = new Random();
    }
    public void showMenu() {
        boolean showMenu = true; 
        while(showMenu) {
            System.out.println("""
                    What would you like to do? 
                    1. help 
                    2. map
                    3. talk 
                    4. exit menu
                    """);
            
                    Scanner scanner = new Scanner(System.in);
                    String choice = scanner.nextLine();
                    switch(choice){
                        case "1":
                        provideHelp();
                        break;
                        case "2":
                        showMap();
                        break;
                        case "3":
                        interact();
                        break;
                        case "4": 
                            showMenu = false;
                        break; 
                        default: 
                            System.out.println("Invalid choice");
                    }

        }

    }
    @Override
    public void interact() {
        int index = random.nextInt(messages.length);
        printUtil.typeWriter(messages[index]);
    }
    private void showMap(){
        System.out.println("You are now in " + game.getPlayer().getCurentRoom());
        for (Room room : game.getRooms()) {
           System.out.println(room.getName()); 
        }
    }
    public void provideHelp() {
        String help = printUtil.frame("""
          Here's some advice
          1. Use 'look' to see what's around you
          2. Type 'move <direction>' to navigate to a new room
          3. Type 'move <direction>' to navigate to a new room.
          4. Don't forget to 'talk' to me for more tips!
          """);
        System.out.println(help);
    }
}
