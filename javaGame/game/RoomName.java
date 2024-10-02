package game;

import util.printUtil;

public enum RoomName {
    HALL("Hall", printUtil.GameMessages.HALL_DESC.getMessage()),
    KITCHEN("Kitchen", printUtil.GameMessages.KITCHEN_DESC.getMessage()),
    LIVING_ROOM("Living Room", printUtil.GameMessages.LIVING_ROOM_DESC.getMessage()),
    WASH_ROOM("Wash room", printUtil.GameMessages.WASH_ROOM_DESC.getMessage());

    private final String displayName;
    private final String description;

    RoomName(String displayName, String description) {
        this.displayName = displayName;
        this.description = description;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getDescription() {
        return description;
    }
}
