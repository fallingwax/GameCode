package com.fallingwax.gamecode;

public class Bokoblin extends Enemy {

    public Bokoblin() {
        setName("Bokoblin");
        setHp(5);
    }

    @Override
    public void takeDamage(int damage) {
       setHp(getHp() - ( damage * 2));
    }


}
