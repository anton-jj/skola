package game;

import util.GameObject;

public class Kitchen extends Room {
    public Kitchen(){
        super(RoomName.KITCHEN);
    }

    @Override
    protected void createObjects(){
        getObjectManager().addObject(new GameObject("oven", false, true));
        getObjectManager().addObject(new GameObject("fridge", true, true));
        getObjectManager().addObject(new GameObject("bench", false, false));
    }
}
