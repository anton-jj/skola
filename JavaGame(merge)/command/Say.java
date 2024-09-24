package command;
import main.Main;

public class Say{
    public Main main; 
    String answer; 

public Say(Main main){
    this.main = main; 
    this.answer = "en halv vatten mellon";

}

    public void say(String input){
        System.out.println(input);
        if (input.equalsIgnoreCase(answer)){
            System.out.print("thats corrcet\n");
        }else {
            System.out.print("thats not right\n");
        }
    }
    public void showRiddle (){
        System.out.println("Frukt som har har färgen grön på utsidan, rött på insidan samt svarta frön. Första bokstaven på fruktens namn börjar med H! vad heter frukten?");
    }
}
