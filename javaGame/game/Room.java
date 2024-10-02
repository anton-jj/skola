package game;
import util.ObjectManager;

public abstract class Room {
    private final RoomName name;
    protected ObjectManager objectManager;
    
    public Room(RoomName name){
        this.name = name;
        this.objectManager = new ObjectManager();
        createObjects();
    }
    
    protected abstract void createObjects();

    public String getName(){
        return name.getDisplayName();
    }
    public String getDescription(){
        return name.getDescription();
    }
    public ObjectManager getObjectManager(){
        return objectManager;
    }
}
