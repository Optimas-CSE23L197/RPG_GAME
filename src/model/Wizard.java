package model;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Wizard extends Character {
    Scanner input = new Scanner(System.in);

    public Wizard(String characterName) {
        super(characterName, "wiz001", 1500, 2000, 0);
        this.characterType = "Wizard";

        // default powers
        this.powers = new ArrayList<>();
        powers.add(new Power("Fire Ball", 200, 200));
        powers.add(new Power("Ice Spike",250, 250));
        powers.add(new Power("Arcane Blast", 500, 500));
    }

    @Override
    public void attackStyle(Enemy enemy) {
        if (powers.isEmpty()) {
            System.out.println("You don't have any power");
            return;
        }

        System.out.println("Choose your spell:");
        for(int i = 0; i < powers.size(); i++) {
            System.out.println((i+1)+". "+powers.get(i).getPowerName());
        }

        System.out.print("Enter choice (1-" + powers.size() + "): ");
        int choice = input.nextInt();
        input.nextLine();

        if (choice < 1 || choice > powers.size()) {
            System.out.println("Invalid choice");
            return;
        }

        Power chosePower = powers.get(choice - 1);


        if(characterMP >= chosePower.getMagicCost()) {
            characterMP -= chosePower.getMagicCost();
            enemy.enemyHP -= chosePower.getDamage();
            System.out.println(characterName + " casts " + chosePower.getPowerName() +
                    " on " + enemy.enemyName + " for " + chosePower.getDamage() + " damage!");
        } else {
            System.out.println(characterName + " doesn't have enough MP to cast " + chosePower.getPowerName());
        }
    }

    @Override
    public void gainXP(int xp) {
        this.characterXP += xp;
        System.out.println(characterName + " gained " + xp + " XP");
        if (characterXP > 100) {
            levelUp();
        }
    }

    @Override
    public void levelUp() {
        characterXP -= 100;
        maxHP += 50;
        maxMP += 100;
        characterHP = maxHP;
        characterMP = maxMP;
        System.out.println("🆙 " + characterName + " leveled up! New stats — HP: " +
                characterHP + ", MP: " + characterMP);
    }

    // Inside Character.java
    public String getCharacterName() {
        return characterName;
    }

    public int getCharacterHP() {
        return characterHP;
    }

    public int getCharacterMP() {
        return characterMP;
    }

    public int getCharacterXP() {
        return characterXP;
    }

    public List<Power> getPowers() {
        return powers;
    }

    public String getCharacterType() {
        return characterType;
    }
}
