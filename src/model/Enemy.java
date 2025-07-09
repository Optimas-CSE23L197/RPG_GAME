package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Enemy {

    // all enemy details
    protected String enemyName;
    protected String enemyId;
    protected String enemyType;

    // enemy stats
    protected int enemyHP;
    protected int enemyMP;
    protected List<Power> powers;

    // enemy actions
    public void attackStyle(Character character) {
        // if power array is empty
        if (powers.isEmpty()) {
            System.out.println("You don't have any power");
            return;
        }

        Random random = new Random();
        int randomIndex = random.nextInt(powers.size());

        Power randomPower = powers.get(randomIndex);

        if (enemyMP >= randomPower.getMagicCost()) {
            enemyMP -= randomPower.getMagicCost();
            character.characterHP -= randomPower.getDamage();

            System.out.println("\uD83D\uDCA5 "+enemyName + " casts " + randomPower.getPowerName() +
                    " on " + character.characterName + " for " + randomPower.getDamage() + " damage!");

            if (character.characterHP <= 0) {
                System.out.println("\uD83D\uDC80 "+ character.characterName + " dead");
            } else {
                System.out.println("❤ " + character.characterName + " has " + character.characterHP + " health remaining");
            }

        } else {
            System.out.println("⚠\uFE0F "+ enemyName + " doesn't have enough MP to cast " + randomPower.getPowerName());
        }
    }

    public Enemy(String enemyName, String enemyId, int enemyHP, int enemyMP) {
        this.enemyName = enemyName;
        this.enemyHP = enemyHP;
        this.enemyMP = enemyMP;
        this.powers = new ArrayList<>();
    }

    public String getEnemyName() {
        return enemyName;
    }

    public boolean isAlive() {
        return enemyHP > 0;
    }

}
