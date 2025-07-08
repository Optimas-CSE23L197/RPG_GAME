package model;

import java.util.ArrayList;

public class Goblin extends Enemy {
    public Goblin() {
        super("Goblin", "gob001", 500, 200);
        this.powers = new ArrayList<>();
        powers.add(new Power("Scratch", 50, 100));
        powers.add(new Power("Bite", 100, 200));
    }

    @Override
    public void attackStyle(Character character) {
        if(powers.isEmpty()) {
            System.out.println(enemyName + "don't have any power");
            return;
        }

        Power power = powers.getFirst();

        if(enemyMP >= power.getMagicCost()) {
            enemyMP -= power.getMagicCost();
            character.takeDamage(power.getDamage());
            System.out.println(enemyName + " casts " + power.getPowerName() +
                    " on " + character.getCharacterName() + " for " + power.getDamage() + " damage!");
        } else {
            System.out.println(enemyName + " doesn't have enough MP to cast " + power.getPowerName());
        }
    }

    public String getEnemyName() {
        return enemyName;
    }
}
