package util;

import java.util.ArrayList;
import java.util.List;

import main.Main;

public class ObjectManager {

    private List<GameObject> objects;
    public Main main;

    public ObjectManager(Main main) {
        this.main = main;
        objects = new ArrayList<>();
        createObjects();
    }

    private void createObjects() {
        objects.add(new GameObject("Chest", false));
        objects.add(new GameObject("Coffin", true));
        objects.add(new GameObject("Bag", false));
        objects.add(new GameObject("Oven", false));
        objects.add(new GameObject("Cookie Jar", true));
        objects.add(new GameObject("Cabinet", false));
    }

    public List<GameObject> getObjects() {
        return objects;
    }

    public GameObject objectsbyName(String name) {

        for (GameObject obj : objects) {
            if (obj.getName().equalsIgnoreCase(name)) {
                return obj;
            }
        }
        return null;
    }
}
