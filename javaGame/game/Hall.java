package game;

import util.GameObject;
public class Hall extends Room {
    public Hall(){
        super(RoomName.HALL);
    }
    @Override
    protected void createObjects(){
        getObjectManager().addObject(new GameObject("carpet", false, false));
        getObjectManager().addObject(new GameObject("paintin", true, false));
        getObjectManager().addObject(new GameObject("chest", false, true));
    }
}
