package util;
import java.util.HashSet;
import java.util.Set;
import main.Main;
public class KeyManager {

    private Set<GameObject> visableKeys; 
    private int keyCount; 

    public KeyManager(Main main){
        this.visableKeys = new HashSet<>();
        this.keyCount = 0; 
    }
    public void addVisableKeys(GameObject obj){
        if(obj.hasKey()){
            visableKeys.add(obj);
        }
    }
    // tabort nycklar  från objekt
    public void removeKey(GameObject obj){
        if (visableKeys.contains(obj)){
            visableKeys.remove(obj);
            obj.removeKey();
            keyCount ++;
        }
    }
    public int incrementKey(){
        return keyCount++;
    }
    public int decrementKey(){
        return keyCount--;
    }
    public boolean isKeyVisable(GameObject obj){
        return visableKeys.contains(obj);
    }

    public int getKeyCount(){
        return keyCount;
    }

}
