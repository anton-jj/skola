package player;

import java.util.Random;
import java.util.Scanner;

import game.Game;
import game.Room;
import util.printUtil;

public class FriendlyGhost extends Npc {
    private Random random;
    private Game game;

    public FriendlyGhost(Game game) {
        super("ivan", "a cute little ghost", 200, 10);
        this.game = game;
        this.random = new Random();
    }
    public void showMenu() {
        boolean showMenu = true; 
        printUtil.typeWriter(printUtil.GameMessages.NPC_GHOST_HELP.getMessage());
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
        int index = random.nextInt(4);
        switch (index){
            case 1:
                printUtil.typeWriter(printUtil.GameMessages.GHOST_TALK_1.getMessage());
                break;
            case 2:
                printUtil.typeWriter(printUtil.GameMessages.GHOST_TALK_2.getMessage());
                break;
            case 3:
                printUtil.typeWriter(printUtil.GameMessages.GHOST_TALK_3.getMessage());
                break;
            case 4:
                printUtil.typeWriter(printUtil.GameMessages.GHOST_TALK_4.getMessage());
                break;
        }
    }
    private void showMap(){
        System.out.println("You are now in " + game.getPlayer().getCurentRoom());
        for (Room room : game.getRooms()) {
           System.out.println(room.getName());
        }
    }
    public void provideHelp() {
        printUtil.frame(printUtil.GameMessages.HELP_MESSAGE.getMessage());
    }
}
