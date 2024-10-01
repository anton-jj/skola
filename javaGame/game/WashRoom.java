package game;

import util.GameObject;

public class WashRoom extends Room{
    public WashRoom(){
        super(RoomName.WASH_ROOM);
    }
    @Override
    protected void createObjects(){
        getObjectManager().addObject(new GameObject("taoilet", false, true));
        getObjectManager().addObject(new GameObject("mirror", false, false));
        getObjectManager().addObject(new GameObject("shower", false, false));
    }
}
