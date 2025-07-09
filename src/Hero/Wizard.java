package Hero;

import model.Character;
import model.Power;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Wizard extends Character {
    Scanner input = new Scanner(System.in);

    public Wizard(String characterName) {
        super(characterName, "wiz001", 1500, 2000, 0, 0);
        this.characterType = "Wizard";

        // default powers
        this.powers = new ArrayList<>();
        powers.add(new Power("Fire Ball", 200, 200));
        powers.add(new Power("Ice Spike",250, 250));
        powers.add(new Power("Arcane Blast", 500, 500));
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
