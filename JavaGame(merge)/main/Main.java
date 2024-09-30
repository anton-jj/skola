package main;

import command.CommandManager;
import util.ObjectManager;

public class Main {
    boolean playing = true;
    public CommandManager commandManager;
    public ObjectManager objectManager;

    public Main() {
        this.objectManager = new ObjectManager(this);
        this.commandManager = new CommandManager(this);
    }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println("""
                Welcome to the Game!
                You wake up in a deserted house. To get out, you need to find 3 keys that are hidden
                In the house there are various objects to search through to find the keys.
                Type 'help' to show the different commands.""");
        boolean showriddle = true;
        while (main.playing) {
            main.commandManager.getCommand();
            if (main.commandManager.getKeyManager().getKeyCount() == 2) {
                if (showriddle) {
                    main.commandManager.sayCommand.oldMan();
                    showriddle = false;
                }
                main.commandManager.sayCommand.showRiddle();
            }
            if (main.commandManager.getKeyManager().getKeyCount() == 3) {
                System.out.println("Congratulations. Now you have all the keys and can leave the house.");
                main.playing = false;
            }
        }
    }
}