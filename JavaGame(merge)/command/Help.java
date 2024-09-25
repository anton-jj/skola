package command;
import main.Main;

public class Help {
    public Main main;

    public Help(Main main) {
      this.main = main;
    }

    public void help() {
        System.out.println("Available commands\n'Help'\n'Search'\n'Open'\n'Pickup'\n'Say'\n'Exit'" );
    }
    
}