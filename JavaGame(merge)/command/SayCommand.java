package command;

import main.Main;

public class SayCommand {
    public Main main;
    public String answer;
    public int count;
    String[] hints = { "it's sweet", "it's split in two " };

    public SayCommand(Main main) {
        this.main = main;
        this.answer = "half watermelon";
        this.count = 1;
    }

    public void say(String input) {

        if (input.equalsIgnoreCase(answer)) {
            System.out.println("correct");
            main.commandManager.getKeyManager().incrementKey();
        } else if (!input.equalsIgnoreCase(answer) && count < 3) {
            System.out.println("Wrong answer, Try again!");
        }

        if (count <= 1 && !input.equalsIgnoreCase(answer)) {
            System.out.println("hint: " + hints[0]);
        } else if (count <= 2 && !input.equalsIgnoreCase(answer)) {
            System.out.println("hints: " + hints[1]);
        } else if (!input.equalsIgnoreCase(answer)) {
            System.out.println("Game over!");
            System.exit(0);
        }
        count++;
    }

    public void showRiddle() {
        System.out.println("""
                -------------------------------------------------------------------------------------
                Say a fruit that has the color green on the outside, red on the inside and black seeds.
                The first letter of the fruit's name is H! What is the name of the fruit?
                You have 3 tries to guess get it right!
                -------------------------------------------------------------------------------------""");
    }

    public void oldMan() {
        System.out.println("""
                A mysterious old man appears from the darkness.
                In his hand he carries the last key.
                He says: To get the final key you'll have to answer one riddle...""");
    }
}
