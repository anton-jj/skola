package game;

public enum RoomName {
    HALL("Hall", "a dimly lit room"),
    KITCHEN("Kitchen", "A dusty abandoned kitchen"),
    LIVING_ROOM("Living Room", "an abandoned living room filled with dust"),
    WASH_ROOM("Wash room", "Sunking toilet");

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
