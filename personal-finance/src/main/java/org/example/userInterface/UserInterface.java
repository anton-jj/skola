
package org.example.userInterface;


public abstract class UserInterface  {
   protected final InputHandler input;
   protected final ConsoleOutput output;

   public UserInterface() {
      this.input = new InputHandler();
      this.output = new ConsoleOutput();
   }

   public abstract void start(); 
   

   public abstract void menu();
   
}
