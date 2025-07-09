package Hero;

import model.Character;
import model.Power;

import java.util.ArrayList;

public class StoryHero extends Character {
    public StoryHero() {
        super("Animesh","sty001", 30, 50, 0, 0);
        this.characterType = "Human";

        this.powers = new ArrayList<>();
        powers.add(new Power("Steel Slash",5,5));
        powers.add(new Power("Focused Shot", 7, 8));
    }
}
