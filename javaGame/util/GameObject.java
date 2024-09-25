package util;

import java.util.HashSet;
import java.util.Set;

// skapar objekt met namn och nyckel eller ej
public class GameObject {
    String name;
    private final Set<GameObject> visibleKeys;

    boolean hasKey;
    boolean visableKey;

    // konstruktor för att sätta namn och nyckelstatus
    public GameObject(String name, boolean hasKey) {
        this.name = name;
        this.hasKey = hasKey;
        this.visibleKeys = new HashSet<>();

    }

    // getter returnerar namn på objekt
    public String getName() {
        return name;
    }

    public boolean isKeyVisible(GameObject obj) {
        return visibleKeys.contains(obj);
    }

    // returnerar värdet åp om objekt har nyckel eller int e
    public boolean hasKey() {
        return hasKey;
    }

    public void visableKey() {
        this.visableKey = true;
    }

    public void removeKey() {
        this.hasKey = false;
    }

    // flytta
    public void addVisibleKey(GameObject obj) {
        if (obj.hasKey()) {
            obj.visibleKeys.add(obj);
        }
    }

    // flytta
    public void removeKey(GameObject obj) {
        if (obj.visibleKeys.contains(obj)) {
            visibleKeys.remove(obj);
            obj.removeKey();
        }
    }
}