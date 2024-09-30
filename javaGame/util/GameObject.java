package util;

import java.util.HashSet;
import java.util.Set;

public class GameObject {
    String name;
    private final Set<GameObject> visibleKeys;
    boolean hasKey;
    boolean visableKey;
    boolean open;
    

    public GameObject(String name, boolean hasKey, boolean open) {
        this.open = open;
        this.name = name;
        this.hasKey = hasKey;
        this.visibleKeys = new HashSet<>();

    }
    public boolean getOpen(){
        return open;
    }
    public String getName() {
        return name;
    }

    public boolean isKeyVisible(GameObject obj) {
        return visibleKeys.contains(obj);
    }

    public boolean hasKey() {
        return hasKey;
    }

    public void visableKey() {
        this.visableKey = true;
    }

    public void removeKey() {
        this.hasKey = false;
    }

    public void addVisibleKey(GameObject obj) {
        if (obj.hasKey()) {
            obj.visibleKeys.add(obj);
        }
    }

    public void removeKey(GameObject obj) {
        if (obj.visibleKeys.contains(obj)) {
            visibleKeys.remove(obj);
            obj.removeKey();
        }
    }
}