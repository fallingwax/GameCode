package com.fallingwax.gamecode;

public class Enemy {

    private String name;
    private int hp;
    private Player player;

    public Enemy() {
        name = "";
        hp = 0;
    }

    public Enemy(String name) {
        this.name = name;
        hp = 10;
    }

    public void takeDamage(int damage) {
        hp = hp - damage;
    }

    public void attackPlayer(Player player, int damage) {
         player.setHitPoints(player.getHitPoints() - damage);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}
