package main;
import game.Game;
import util.printUtil;
public class Main {
    public static void main(String[] args) {
        // Skapa en instans av Game, som hanterar allt spelets logik
        Game game = new Game();
        
        // Starta spelet
        printUtil.typeWriter(printUtil.GameMessages.WELCOME_MESSAGE.getMessage());
        game.start();
    }
}
