package player;

public  abstract class Npc {
    private String name;
    private String description;
    private int hp;
    private int damage;

    public Npc(String name, String description, int hp, int damage) {
        this.name = name;
        this.description = description;
        this.hp = hp;
        this.damage = damage;
    }
    public int getHp(){
        return hp;
    }

    public int getDamage(){
        return damage;
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public abstract void interact();
}