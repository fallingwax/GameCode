package com.fallingwax.gamecode;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Player link = new Player("Link", new Weapon("Sword"));
        Enemy ganondorf = new Enemy("Ganondorf");
        System.out.println(link.getHitPoints());
        ganondorf.attackPlayer(link,5);
        link.attackEnemy(ganondorf, link.getWeapon());

        System.out.println("Link has " + link.getHitPoints() + "hp remaining");
        System.out.println("Ganondorf has " + ganondorf.getHp() + "hp remaining");

        link.pickUpLoot(new Loot("Red Potion", LootType.POTION, 10));
        link.pickUpLoot(new Loot("Gold", LootType.GOLD, 100));

        link.usePotion(link.getLoot("Red Potion"));
        System.out.println("Link has " + link.getHitPoints() + "hp remaining");

        link.printWeaponDetails();
        link.printInventory(link.getInventory());

    }
}
