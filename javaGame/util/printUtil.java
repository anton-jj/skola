package util;

public class printUtil {
        public static void gameStart(){
                String text = """
                Welcome to the game
                you wake up in a dark room
                and have to start looking around to find a way out
                type 'help' to get commands
                """;
                typeWriter(text);
        }
        public static void typeWriter(String text){
        int i;
        for(i = 0; i < text.length(); i++){
            System.out.printf("%c", text.charAt(i));
            try {
                Thread.sleep(100);
            }catch(InterruptedException e){
            System.out.println("something wnt wrong");
        }
    }
    }
    public static String frame(String text){
        return 
            "=============================\n" +
                       text + "\n"+
            "=============================\n"
                ;
    }
}
