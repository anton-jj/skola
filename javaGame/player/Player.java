package player;
import util.GameObject;
import util.ObjectManager;
import util.printUtil;
 


public class Player {
    private int keyCount;
    private final ObjectManager objectManager;

    public Player(ObjectManager objectManager) {
        this.objectManager = objectManager;
        this.keyCount = 0;
    }

    public int getKeyCount() {
        return keyCount;
    }


    public void pickup(String itemType) {
        if (itemType.equalsIgnoreCase("key")) {
            boolean keyFound = false;
            for (GameObject obj : objectManager.getObjects()) {
                if (obj.hasKey() && obj.isKeyVisible(obj)) {
                    obj.removeKey();
                    obj.removeKey(obj);
                    keyCount ++;
                    keyFound = true;
                }
            }
            if (keyFound) {
                System.out.println("Key picked up.");
            } else {
                System.out.println("No key to pick up.");
            }
        } else {
            System.out.println("Invalid type");
        }
    }

    public void open(String objectName) {
        GameObject obj = objectManager.objectsbyName(objectName);
        if (obj != null) {
            if (obj.hasKey()) {
                obj.visableKey();
                obj.addVisibleKey(obj);
                System.out.println("Key found in " + obj.getName());
            } else {
                System.out.println("Key not found in " + obj.getName());
            }
        } else {
            System.out.println("Usage: open <object> \n Type help for help");
        }
    }

    public void search(){
        System.out.print("You find \n");
        for(GameObject obj : objectManager.getObjects()){
        printUtil.typeWriter(obj.getName());
        System.out.print("\n");
        }
    }
    public void talk(Npc npc) {
        npc.interact(this);
    }
    public int incrementKey(){
        return keyCount++;
    }
}

