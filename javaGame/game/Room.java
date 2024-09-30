package game;
import java.util.HashMap;
import java.util.Map;

import util.ObjectManager;

public abstract class Room {
    private String name;
    private String description;
    protected ObjectManager objectManager;
    private Map<String, Room> exits; 
    
    public Room(String name, String description){
        this.name = name; 
        this.description = description;
        this.objectManager = new ObjectManager();
        this.exits = new HashMap<>();
        createObjects();
    }
    
    protected abstract void createObjects();

    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }
    public ObjectManager getObjectManager(){
        return objectManager;
    }
    public void setExit(String direction, Room room) {
        exits.put(direction, room);
    }

    public Room getExit(String direction) {
        return exits.get(direction);
    }
}
