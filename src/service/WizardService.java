package service;

import Enemy.Goblin;
import model.Power;
import Hero.Wizard;

import java.util.Scanner;

public class WizardService {
    Scanner input = new Scanner(System.in);
    public void wizardPlayStyle(Wizard wizard) throws InterruptedException {
        // show all details about wizard
        // show stats
        // start battle
        // other leave for now
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
                    checkStats(wizard);
                    break;

                case 2:
                    BattleService battleService = new BattleService();
                    battleService.battle(wizard, goblin);
                    break;
                default:
                    System.out.println("Invalid Choice");
                    break;
            }
        }
    }

    // check wizard status
    public void checkStats(Wizard wizard) {
        System.out.println("\n🧙 Wizard Stats:");
        System.out.println("Name       : " + wizard.getCharacterName());
        System.out.println("Type       : " + wizard.getCharacterType());
        System.out.println("HP         : " + wizard.getCharacterHP());
        System.out.println("MP         : " + wizard.getCharacterMP());
        System.out.println("XP         : " + wizard.getCharacterXP());
        System.out.println("Powers     : ");
        for (Power power : wizard.getPowers()) {
            System.out.println("  • " + power.getPowerName() + " (DMG: " + power.getDamage() +
                    ", Mana Cost: " + power.getMagicCost() + ")");
        }
    }
}
