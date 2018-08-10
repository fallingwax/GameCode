package com.fallingwax.gamecode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Weapon {

    private String weaponType;
    private String rarity;
    private int damageInflicted;
    private int durability;
    private ArrayList rarityList;

    private void fillRarity(ArrayList<String> arrayList) {
        arrayList.add("Gold");
        arrayList.add("Silver");
        arrayList.add("Bronze");
        arrayList.add("Wood");
    }

    public Weapon(){
        rarityList = new ArrayList<>();
        weaponType = getWeaponType();
        fillRarity(rarityList);
        rarity = setRarity(rarityList);
        damageInflicted = getDamageInflicted();
        durability = getDurability();
    }

    public Weapon(String weaponType){
        rarityList = new ArrayList<>();
        this.weaponType = weaponType;
        fillRarity(rarityList);
        rarity = setRarity(rarityList);
        switch(rarity)
        {
            case "Wood": damageInflicted = 1; durability = 2;
               break;
            case "Bronze": damageInflicted = 3; durability = 4;
               break;
            case "Silver": damageInflicted = 5; durability = 6;
               break;
            default:damageInflicted = 7; durability = 10;
               break;
        }
    }

    public String getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(String weaponType) {
        this.weaponType = weaponType;
    }

    public String getRarity() {
        return rarity;
    }

    public String setRarity(ArrayList<String> arrayList) {
        Random rand = new Random();
        int n = rand.nextInt(4);
        return arrayList.get(n);

    }

    public int getDamageInflicted() {
        return damageInflicted;
    }

    public void setDamageInflicted(int damageInflicted) {
        this.damageInflicted = damageInflicted;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }
}
