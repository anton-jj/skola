package util;

// skapar objekt met namn och nyckel eller ej
public class GameObject {
   String name;
   boolean hasKey;
   boolean visableKey;
   // konstruktor för att sätta namn och nyckelstatus
   public GameObject(String name, boolean hasKey) {
      this.name = name;
      this.hasKey = hasKey;
   }
   // getter returnerar namn på objekt
   public String getName() {
      return name;
   }
   // returnerar värdet på om objekt har nyckel eller inte
   public boolean hasKey() {
      return hasKey;
   }
   public void visableKey(){
      this.visableKey = true;
   }
   public void removeKey(){
      this.hasKey = false;
   }
   @Override
   public String toString(){
      return name;
   }
}
