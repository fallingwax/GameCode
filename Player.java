package com.fallingwax.gamecode;

import java.util.ArrayList;

public class Player {

    private String playerName;
    private int hitPoints;
    private int magicPoints;
    private Weapon weapon;
    private ArrayList<Loot> inventory;
    private Enemy enemy;

    public Player() {
        playerName = getPlayerName();
        hitPoints = getHitPoints();
        magicPoints = getMagicPoints();
        weapon = getWeapon();
    }

    public Player(String playerName, Weapon weapon) {
        this.playerName = playerName;
        hitPoints = 20;
        magicPoints = 10;
        this.weapon = weapon;
        inventory = new ArrayList<>();
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void attackEnemy(Enemy enemy, Weapon weapon) {
        enemy.setHp(enemy.getHp() - weapon.getDamageInflicted());
        weapon.setDurability(weapon.getDurability() - 1);
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getMagicPoints() {
        return magicPoints;
    }

    public void setMagicPoints(int magicPoints) {
        this.magicPoints = magicPoints;
    }

    public ArrayList<Loot> getInventory() {
        return inventory;
    }

    public void pickUpLoot(Loot newLoot) {
        inventory.add(newLoot);
    }

    public Loot getLoot(String string) {
        for (Loot currentLoot : inventory) {
            if(currentLoot.getName().equals(string)) {
                return currentLoot;
            }
        }
        return null;
    }

    public boolean dropLoot(Loot loot) {
        if (this.inventory.contains(loot)) {
            inventory.remove(loot);
            return true;
        }
        return false;
    }


    public void usePotion(Loot loot) {
        if (loot.getName().equals("Red Potion")) {
            setHitPoints(getHitPoints() + 10);
            dropLoot(loot);
        } else if (loot.getName().equals("Blue Potion")) {
            setMagicPoints(getMagicPoints() + 10);
            dropLoot(loot);
        } else { //if Green Potion
            setMagicPoints(getMagicPoints() + 10);
            setHitPoints(getHitPoints() + 10);
            dropLoot(loot);
        }
    }

    public void printInventory(ArrayList<Loot> arrayList) {
        this.inventory = arrayList;

        for (Loot item : arrayList) {
            System.out.println(this.getPlayerName() + " has " + item.getValue() + " " + item.getName());
        }
    }

    public void printWeaponDetails() {
        Weapon weapon = this.getWeapon();
        System.out.print(this.getPlayerName() + " has a " + weapon.getRarity() + " " + weapon.getWeaponType());
        System.out.print(" with damage " + weapon.getDamageInflicted() + " and durability " + weapon.getDurability() + "\n");
    }
}
