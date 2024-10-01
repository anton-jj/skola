package command;

import main.Main;
import util.GameObject;
import util.KeyManager;
import util.ObjectManager;

public class PickupCommand {
    private ObjectManager objectManager;
    private KeyManager keyManager;
    public Main main;

    public PickupCommand(Main main, ObjectManager objectManager, KeyManager keyManager) {
        this.main = main;
        this.objectManager = objectManager;
        this.keyManager = keyManager;
    }

    public void pickup(String itemType) {
        if (itemType.equalsIgnoreCase("key")) {
            boolean keyFound = false;
            for (GameObject obj : objectManager.getObjects()) {
                if (obj.hasKey() && keyManager.isKeyVisable(obj)) {
                    obj.removeKey();
                    keyManager.incrementKey();
                    keyFound = true;
                    System.out.println("Key is picked up from " + obj.getName());
                    break;
                }
            }

            if (!keyFound) {
                System.out.println("Theres no key to pick up");
            }
        } else {
            System.out.println("Unvalid type\nYou can only pickup keys");
        }
    }
}
