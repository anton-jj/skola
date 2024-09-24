package command;
import util.ObjectManager;
import main.Main;

public class SearchCommand {
    private Main main;
    
    public SearchCommand(Main main) {
        this.main = main;
    }
    public void run(ObjectManager objectManager) {
        for (Object obj : objectManager.getObjects()) {
            System.out.println(obj);
        }
        System.out.println("Write open <object> to open");
    }
   
}