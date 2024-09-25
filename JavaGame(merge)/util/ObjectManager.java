package util;

import java.util.ArrayList;
import java.util.List;

import main.Main;

public class ObjectManager {
    private List<GameObject> objects;
    public Main main; // refererar till main för kommunicationene mellan dem

    public ObjectManager(Main main) {
        this.main = main; // sätter referensen till main
        objects = new ArrayList<>(); // initsierar en lista med objekt
        createObjects(); // skapar objekt när objectmanager initieras och lägger till dem i lista n
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
    public List<GameObject> getObjects() {
        return objects;
    }

    // Returnerar ett GameObject som matchar med angivet namn, eller null om inget
    // hittas
    public GameObject objectsbyName(String name) {
        // loopar igeniom alla objekt och jämför deras namns med det angivna nmanet
        for (GameObject obj : objects) {
            if (obj.getName().equalsIgnoreCase(name)) {
                return obj;
            }
        }
        // om inget hittas returneara null
        return null;
    }
}
