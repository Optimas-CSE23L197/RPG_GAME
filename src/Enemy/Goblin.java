package Enemy;

import model.Enemy;
import model.Power;

import java.util.ArrayList;

public class Goblin extends Enemy {
    public Goblin() {
        super("Goblin", "gob001", 500, 200);
        this.powers = new ArrayList<>();
        powers.add(new Power("Scratch", 50, 100));
        powers.add(new Power("Bite", 100, 200));
    }

    public String getEnemyName() {
        return enemyName;
    }
}
