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

            System.out.println("Whew " + userName + ".  That was a close one.");  //new code
            chooseDoor(); //new code

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

    //new code below
    public static void chooseDoor() {
        System.out.println("You come upon 2 doors. \nWhat will you do??? Choose [left / right]");
        String response = scanner.nextLine();
        if (response.equalsIgnoreCase("left")) {
            System.out.println("OH NO!  You have walked into dragon's lair.  However you notice that the dragon is still sleeping.");
            System.out.println("You slowly start to back out, but the cutest baby dragon has blocked your doorway and wants to play.");
            System.out.println("The excited baby dragon accidentally sneezes on  you and burns you to a crisp.  Your journey has ended.");
        } else if (response.equalsIgnoreCase("right")) {
            System.out.println("You have walked into the flower-atorium room.\n  It is filled with smells of the most beautiful flowers from around the world.");
            System.out.println("In the middle of the room, there are 3 flowers, each of which say, \"Smell Me\"");
            smellFlower();

        } else {
            System.out.println("Sorry, that choice is not understood.");
            chooseDoor();
        }
    }

    public static void smellFlower() {

        System.out.println("The three flowers are red, blue and yellow.  Of which of these do you wish to partake? \nBe aware that these may be the most beautiful aromas that you have ever smelled before");
        System.out.println("What will you do?? Choose [red / blue / yellow]");

        String flowerChoice = scanner.nextLine();

        if (flowerChoice.equalsIgnoreCase("red")) {
            System.out.printf("Ugh!!! You chose %s!  You should have known better and should have listened to your mother when she warned you to stay away from this type of flower.%n", flowerChoice);
            System.out.printf("The %s flower begins to constrict your airways.  First in your nostrils, then into the back of your throat and finally you feel the squeezing pressure that collapses your trachea.%n", flowerChoice);
            System.out.printf("You fall on the floor and slowly fade away with your last gaze being a single petal from that %s flower.  YOU'RE DEAD. %n", flowerChoice);
        } else if (flowerChoice.equalsIgnoreCase("blue")) {
            System.out.printf("Picking the %s flower was a good choice. " + userName + " You have added 1 point to your health.%n", flowerChoice);
        } else if (flowerChoice.equalsIgnoreCase("yellow")) {
            System.out.printf("Ah yes.  The %s flower was a GREAT choice " + userName + " You have doubled your health.%n", flowerChoice);
        } else {
            System.out.println("Sorry, that choice is not understood.");
            smellFlower();
        }
    }
}
