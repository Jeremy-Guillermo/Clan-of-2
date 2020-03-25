import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.lang.Math;

public class AdventureGame {
    public static Scanner scanner = new Scanner(System.in).useDelimiter("\n");
    static String userName;
    static int playerHealth;
    static int monsterHealth;
    static int playerAttack;
    static int monsterAttack;
    static int potions;
    static int runChance;
    static String difficulty;
    static String monster;
    static String response;
    static String fightConclude;
    static String flowerDecide;
    static String input;

    public static void main(String[] args) {
        startGame();
        if (input.equalsIgnoreCase("yes")) {
            startGame();
        } else if (input.equalsIgnoreCase("no")) {
            System.out.println("Thank you for playing!");
        }
    }

    public static String startGame() {
        System.out.println("Welcome to the woeful village of Walunia! Will you help save it? [Yes/No]");
      input = scanner.nextLine();

        if (input.equalsIgnoreCase("yes")) {

            System.out.println("\nThank you, most marvelous hero! What is your name?");
            userName = scanner.nextLine();
            System.out.printf("%n%s, thank you for taking up the call!%n", userName);
            System.out.println("Here is a potion to assist you~ The source of our troubles is the wizard's " +
                    "tower in the middle of this village. Please take care!\n\n\n");
            potions = 1;
            System.out.println("-You are taken to the door of the ominous tower, windowless and cutting into the sky-" +
                    " Do you expect an [easy] challenge or a [hard] one saving this town?");
            difficulty = scanner.nextLine();
            while(!difficulty.equalsIgnoreCase("easy") && !difficulty.equalsIgnoreCase("hard")) {
                System.out.println("I'm sorry, I do not understand, please re-enter your choice.");
                difficulty = scanner.nextLine();
            }
            if(difficulty.equalsIgnoreCase("easy")){
                playerHealth = 40;
            } else if(difficulty.equalsIgnoreCase("hard")){
                playerHealth = 25;
            }
            adventure();
            System.out.printf("%n%n%s's story has ended. Would you like to start a new adventure? " +
                    "[Yes/No]", userName);
            input = scanner.nextLine();
        } else {
            System.out.println("I see, good travels to you then...\n");
        }
        return input;
    }

    public static void adventure(){
        System.out.println("-The door of the ancient-looking tower creaks open, leading into a hall filled with " +
                "torchlight.\nCareful steps down the hall lead to two halls, [right] and [left]-\n");
        System.out.println("Which path will you choose?");
        response = scanner.nextLine();
        while(!response.equalsIgnoreCase("right") && !response.equalsIgnoreCase("left")){
            System.out.println("\nSorry, that isn't a direction you can go, please try again.");
            response = scanner.nextLine();
        }
        if(response.equalsIgnoreCase("right")){
            rightHall();
        } else if (response.equalsIgnoreCase("left")){
            leftHall();
        }
    }



    public static void leftHall(){
        System.out.println("\n-You decide to go left, cool stone beneath your boots.-\n");
        System.out.println("-The hall leads to a steel door and no other paths to take. You slowly push the door " +
                "open, not even the slightest creak... but a deep rumbling noise in the far side of the room as you " +
                "enter.-\n");
        monster = "baby dragon";
        System.out.printf("-A %s is snoozing on a pile of gold and jewels. There are also some potions interspersed " +
                "in the %s's bed.-%n", monster, monster);
        System.out.println("-The stairway upward is to the right, but more potions could useful.-");
        System.out.println("Will you try to take some [potions] or continue to [ascend]?");
        response = scanner.nextLine();
        while(!response.equalsIgnoreCase("potions") && !response.equalsIgnoreCase("ascend")){
            System.out.println("\nI don't understand, please put in the command again.");
            response = scanner.nextLine();
        }
        if(response.equalsIgnoreCase("potions")){
            System.out.println("\n-You approach the snoozing creature carefully, reaching for the potions.-");
            int success = ThreadLocalRandom.current().nextInt(1, 11);
            if (success <= 2){
                System.out.printf("%n-Just as you get close enough to grab some of the glass vials, the resting %s " +
                        "accidentally sneezes in its sleep, burning you to a crisp! %s's journey has ended.-",
                        monster, userName);
                return;
            } else if (success > 2 || success < 8){
                System.out.printf("-%nAs you almost grab some of the vials, the %s snorts, green eyes showing clear " +
                        "among its blue scales despite the darkness.-", monster);
                fight();
                if(fightConclude.equalsIgnoreCase("victory")){
                    System.out.println("\n-You manage to defeat the dragon, the creature churping as it falls onto " +
                            "the " +
                            "pile.-");
                    System.out.println("-You acquire three more potions and decide to continue onward and upward-");
                    potions = potions + 3;
                    ascend();
                } else if (fightConclude.equalsIgnoreCase("runaway")){
                    System.out.println("\n-You somehow manage to escape the angry baby dragon, running towards the " +
                            "stairs! The baby dragon doesn't give chase despite 'raring' angrily!-");
                    ascend();
                } else if (fightConclude.equalsIgnoreCase("defeat")){
                    System.out.printf("%n-The %s snarls, blowing fire, burning you to a crisp! %s's journey ends.-",
                            monster, userName);
                }
            } else if (success >=8){
                System.out.println("\n-The dragon continues to snore even as you clink three vials of potion, putting" +
                        " " +
                        "them into your sack.-");
                potions = potions + 3;
                System.out.println("-You then head up the stairs.-\n");
            }
        } else if (response.equalsIgnoreCase("ascend")){
            System.out.printf("\n-You decide the potions are too risky to attain, so you head to the stairs and start" +
                    " " +
                    "to go up.-\n");
            ascend();
        }
    }

    public static void rightHall(){
        System.out.println("\n-You choose to go right, a sweet scent in the air as you approach a wooden door.-\n");
        System.out.println("-As you enter, the sight of greenery is all around - beautiful colors and magnificent " +
                "trees. In the middle, there are glass bowls, each containing a flower.-");
        smellFlower();
        if(flowerDecide.equalsIgnoreCase("good")){
            leftHall();
        } else if (flowerDecide.equalsIgnoreCase("bad")){
            return;
        }
    }



    public static String fight() {
        System.out.printf("%n%n%nBeware, a %s approaches!%n", monster);
        if(difficulty.equalsIgnoreCase("easy")){
            monsterHealth = ThreadLocalRandom.current().nextInt(12, 25);
        } else if (difficulty.equalsIgnoreCase("hard")) {
            monsterHealth = (ThreadLocalRandom.current().nextInt(12, 25)) * 2;
        }
        while (playerHealth > 0 && monsterHealth > 0) {
            System.out.printf("%nYour current HP is %d and the %s's is %d%n", playerHealth, monster, monsterHealth);
            System.out.println("What will you do??? [Fight/Potion/Defend/Run]");
            response = scanner.nextLine();
            System.out.println("---------------------------");
            playerAttack = ThreadLocalRandom.current().nextInt(3, 9);
            monsterAttack = ThreadLocalRandom.current().nextInt(5, 14);
            if (response.equalsIgnoreCase("fight")) {
                monsterHealth = monsterHealth - playerAttack;
                System.out.printf("You do %d damage to the %s!%n", playerAttack, monster);
                playerHealth = playerHealth - monsterAttack;
                System.out.printf("The %s does %d damage to you!%n", monster, monsterAttack);
            } else if (response.equalsIgnoreCase("potion")) {
                if(potions <= 0){
                    System.out.println("You have no more potions to use!");
                } else {
                    playerHealth = playerHealth + 10;
                    System.out.println("You regain 10 HP!");
                    playerHealth = playerHealth - monsterAttack;
                    System.out.printf("The %s does %d damage to you!%n", monster, monsterAttack);
                    potions--;
                }
            } else if (response.equalsIgnoreCase("defend")){
                System.out.println("You decide to defend!\n");
                System.out.printf("The %s attacks (%d), but your defense cuts its fearsome assault in half. You " +
                        "take %d damage!%n", monster, monsterAttack, (monsterAttack/2));
                playerHealth = playerHealth - (monsterAttack/2);
            } else if(response.equalsIgnoreCase("run")){
                runChance = ThreadLocalRandom.current().nextInt(1, 11);
                System.out.println("You attempt to run away!\n");
                if(runChance <=7){
                    System.out.println("You failed to run! The monster has advantage!\n");
                    monsterAttack = Math.round((int) (monsterAttack * 1.5));
                    playerHealth = playerHealth - monsterAttack;
                    System.out.printf("The %s does %d damage!%n", monster, monsterAttack);
                } else {
                    System.out.println("You managed to escape! You live to fight on!");
                    fightConclude = "runaway";
                }
            } else {
                System.out.println("I don't understand, please put in the command again.");
                response = scanner.nextLine();
            }
        }

        if (monsterHealth <= 0) {
            System.out.println("Congratulations, you won!!!");
            fightConclude = "victory";
        } else if (playerHealth <= 0) {
            System.out.printf("Sorry, the %s has defeated you.", monster);
            fightConclude = "defeat";
        }
        return fightConclude;
    }


    public static void ascend(){
        System.out.println("-You walk up the steps, never seeming to end as you tromp and clop on the stonework" +
                        ".-\n\n\n");
        System.out.println("-Finally, you arrive at a single door inlaid with glowing words, warm to the touch, yet " +
                "not burning.-");
        System.out.println("-Putting your weight into it makes the thing open, fanciful chamber with silken " +
                "tapestries and decadent furniture grace the room.-");
        System.out.println("-There's also a door to the side, but your attention is drawn to the middle of the room, " +
                "bubbly cauldron and old man in star-spattered cloak hovering over it.-");
        System.out.printf("'I know why you're here, %s,' the old man says. 'But you shall fail. Come and meet your " +
                "doom!'", userName);
        monster = "old wizard";
        fight();
        if(fightConclude.equalsIgnoreCase("victory")){
            System.out.println("'NOOOOO!' the old wizard howls, flash of light and he is no more!!!");
            System.out.printf("-Congratulations, %s, you have won!", userName);
            reward();
            return;
        } else if(fightConclude.equalsIgnoreCase("defeat")){
            System.out.println("-The old wizard cackles as he curls his fingers together, then shoves them toward " +
                    "you," +
                    " blinding light covering you, searing you!-");
            System.out.printf("-Your body becomes nothingness in the light! %s's journey is over", userName);
            return;
        } else if(fightConclude.equalsIgnoreCase("runaway")){
            System.out.println("-You try to run away, heading towards the door... but it latches closed in front of " +
                    "you!-");
            System.out.printf("'No escape for you, %s,' the old wizard cackles as he curls his fingers together, " +
                            "shoving them towards you!", userName);
            System.out.printf("-A blinding, searing light surrounds you, turning your form into nothingness~ %s's " +
                    "journey is over", userName);
             return;
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

    public static String smellFlower() {

        System.out.println("The three flowers are red, blue and yellow.  Of which of these do you wish to partake? " +
                "\nBe aware that these may be the most beautiful aromas that you have ever smelled before~\n");
        System.out.println("What will you do?? Choose [red / blue / yellow]");

        String flowerChoice = scanner.nextLine();

        if (flowerChoice.equalsIgnoreCase("red")) {
            System.out.printf("Ugh!!! You chose %s!  You should have known better and should have listened to your mother when she warned you to stay away from this type of flower.%n", flowerChoice);
            System.out.printf("The %s flower begins to constrict your airways.  First in your nostrils, then into the back of your throat and finally you feel the squeezing pressure that collapses your trachea.%n", flowerChoice);
            System.out.printf("You fall on the floor and slowly fade away with your last gaze being a single petal from that %s flower.  YOU'RE DEAD. %n", flowerChoice);
            flowerDecide = "bad";
        } else if (flowerChoice.equalsIgnoreCase("blue")) {
            System.out.printf("Picking the %s flower was a good choice, %s. You have added 1 point to " +
                    "your health.%n", flowerChoice, userName);
            System.out.println("-You then go back the way you came~-");
            playerHealth = playerHealth + 1;
            flowerDecide = "good";
        } else if (flowerChoice.equalsIgnoreCase("yellow")) {
            System.out.printf("Ah yes.  The %s flower was a GREAT choice, %s. You have doubled your " +
                    "health.%n", flowerChoice, userName);
            System.out.println("-You then go back the way you came~-");
            playerHealth = playerHealth * 2;
            flowerDecide = "good";
        } else {
            System.out.println("Sorry, that choice is not understood.");
            smellFlower();
        }
        return flowerDecide;
    }



    public static void reward(){
        System.out.println("-You have scaled the tower and bested its odious owner!-\n");
        System.out.println(userName + ", you will now receive you reward for this perilous quest!");
        if (difficulty.equalsIgnoreCase("easy")){
            System.out.println("-The easy expectation gets you some gold and jewels and the thanks of the township~-");
            return;
        } else if(difficulty.equalsIgnoreCase("hard")){
            System.out.println("-Conquering the hard challenge gets you ownership of your own estate and a fine lover" +
                    " along with many treasures!");
            return;
        }
    }


}
