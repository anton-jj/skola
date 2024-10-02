package player;

import java.util.ArrayList;

import game.Room;
import util.GameObject;
import util.ObjectManager;
import util.printUtil;
public class Player {
    private int keyCount;
    private Room currentRoom;

    public Player(Room startRoom) {
        this.keyCount = 0;
        this.currentRoom = startRoom;
    }
    public ObjectManager getObjectManager(){
        return currentRoom.getObjectManager();
    }
    public int getKeyCount() {
        return keyCount;
    }
    public Room getCurentRoom(){
        return currentRoom;
    }
    public void pickup(String itemType) {
        ObjectManager objectManager = currentRoom.getObjectManager();
        if (itemType.equalsIgnoreCase("key")) {
            boolean keyFound = false;
            for (GameObject obj : objectManager.getObjects()) {
                if (obj.hasKey() && obj.isKeyVisible(obj)) {
                    obj.removeKey();
                    obj.removeKey(obj);
                    keyCount++;
                    keyFound = true;
                }
            }
            if (keyFound) {
                System.out.println("Key picked up.");
            } else {
                System.out.println("No key to pick up.");
            }
        } else {
            System.out.println("Invalid type");
        }
    }

    public void search(String objectName) {
        ObjectManager objectManager = currentRoom.getObjectManager();
        GameObject obj = objectManager.objectsbyName(objectName);
        if (obj == null) {
            System.out.println("Input valid object");
            return;
        }
        if (obj.getOpen()) {
            System.out.println(obj.getOpen());
            System.out.println("sorry try search?");
            return;
        }

        if (obj.hasKey()) {
            obj.visableKey();
            obj.addVisibleKey(obj);
            System.out.println("Key found at " + obj.getName());
        } else {
            System.out.println("no key found at " + obj.getName());
        }

    }

    public void open(String objectName) {
        ObjectManager objectManager = currentRoom.getObjectManager();
        GameObject obj = objectManager.objectsbyName(objectName);
        if (obj == null ) {
            System.out.println("select something else");
            return;
        }
        if (!obj.getOpen()) {
            System.out.println("try search");
            return;
        }
        if (obj.hasKey()) {
            obj.visableKey();
            obj.addVisibleKey(obj);
            System.out.println("Key found in " + obj.getName());
        } else {
            System.out.println("Key not found in " + obj.getName());
        }
    }

    public void look() {
        ObjectManager objectManager = currentRoom.getObjectManager();
        System.out.print("You look arotund and find\n");
        for (GameObject obj : objectManager.getObjects()) {
            printUtil.typeWriter(obj.getName());
        }
    }

    public int incrementKey() {
        return keyCount++;
    }
    
    public void go(String roomName,ArrayList<Room> rooms) {
        for (Room room : rooms){
            if (room.getName().equalsIgnoreCase(roomName)) {
                currentRoom = room;
                System.out.println("you moved to " + currentRoom.getName());
                System.out.println(currentRoom.getDescription());
                return;
            }
        }
        System.out.println("Room not found " + roomName);
    }
    public void talk(){
        System.out.println("not implmented");
    }
}
