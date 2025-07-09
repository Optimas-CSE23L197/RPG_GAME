package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Character {

    Scanner input = new Scanner(System.in);

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
    protected int characterLevel;
    protected List<Power> powers;

    // character actions
    public void attackStyle(Enemy enemy) {

        // if power array is empty
        if (powers.isEmpty()) {
            System.out.println("You don't have any power");
            return;
        }

        // iterate through all power and display them
        for(int i = 0; i <= powers.size() - 1; i++) {
            System.out.println((i+1)+". "+powers.get(i).getPowerName());
        }

        // display input option
        System.out.println("Enter Choice: (1-"+powers.size()+") :");

        // input variable
        int choice = input.nextInt();
        input.nextLine();

        // check validation for chosen power
        // if player chose 0 or > 3 print invalid
        if ( choice < 1 || choice > powers.size()) {
            System.out.println("Invalid Choice");
            return;
        }

        // chose power based on player input (-1) because array index start from 0 so player chose 1 then 1-1 = 0
        Power chosenPower = powers.get(choice - 1);

        // if character mp is greater than chosen attack mp cost
        if (characterMP >= chosenPower.getMagicCost()) {
            characterMP -= chosenPower.getMagicCost();
            enemy.enemyHP -= chosenPower.getDamage();
            System.out.println("\uD83D\uDCA5 "+characterName + " casts " + chosenPower.getPowerName() +
                    " on " + enemy.enemyName + " for " + chosenPower.getDamage() + " damage!");

            if (enemy.enemyHP <= 0) {
                System.out.println("\uD83D\uDC80 "+ enemy.enemyName + " dead");
            } else {
                System.out.println("❤ " + enemy.enemyName + " has " + enemy.enemyHP + " health remaining");
            }

        } else {
            System.out.println("⚠\uFE0F "+ characterName + " doesn't have enough MP to cast " + chosenPower.getPowerName());
        }
    };

    // gain xp after battle
    public void gainXP(int xp) {
        this.characterXP += xp;
        System.out.println("\uD83C\uDF1F "+ characterName + " gained " + xp + " XP");
        if(characterXP > 100) {
            levelUp();
        }
    };

    // level up after each battle
    public void levelUp() {
        characterXP -= 100;
        maxHP += 100;
        maxMP += 200;

        // assign reset character  health
        characterHP = maxHP;
        characterMP = maxMP;

        // increase level one
        this.characterLevel += 1;

        System.out.println("🆙 " + characterName + " leveled up! New stats — HP: " +
                characterHP + ", MP: " + characterMP);
        System.out.println("\uD83D\uDCC8 "+ "Current level "+ characterLevel);
    }

    public Character(String characterName, String characterId, int characterHP, int characterMP, int characterXP, int characterLevel) {
        this.characterName = characterName;
        this.characterId = characterId;
        this.characterHP = characterHP;
        this.characterMP = characterMP;
        this.characterXP = characterXP;
        this.maxHP = characterHP;
        this.maxMP = characterMP;
        this.characterLevel = characterLevel;
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
}
