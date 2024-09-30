package util;

import java.util.ArrayList;
import java.util.List;
public class ObjectManager {
    private List<GameObject> objects;

    public ObjectManager() {
        objects = new ArrayList<>();
    }
    public void addObject(GameObject obj){
        objects.add(obj);
    }

    public List<GameObject> getObjects(){
        return objects;
    }

    // returnerar object som matchar det angivna namnet från string eller null om
    // inte hittar något
    public GameObject objectsbyName(String name) {
        // kollar efete r ett objekt med det angivna nmanet
        for (GameObject obj : objects) {
            if (obj.getName().equalsIgnoreCase(name)) {
                return obj;
            }
        }
        // om inget hittas returneara null
        return null;
    }
}
