package command;

import util.ObjectManager;

public class SearchCommand {

    public void search(ObjectManager objectManager) {
        System.out.println("You see: ");
        for (Object obj : objectManager.getObjects()) {
            System.out.println(obj);
        }
        System.out.println("Write open <object> to open");
    }
}