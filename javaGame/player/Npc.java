package player;

import java.util.Scanner;

public class Npc {
    String riddle; 
    String[] hints = {"it's sweet", "it's cut in half", "yes", "this is a riddle", "stopid"};
    String[] messages =  {"What do you want", "nononoon", "something", "message", "something"};
    Scanner scanner;
    String answer = "half watermelon";
    public Npc(){
        this.riddle = "What fruit is green on the outside red on the inside and has black seeds, and starts with the letter H";
    }

    public String getRiddle(){
        return riddle;
    }
    public String[] getHints(){
        return hints;
    }
    public String[] getMessages(){
        return messages;
    }
    public void interact(Player player){
        boolean talking = true;
        int index = (int) (Math.random() * hints.length); 

        Scanner scanner = new Scanner(System.in);
        System.out.println(messages[index]);

        while(talking){
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("riddle"))  {
            System.out.println(getRiddle());
        }else if(input.equalsIgnoreCase("hint")) {
            System.out.println(hints[index]);
        }else if(input.equalsIgnoreCase("leave")){
            System.out.println("good talking to you, bye");
            talking = false;
        }else if(input.equalsIgnoreCase("answer")){
            String guess = scanner.nextLine();
            if (guess.equalsIgnoreCase(answer)){
                System.out.println("thats correct\nheres a key");
                player.incrementKey();
            }
        }
        }
    }

}