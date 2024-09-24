package command;

import main.Main;

public class Say {
    public Main main;
    public String answer;
    public int count;
    String[] hints = { "it's sweet", "it's split in two " };

    public Say(Main main) {
        this.main = main;
    this.answer = "half watermelon";
    this.count = 1;
    }

    public void say(String input) {
        System.out.println(count);
        if (input.equalsIgnoreCase(answer)) {
            System.out.println("correct");
            main.commandManager.getKeyManager().incrementKey();
        } else if (!input.equalsIgnoreCase(answer) && count < 3) {
            System.out.println("Wrong answer, Try again!");
            if (count == 1){
                System.out.println("hint: " + hints[0]);
            } else if (count == 2){
                System.out.println("hints: " + hints[1]);
            }
            count++;
        }else {
            System.out.println("u dead");
            System.exit(0);
        }
    }

    public void showRiddle() {
        System.out.println("Fruit that has the color green on the outside, red on the inside and black seeds. " + 
                "The first letter of the fruit's name begins with H! What is the name of the fruit?");
    }
    public void oldMan(){
        System.out.println("A mysterious old man appears from the darkness." +
                "\nIn his hand he carries the last key." +
                "\nHe says: To get the final key you'll have to answer one riddle..." + "\n" 
                );
    }
}





/*
 * A mysterious old man appears from the darkness.
 * In his hand he carries the last key. He says:
 * "To get the final key you'll have to answer one riddle..."
 *
 * Fruit that has the color green on the outside, red on the inside, and black
 * seeds.
 * The first letter of the fruit's name begins with H! What is the name of the
 * fruit?
 */
