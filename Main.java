package com.fallingwax.gamecode;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Player link = new Player("Link", new Weapon("Sword"));
        Enemy ganondorf = new Enemy("Ganondorf");
        Bokoblin bokoblin = new Bokoblin();

        Scanner s = new Scanner(System.in);

        System.out.println("A Bokoblin has attacked Link");
        System.out.println("Press A to Attack or B to defend");
        String choice = s.nextLine();

        if (choice.equals("A")) {
            if (link.getWeapon().getDamageInflicted() >= bokoblin.getHp()) {
                link.attackEnemy(bokoblin, link.getWeapon());
                if (bokoblin.getHp() <= 0) {
                    bokoblin.setHp(0);
                    System.out.println(bokoblin.getName() + " is dead.");
                }
            } else {
                link.attackEnemy(bokoblin, link.getWeapon());
                System.out.println(bokoblin.getName() + " has " + bokoblin.getHp() + "hp remaining");
            }
        } else {
            bokoblin.attackPlayer(link, 1);
            System.out.println("Bokoblin attacked Link");
            System.out.println("Link has " + link.getHitPoints() + "hp remaining");
        }


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
