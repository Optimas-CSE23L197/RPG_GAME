package model;

import java.util.ArrayList;
import java.util.List;

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
    public abstract void attackStyle(Character character);

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
