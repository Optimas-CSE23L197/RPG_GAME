package service;

import model.Character;
import model.Enemy;
import model.Goblin;
import model.Wizard;

public class BattleService {

    // battle b/w player and enemy
    public void battle(Wizard wizard, Goblin goblin) {

        // always player start attack first
        System.out.println();
        System.out.println("__________ Welcome To Battle Filed __________");
        for(int i = 3; i >= 0; i--) {
            System.out.println("Match Star in "+i);
            if (i == 0) {
                System.out.println("Fight");
            }
        }
        while(wizard.isAlive() && goblin.isAlive()) {
            System.out.println();
            System.out.println("__________");
            // player always start with base attack
            wizard.attackStyle(goblin);
            // player attack done

            // check goblin dead or not
            if (!goblin.isAlive()) {
                System.out.println("You Win......Congratulations!");
                wizard.gainXP(120);
                break;
            }

            // enemy always start with base attack
            goblin.attackStyle(wizard);
            // enemy attack done

            // check player stats
            if (!wizard.isAlive()) {
                System.out.println("You Lose......Congratulations!");
            }


        }
    }
}
