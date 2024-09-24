package util;

import java.util.List;
import java.util.ArrayList;
import main.Main;


public class ObjectManager {
    private List<GameObject> objects;
    public Main main;
    // initiserar lista och skapar objekt

    public ObjectManager(Main main) {
        this.main = main;
        objects = new ArrayList<>();
        createObjects(); // skapar objekt när objectmanager initieras
    }

    // skapa objekt lista
    private void createObjects() {
        objects.add(new GameObject("Chest", false));
        objects.add(new GameObject("Coffin", true));
        objects.add(new GameObject("Bag", false));
        objects.add(new GameObject("Oven", false));
        objects.add(new GameObject("Cookie Jar", true));
        objects.add(new GameObject("Cabinet", false));
        
        
        // bara att lägga till fler om vi vill ha
    }
    // returnerar listan för att tillgäglig alla 
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

