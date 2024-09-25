package util;

import java.util.HashSet;
import java.util.Set;

public class KeyManager {

    private Set<GameObject> visableKeys; // mängden av synliga nycklar
    private int keyCount; // räknare för antealet hittade nycklar
    public KeyManager() {
        this.visableKeys = new HashSet<>();
        this.keyCount = 0;
    }
    // lägg till nyckel till dem synliga om objektet har en nyckel
    public void addVisableKeys(GameObject obj) {
        if (obj.hasKey()) {
            visableKeys.add(obj);
        }
    }
    public void removeKey(GameObject obj) {
        if (visableKeys.contains(obj)) {
            visableKeys.remove(obj);
            obj.removeKey();
            keyCount++;
        }
    }

    public int incrementKey() {
        return keyCount++;
    }

    public int decrementKey() {
        return keyCount--;
    }

    public boolean isKeyVisable(GameObject obj) {
        return visableKeys.contains(obj);
    }

    public int getKeyCount() {
        return keyCount;
    }

}
