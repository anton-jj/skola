package main;

import command.CommandManager;
import util.*;

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
        System.out.println("Välkommen till Spelet!");

        while (main.playing) {
            main.commandManager.getCommand();
            System.out.println(main.commandManager.getKeyManager().getKeyCount());
            if (main.commandManager.getKeyManager().getKeyCount() == 2) {
                main.playing = false;
                // avslutar programmet

            }
        }

    }
        public CommandManager getCommandManager() {
        return commandManager;
    }

    public ObjectManager getObjectManager() {
        return objectManager;
    }
} 