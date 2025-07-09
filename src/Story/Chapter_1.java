package Story;

public class Chapter_1 {
    static void waitPrint(String text) throws InterruptedException {
        System.out.println(text);
        Thread.sleep(2000);
    }

    static void intro() throws InterruptedException {
        waitPrint("The village of Larkwood slumbered beneath the soft veil of early dawn. " +
                "Mist clung to the cobbled paths, and the rustling trees whispered secrets from the woods beyond. " +
                "In the heart of the village, a lone lantern flickered outside the old seer’s hut — " +
                "a quiet signal to those who dared dream of something greater.");

        waitPrint("Aerin, barely more than a youth but already known for their spirit, " +
                "approached the hut, heart pounding. The door creaked open before a knock was given.");

        waitPrint("Inside, the village seer, draped in layers of mossy robes, sat beside a hearth that burned with an unnatural hue. " +
                "Without a word, she reached into the fire and pulled forth a glowing ribbon, golden and pulsing like a heartbeat.");

        waitPrint("Outside, the wind shifted — something had entered the woods. The ribbon pulsed once, sensing danger.");

        waitPrint("“Prove your worth,” the seer murmured. “Face the creatures stirring beyond the trees: " +
                "a Goblin Scout who stalks in the shadows, and a Green Slime, ancient and hungry. " +
                "Return not just victorious, but transformed.”");

        waitPrint("Aerin nodded, the ribbon already binding itself to their wrist. " +
                "The flickering lantern outside now blazed — not with fire, but with promise.");

        waitPrint("The journey had begun.");
    }

    public static void main(String[] args) throws InterruptedException {
        intro();
        // firstHeroScene();
        // goblinFight();
        // slimeFight();
        // victory();
        // endScene();
    }
}
