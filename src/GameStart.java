import Hero.Wizard;
import service.WizardService;

import java.util.Scanner;

public class GameStart {
    public static  void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("🎮 Welcome to the Game!");
        System.out.print("Enter your character name: ");
        String name = input.nextLine();

        System.out.println("Choose your class:");
        System.out.println("1. Wizard");

        int chose = input.nextInt();
        input.nextLine();

        switch (chose) {
            case 1:
                Wizard wizard = new Wizard(name);
                System.out.println("🎉 Character created: " + wizard.getCharacterName());
                WizardService wizardService = new WizardService();
                wizardService.wizardPlayStyle(wizard);
                break;

            default:
                System.out.println("Pick a right character");
                return;
        }
    }
}
