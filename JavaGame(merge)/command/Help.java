package command;
import main.Main;

public class Help {
    public Main main;

    public void help() {
        System.out.println("Available commands:\n'Help'\n'Search'\n'Open <Object>'\n'Pickup <key>'\n'Say <answer>'\n'Exit'" );
    }
    
}