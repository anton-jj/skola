package command;
import main.Main;
import util.GameObject;
import util.KeyManager;
import util.ObjectManager;

public class Pickup {
    private ObjectManager objectManager;
    private KeyManager keyManager; 
    public Main main; 

    public Pickup( Main main, ObjectManager objectManager, KeyManager keyManager) {
        this.main = main;
        this.objectManager = objectManager;
        this.keyManager = keyManager;
        //this.keyCount = 0; // Initialiserar nyckelräknaren
    }

	public void pickup(String itemType) {
        if (itemType.equalsIgnoreCase("key")){
            boolean keyFound = false; 
            // fixa pickup alla nycklar 
            for (GameObject obj : objectManager.getObjects()){
                if(obj.hasKey() && keyManager.isKeyVisable(obj)){
                    obj.removeKey();
                    keyManager.incrementKey();
                    keyFound = true; 
                }
            
            }if (keyFound){
                System.out.println("Key is picked up from ");
            }if (!keyFound){
                System.out.println("Theres no key to pick up");
            }
        }else {
            System.out.println("Unvalid type");
        }
    }
}
