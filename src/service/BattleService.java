package service;

import Enemy.Goblin;
import model.Character;
import model.Enemy;

public class BattleService {

    // battle b/w player and enemy
    public void battle(Character hero, Enemy enemy) {

        // always player start attack first
        System.out.println();
        System.out.println("__________ Welcome To Battle Filed __________");
        for(int i = 3; i >= 0; i--) {
            System.out.println("Match Star in "+i);
            if (i == 0) {
                System.out.println("Fight");
            }
        }
        while(hero.isAlive() && enemy.isAlive()) {
            System.out.println();
            System.out.println("__________");
            // player always start with base attack
            hero.attackStyle(enemy);
            // player attack done

            // check goblin dead or not
            if (!enemy.isAlive()) {
                System.out.println("\uD83C\uDFC6 You Win......Congratulations!");
                hero.gainXP(enemy.getEnemyXP());
                enemy.resetEnemyStat();
                break;
            }

            // enemy always start with base attack
            enemy.attackStyle(hero);
            // enemy attack done

            // check player stats
            if (!hero.isAlive()) {
                System.out.println("\uD83D\uDC80 You Lose......Congratulations!");
            }
        }
    }
}
