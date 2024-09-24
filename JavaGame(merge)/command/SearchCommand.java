package command;
import main.Main;
import util.ObjectManager;

public class SearchCommand {
    public SearchCommand(Main main) {
    }
    public void run(ObjectManager objectManager) {
        for (Object obj : objectManager.getObjects()) {
            System.out.println(obj);
        }
        System.out.println("Write open <object> to open");
    }
}