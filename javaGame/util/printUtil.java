package util;

public class printUtil {
    

    public static void typeWriter(String text) {
        int i;
        for (i = 0; i < text.length(); i++) {
            System.out.printf("%c", text.charAt(i));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("something went wrong");
            }
        }
        System.out.print("\n");
    }

    public static void frame(String text) {
        System.out.println("================================\n" +
                            text + "\n" +
                "================================");
    }

    public static enum GameMessages {
        LIVING_ROOM_DESC("You enter the living room, an abandoned space filled with dust and old memories."),
        KITCHEN_DESC(
                "The kitchen is eerily silent, with old utensils scattered about, hinting at meals long forgotten."),
        HALL_DESC("The hall is dimly lit, shadows dance across the walls as you step cautiously."),
        WASH_ROOM_DESC("The washroom is in disarray, a haunting reminder of neglect."),

        // Story-related messages
        LIVING_ROOM_STORY(
                "This was once a warm home, filled with laughter and joy. Now, it feels like a ghost of its former self."),
        KITCHEN_STORY("The kitchen holds secrets of the past. What happened here? Was it just the passing of time?"),

        // Player actions
        PLAYER_PICKUP_SUCCESS("You picked up the item."),
        PLAYER_PICKUP_FAIL("No item found to pick up."),
        PLAYER_SEARCH_SUCCESS("You found something interesting."),
        PLAYER_SEARCH_FAIL("You didn't find anything."),

        // Error messages
        ERROR_ROOM_NOT_FOUND("Room not found. Please check the name and try again."),
        ERROR_INVALID_COMMAND("Invalid command. Please use a valid action."),
        ERROR_ITEM_NOT_FOUND("Item not found in this room."),
        ERROR_SEARCH_FIRST("Please search the object before trying to open it."),

        // NPC interactions
        NPC_GHOST_HELP("The ghost offers you some advice on how to proceed."),
        NPC_GHOST_TALK("The ghost whispers secrets of the house."),
        HOST_HELP("The ghost offers you some advice: Use 'look' to see what's around you."),
        GHOST_MAP("The ghost shows you the map of the area."),
        GHOST_TALK_1("Boo! Need some help?"),
        GHOST_TALK_2("I really can guide you :)"),
        GHOST_TALK_3("Remember to search around you!"),
        GHOST_TALK_4("You can look around to find things."),

        // Hjälpmeddelande
        HELP_MESSAGE("""
                Here's some advice:
                1. Use 'look' to see what's around you.
                2. Type 'move <direction>' to navigate to a new room.
                3. Don't forget to 'talk' to me for more tips!
                4. Use 'go' to move to a diffrent room
                5. Use 'open' or 'search' to find keys from objects
                6. Use pickup to get the key you found
                """),

        // Game state messages
        WELCOME_MESSAGE("Welcome to the haunted house! Your adventure begins here."),
        GOODBYE_MESSAGE("Thank you for playing! Come back soon."),
        GAME_OVER_MESSAGE("You have met your end. Game over!"),
        LEVEL_UP_MESSAGE("Congratulations! You've leveled up!"),

        // Miscellaneous
        ACTION_NOT_ALLOWED("You cannot perform that action right now."),
        ACTION_SUCCESS("Action completed successfully.");

        private final String message;

        GameMessages(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}
