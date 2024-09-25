package command;

import main.Main;
import util.GameObject;
import util.KeyManager;
import util.ObjectManager;

public class Open {
    private ObjectManager objectManager;
    private KeyManager keyManager;
    public Main main;

    public Open(Main main, ObjectManager objectManager, KeyManager keyManager) {
        this.main = main;
        this.objectManager = objectManager;
        this.keyManager = keyManager;
    }

    public void checkKey(String objectName) {
        if (objectManager == null) {
            System.out.println("ObjectManager is not initialized.");
            return;
        }
        GameObject obj = objectManager.objectsbyName(objectName);

        if (obj != null) {
            if (obj.hasKey()) {
                obj.visableKey();
                keyManager.addVisableKeys(obj);
                System.out.println("Key found in " + obj.getName());

            } else {
                System.out.println("Key not found " + obj.getName());
            }
        } else {
            System.out.println("usage: open <object> \n type help for help");
        }
    }
}
