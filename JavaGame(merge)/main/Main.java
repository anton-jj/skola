package main;

import command.CommandManager;
import util.ObjectManager;

public class Main {
    boolean playing = true;
    public CommandManager commandManager; // skapar en Commandmanager som hanterar kommandon i programmet 
    public ObjectManager objectManager; // skapar en ObjectMAnager som hanterar GameObjects genom spelet 

    /**
     * konjstruktor för main klassen 
     * här initialsieras objectmanager och commandmanager, och  denna instans av main skickas runt 
     * i programmet för att komunicera med olika dealr av programmet 
     */
    public Main() {
        this.objectManager = new ObjectManager(this); 
        this.commandManager = new CommandManager(this);
    }

    public static void main(String[] args) {
        // skapar main 
        Main main = new Main();
        // printar en start av speleet
        System.out.println("""
                Welcome to the Game!
                You wake up in a deserted house. To get out, you need to find 3 keys that are hidden
                In the house there are various objects to search through to find the keys.
                Type 'help' to show the different commands.""");
        // håller koll på om gåtan ska visas eller inte 
        boolean showriddle = true;
        /**¨
         * huvud loop för spelet
         * medans denna körs så spelar man spelet  
         */
        while (main.playing) {
            /**
             * anropar metod som tar emot input från användaren samt validerar det
             * getcommand innehåller även switch satsen som hanterar kommandon för spelet
             */
            main.commandManager.getCommand();
            /**
             * kontrollerar om man hittat 2 nycklar eller ej för att komma vidare i spelet
             */
            if (main.commandManager.getKeyManager().getKeyCount() == 2) {
                // kontrollerar om man visar gåta eller ej
                if (showriddle) {
                    main.commandManager.sayCommand.oldMan();
                    showriddle = false;
                }
                main.commandManager.sayCommand.showRiddle();
            }
            if (main.commandManager.getKeyManager().getKeyCount() == 3) {
                // gratulera spelaren för att klara ut spelet. playing = false
                System.out.println("Congratulations. Now you have all the keys and can leave the house.");
                main.playing = false;
            }
        }
    }
    /**
     * returnerar commandmanager och ObjektManager för att använda endast dessa i resten av preogrammet 
     */
    public CommandManager getCommandManager() {
        return commandManager;
    }

    public ObjectManager getObjectManager() {
        return objectManager;
    }
}