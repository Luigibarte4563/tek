import java.util.*;

public class theBols1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Character data
        String[] characterNames = {"Warrior", "Mage", "Rogue", "Paladin"};
        int[] characterMinDamages = {8, 10, 9, 10};
        int[] characterMaxDamages = {21, 20, 24, 23};
        String[] characterSpecials = {"Power Strike", "Fireball", "Shadow Strike", "Holy Light"};

        // Get Player 1's name
        System.out.print("Enter your name, Player 1: ");
        String player1RealName = scanner.nextLine();

        // Difficulty progression
        int level = 1;
        boolean playAgain;

        do {
            // Determine difficulty using level
            String difficulty;
            if (level == 1) {
                difficulty = "Easy";
            } else if (level == 2) {
                difficulty = "Medium";
            } else if (level == 3) {
                difficulty = "Hard";
            } else if (level == 4) {
                difficulty = "Boss";
            } else {
                difficulty = "Final Boss";
            }

            // Display character options for Player 1
            System.out.println("\n" + player1RealName + ", choose your character!");
            for (int i = 0; i < characterNames.length; i++) {
                System.out.println((i + 1) + ". " + characterNames[i] +
                        " (Damage: " + characterMinDamages[i] + "-" + characterMaxDamages[i] +
                        ", Special: " + characterSpecials[i] + ")");
            }

            // Player 1 selects a character
            System.out.print(player1RealName + ", select your character (1-" + characterNames.length + "): ");
            int player1Choice = scanner.nextInt() - 1;
            String player1Name = characterNames[player1Choice];
            int player1MinDamage = characterMinDamages[player1Choice];
            int player1MaxDamage = characterMaxDamages[player1Choice];
            String player1Special = characterSpecials[player1Choice];
            int player1Health = 100;

            // CPU gets stronger every level
            String player2Name = "CPU";
            int player2Health = 90 + (level * 10); // Health increases with level
            int player2MinDamage = 10 + (level * 2); // Minimum damage increases with level
            int player2MaxDamage = 20 + (level * 3); // Maximum damage increases with level
            String player2Special = "Enraged Strike";

            System.out.println("\nDifficulty: " + difficulty);
            System.out.println(player2Name + " level " + level +
                    " (Health: " + player2Health +
                    ", Damage: " + player2MinDamage + "-" + player2MaxDamage +
                    ", Special: " + player2Special + ")");

            // Battle introduction
            System.out.println("\nThe battle begins! " + player1RealName + "'s " + player1Name + " vs. " + player2Name);

            int round = 1;
            int player1DefendTurns = 0;
            int player2DefendTurns = 0;
            int player1SpecialCooldown = 0;

            // Game loop
            while (player1Health > 0 && player2Health > 0) {
                System.out.println("\nRound " + round + " begins!");
                System.out.println("\n" + player1RealName + "'s " + player1Name + " Health: " + player1Health);
                System.out.println(player2Name + "'s Health: " + player2Health);

                // Player 1's turn
                System.out.println("------------------------------------");
                System.out.println(player1RealName + "'s turn! Choose your action:");
                System.out.println("1. Attack");
                System.out.println("2. Defend");
                System.out.println("3. Use Special Ability");
                System.out.print("Enter your action -------> ");
                int player1Action = scanner.nextInt();
                System.out.println("------------------------------------");

                if (player1Action == 1) {
                    int damage = random.nextInt(player1MaxDamage - player1MinDamage + 1) + player1MinDamage;
                    if (player2DefendTurns > 0) {
                        System.out.println(player2Name + " absorbs the attack while defending!");
                        player2DefendTurns--;
                    } else {
                        player2Health -= damage;
                        System.out.println(player1RealName + "'s " + player1Name + " attacks and deals " + damage + " damage! " + player2Name + "'s health is now " + player2Health);
                    }
                } else if (player1Action == 2) {
                    System.out.println(player1RealName + "'s " + player1Name + " defends, absorbing the next two attacks!");
                    player1DefendTurns = 2;
                } else if (player1Action == 3) {
                    if (player1SpecialCooldown == 0) {
                        System.out.println(player1RealName + "'s " + player1Name + " uses their special ability: " + player1Special);
                        int specialDamage = player1MaxDamage + 10;
                        if (player2DefendTurns > 0) {
                            System.out.println(player2Name + " absorbs the special attack while defending!");
                            player2DefendTurns--;
                        } else {
                            player2Health -= specialDamage;
                            System.out.println("It deals " + specialDamage + " damage! " + player2Name + "'s health is now " + player2Health);
                        }
                        player1SpecialCooldown = 5;
                    } else {
                        System.out.println(player1RealName + "'s " + player1Name + " cannot use special ability yet. Cooldown: " + player1SpecialCooldown + " rounds remaining.");
                    }
                }

                if (player2Health <= 0) {
                    System.out.println(player2Name + " has been defeated! " + player1RealName + " wins!");
                    level++;
                    break;
                }

                if (player1SpecialCooldown > 0) {
                    player1SpecialCooldown--;
                }

                // CPU's turn
                System.out.println("Player 2's turn!");
                int cpuAction = random.nextInt(3) + 1;

                int cpuDamage;
                if (cpuAction == 1) {
                    cpuDamage = random.nextInt(player2MaxDamage - player2MinDamage + 1) + player2MinDamage;
                    if (player1DefendTurns > 0) {
                        System.out.println(player1RealName + "'s " + player1Name + " absorbs the attack while defending!");
                        player1DefendTurns--;
                    } else {
                        player1Health -= cpuDamage;
                        System.out.println(player2Name + " attacks and deals " + cpuDamage + " damage! " + player1RealName + "'s " + player1Name + "'s health is now " + player1Health);
                    }
                } else if (cpuAction == 2) {
                    System.out.println(player2Name + " defends, absorbing the next two attacks!");
                    player2DefendTurns = 2;
                } else if (cpuAction == 3) {
                    System.out.println(player2Name + " uses their special ability: " + player2Special);
                    int specialDamage = player2MaxDamage + 10;
                    if (player1DefendTurns > 0) {
                        System.out.println(player1RealName + "'s " + player1Name + " absorbs the special attack while defending!");
                        player1DefendTurns--;
                    } else {
                        player1Health -= specialDamage;
                        System.out.println("It deals " + specialDamage + " damage! " + player1RealName + "'s " + player1Name + "'s health is now " + player1Health);
                    }
                }

                if (player1Health <= 0) {
                    System.out.println(player1RealName + "'s " + player1Name + " has been defeated! " + player2Name + " wins!");
                    break;
                }

                round++;
            }

            if (player1Health > 0) {
                if (level > 5) {
                    System.out.println("\nCongratulations, " + player1RealName + "! You have completed all levels!");
                    break;
                }
                System.out.print("\nDo you want to play the next level? (yes/no): ");
                playAgain = scanner.next().equalsIgnoreCase("yes");
            } else {
                playAgain = false;
            }

        } while (playAgain && level <= 5);

        if (level <= 5) {
            System.out.println("\nThe battle is over. The fate of Eldoria is sealed.");
        }
        scanner.close();
    }
}