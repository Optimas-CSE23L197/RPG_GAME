package service;

import Enemy.Goblin;
import model.Character;
import model.Power;

import java.util.Scanner;

public class HeroService {
    Scanner input = new Scanner(System.in);

    // logic for check stats for all hero
    // same logic for stats checking for all hero
    // I'm going to use database for this. when a player register then I'll generate a player id.
    // database schema:- player id, player game name, player character id, character level, player password
    // character database:- character hp,mp,current xp, inventory, friend
    public void heroPlayStyle(Character hero) {
        Goblin goblin = new Goblin();
        while (true) {
            System.out.println();
            System.out.println("---------- MENU ----------");
            System.out.println("1. Check Stats");
            System.out.println("2. Start Battle");
            System.out.println("3. Logout");

            System.out.println("Enter Your Choice");
            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    showStats(hero);
                    break;

                case 2:
                    BattleService battleService = new BattleService();
                    battleService.battle(hero, goblin);
                    break;
                default:
                    System.out.println("Invalid Choice");
                    break;
            }
        }
    }

    // show all power
    public void showStats(Character hero) {
        System.out.println("\n🧙 Hero Stats:");
        System.out.println("Name       : " + hero.getCharacterName());
        System.out.println("Type       : " + hero.getCharacterType());
        System.out.println("HP         : " + hero.getCharacterHP());
        System.out.println("MP         : " + hero.getCharacterMP());
        System.out.println("XP         : " + hero.getCharacterXP());
        System.out.println("Powers     : ");
        for (Power power : hero.getPowers()) {
            System.out.println("  • " + power.getPowerName() + " (DMG: " + power.getDamage() +
                    ", Mana Cost: " + power.getMagicCost() + ")");
        }
    }

    // start battle

    // battle details

    // check inventory
    // work later

    // add friend
    //work later

    // setting

    // logout
}
