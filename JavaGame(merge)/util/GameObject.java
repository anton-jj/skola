package util;

public class GameObject {
   String name;
   boolean hasKey;
   boolean visableKey;

   public GameObject(String name, boolean hasKey) {
      this.name = name;
      this.hasKey = hasKey;
   }

   public String getName() {
      return name;
   }

   public boolean hasKey() {
      return hasKey;
   }

   public void visableKey() {
      this.visableKey = true;
   }

   public void removeKey() {
      this.hasKey = false;
   }

   @Override
   public String toString() {
      return name;
   }
}
