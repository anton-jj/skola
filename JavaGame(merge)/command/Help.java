package command;
import main.Main;

public class Help {
    public Main main;

    public Help(Main main) {
      this.main = main;
    }

    public void help() {
        System.out.println("Type the command \n 1. 'Help' \n 2. 'Search' \n 3. 'Open' \n 4. 'Pick up' \n 5. 'Say' \n 6. 'Exit'" );
    }
    
}