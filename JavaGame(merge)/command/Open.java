package command;
import main.Main;
import util.ObjectManager;
import util.GameObject;
import util.KeyManager;

public class Open {
    private ObjectManager objectManager;
    private KeyManager keyManager; 
    public Main main;
    // kontruktor tar emot objectManager för att kunna hantera och
    // söka objekt baserst på namn
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
        // Hämtar GameObject från ObjectManager
        GameObject obj = objectManager.objectsbyName(objectName);
        // lagt till lite felhantering så att om det inte finns i ObjectManager
        if (obj != null) {
            // kontrollera om det hittade objektet ar en nyckel
            if (obj.hasKey()) {
                obj.visableKey();
                keyManager.addVisableKeys(obj);
                System.out.println("Key found in " + obj.getName());
                
            } else {
                System.out.println("Key not found " + obj.getName() );
            }
        } else {
            System.out.println("usage: open <object> \n type help for help");
        }
    }
}
