package model;

import java.util.ArrayList;
import java.util.List;

public abstract class Character {

    // all character details
    protected String characterName;
    protected String characterId;
    protected String characterType;

    // character stats
    protected int characterHP;
    protected int characterMP;
    protected int characterXP;
    protected int maxHP;
    protected int maxMP;
    protected List<Power> powers;

    // character actions
    public abstract void attackStyle(Enemy enemy);
    public abstract void gainXP(int xp);
    public abstract void levelUp();

    public Character(String characterName, String characterId, int characterHP, int characterMP, int characterXP) {
        this.characterName = characterName;
        this.characterId = characterId;
        this.characterHP = characterHP;
        this.characterMP = characterMP;
        this.characterXP = characterXP;
        this.maxHP = characterHP;
        this.maxMP = characterMP;
        this.powers = new ArrayList<>();
    }

    public String getCharacterName() {
        return characterName;
    }

    public void takeDamage(int damage) {
        characterHP -= Math.max(0, characterHP - damage);
    }

    public int getCharacterHP(int characterHP) {
        return characterHP;
    }

    public boolean isAlive() {
        return characterHP > 0;
    }

    public void fullHeal() {
        characterHP = maxHP;
        characterMP = maxMP;
    }
}
