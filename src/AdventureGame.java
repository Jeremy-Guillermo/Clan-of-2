import java.util.Scanner;
import java.util.Random;

public class AdventureGame {
    public static Scanner scanner = new Scanner(System.in).useDelimiter("\n");
    static String userName;
    static int playerHealth;
    static int monsterHealth;
    static int playerAttack;
    static int monsterAttack;
    static int potions;

    public static void main(String[] args) {
        if (startGame().equalsIgnoreCase("yes")) {
            startGame();
        } else {
            System.out.println("Thank you for playing!");
        }

    }

    public static String startGame() {
        System.out.println("Welcome to the woeful world of Walunia! Will you help save it? [y/N]");
        String input = scanner.nextLine();

        if (input.equalsIgnoreCase("y")) {
            System.out.println("Thank you, most marvelous hero! What is your name?");
            userName = scanner.nextLine();


            System.out.println(userName + ", thank you for taking up the call!");
            System.out.println("Here are three potions to assist you~");
            potions = 3;
            fight();
            System.out.println("Would you like to start a new adventure? [Yes/No]");
        } else {
            System.out.println("I see, good travels to you then...");
        }
        return scanner.nextLine();
    }

    public static void fight() {
        System.out.println("Beware, a beasty approaches!");
        playerHealth = 20;
        Random rand = new Random();
        monsterHealth = rand.nextInt((22 - 10) + 1) + 1;

        while (playerHealth > 0 && monsterHealth > 0) {
            System.out.printf("Your current HP is %d and the monster's is %d%n", playerHealth, monsterHealth);
            System.out.println("What will you do??? [Fight/Potion]");
            String response = scanner.nextLine();
            playerAttack = rand.nextInt((8 - 1) + 1) + 1;
            monsterAttack = rand.nextInt((10 - 1) + 1) + 1;
            if (response.equalsIgnoreCase("fight")) {
                monsterHealth = monsterHealth - playerAttack;
                System.out.printf("You do %d damage to the beast!%n", playerAttack);
                playerHealth = playerHealth - monsterAttack;
                System.out.printf("The creature does %d damage to you!%n", monsterAttack);
            } else if (response.equalsIgnoreCase("potion")) {
                playerHealth = playerHealth + 10;
                System.out.println("You regain 10 HP!");
                playerHealth = playerHealth - monsterAttack;
                System.out.printf("The creature does %d damage to you!%n", monsterAttack);
                potions--;
            } else {
                System.out.println("I don't understand, please put in the command again");
                response = scanner.nextLine();
            }
        }

        if (monsterHealth <= 0) {
            System.out.println("Congratulations, you won!!!");
        } else if (playerHealth <= 0) {
            System.out.println("Sorry, the beasty has defeated you.");
        }


    }
}
