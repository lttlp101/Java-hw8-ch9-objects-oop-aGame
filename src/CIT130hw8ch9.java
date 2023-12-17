
//
// ------------------------------------------
/*
    @brief This Program:
    This Java program include the following:
    This is the Main program
    To introduce object-oriented concepts through the development of simple classes
    for a fantasy game setting.
    You will create classes for Player, Item, and Enemy.
    You will also create a test utility console application
    to demonstrate the use of the constructed objects.

    This program performs the following:
    Prompt the user to input the attributes for a Player object.
    Prompt the user to input the attributes for an Item object.
    Prompt the user to input the attributes for an Enemy object.
    Print out the details of each constructed object using their toString method.

    This program performs the following:
    Play the take-turns game until player has no more health.
    Then, Player and Enemy take turn to make moves.
    Based on the distances, player can pick up item, enemy can attack player.
    Game Over / Game Stop until player has no more health.

 */
//
// ------------------------------------------
//
//
//


import java.util.Random;
import java.util.Scanner;

@SuppressWarnings("java:S106") // Disable the warning about System.out from SonarLint

public class CIT130hw8ch9 {

    // Define the scanner object to take input
    public static final Scanner inputs = new Scanner(System.in);
    // Create random numbers
    public static final Random randomNum = new Random();


    public static void main(String[] args) {

        // Display the assignment title
        System.out.println("\nAssignment 8    A Game -- Objects and Classes -- OOP\n");

        // Call newFantasyGame() method to start the game
        playFantasyGame();

    }  // main


    // Methods

    // Play Fantasy Game
    ///playFantasyGame - Prompt user input for creating Player, Item, Enemy objects,
    ///                - Call playGame() method to take turn to play the game
    ///@param - None
    ///return: None
    public static void playFantasyGame() {
        System.out.println("Let's play a game!\n");

        // Create Player, Item and Enemy Objects by Call getPlayerInfo(), getItemInfo() and getEnemyInfo() methods
        Player player = getPlayerInfo();
        Item item = getItemInfo();
        Enemy enemy = getEnemyInfo();

        // Initiate the flag for when the game stop
        // Get Health value from Player object
        // When player's health less than or equal zero, flag isGameOver True
        boolean isGameOver = player.getHealth() <= 0;

        System.out.println("----- Constructed Objects -----");
        // Print out the details of each constructed object using their toString() method
        System.out.println(player);
        System.out.println(item);
        System.out.println(enemy);

        // Call playGame() method, start the take-turns playing game
        // Passing in the Player, Item, and Enemy object and the variable boolean flag isGameOver
        playGame(player, item, enemy, isGameOver);

    } // playFantasyGame


    // Play the take-turns Game until player no more health
    ///playGame - Prompt user input for creating Player, Item, Enemy objects,
    ///                - Call playGame() method to take turn to play the game
    ///@param - player, the Player object
    ///@param - item, the Item object
    ///@param - enemy, the Enemy object
    ///@param - isGameOver [boolean] the isGameOver boolean flag
    ///return: None
    public static void playGame(Player player, Item item, Enemy enemy, boolean isGameOver) {
        System.out.println("\n-------------------------------");
        System.out.println("Now, Play!!");

        // While Loop
        // For when the isGameOver boolean flag is NOT true
        while (!isGameOver) {

            // Call playerMove() method, prompt user input for player's new positions(x, y)
            // Passing in the Player object
            playerMove(player);

            // Call checkDistances() method, calculate multiple distances
            // Passing in the Player, Enemy and Item object
            checkDistances(player, enemy, item);

            // If the Player's health is NOT zero
            // Then Call enemyMove() method, let the enemy moves
            if (player.getHealth() != 0) {
                // Call enemyMove() method, for enemy's new positions(x, y)
                // Passing in the Enemy object
                enemyMove(enemy);
            }

            // Update the boolean flag isGameOver by checking the player's health value
            // If player's health is less than or equal zero, then True, or remain False
            isGameOver = player.getHealth() <= 0;

        }

        // Display "Game OVer" message, end the game
        System.out.println("Game Over!");


    } // playGame


    // Get User Inputs to Create Player Object
    ///getPlayerIno - Prompt the user to input the attributes for a Player object
    ///@param - None
    ///return: the Player object with gathered info
    public static Player getPlayerInfo() {
        System.out.println("----- Player Creation -----");

        // Ask user for the name of the player
        System.out.println("Enter player name: ");
        String name = inputs.nextLine();
        // Capitalize the name by calling the capitalizeNames() method
        String newName = capitalizeNames(name);

        // Ask user for the x position for the player
        System.out.println("Enter xPosition for " + newName + ": ");
        int newXPosition = inputs.nextInt();

        // Ask user for the y position for the player
        System.out.println("Enter yPosition for " + newName + ": ");
        int newYPosition = inputs.nextInt();

        // Ask user for the health for the player
        System.out.println("Enter health for " + newName + ": ");
        int newHealth = inputs.nextInt();

        // Validate the health of the Player is over zero
        while (newHealth <= 0) {
            System.out.println("Invalid!! Enter again!");
            newHealth = inputs.nextInt();
        }

        // Skipping the line and create extra empty line
        inputs.nextLine();
        System.out.println("\n");

        // Return the Player object with the given inputs
        return new Player(newName, newXPosition, newYPosition, newHealth);

    }  // getPlayerInfo


    // Get User Inputs to Create Item Object
    ///getItemInfo - Prompt the user to input the attributes for an Item object
    ///@param - None
    ///return: the Item object with gathered info
    public static Item getItemInfo() {
        System.out.println("----- Item Creation -----");

        // Ask user for the name of the item
        System.out.println("Enter item name: ");
        String name = inputs.nextLine();
        // Capitalize the name by calling the capitalizeNames() method
        String newName = capitalizeNames(name);

        // Ask user for the x position for the item
        System.out.println("Enter xPosition for " + newName + ": ");
        int newXPosition = inputs.nextInt();

        // Ask user for the y position for the item
        System.out.println("Enter yPosition for " + newName + ": ");
        int newYPosition = inputs.nextInt();

        // Ask user for the weight for the item
        System.out.println("Enter weight for " + newName + ": ");
        double newWeight = inputs.nextDouble();

        // Validate the weight of the item is over zero
        while (newWeight <= 0.00000000001) {
            System.out.println("Invalid!! Enter again!");
            newWeight = inputs.nextInt();
        }

        // Skipping the line and create extra empty line
        inputs.nextLine();
        System.out.println("\n");

        // Return the Item object with the given inputs
        return new Item(newName, newXPosition, newYPosition, newWeight);

    }  // getItemInfo


    // Get User Inputs to Create Enemy Object
    ///getEnemyInfo - Prompt the user to input the attributes for an Enemy object
    ///@param - None
    ///return: the Enemy object with gathered info
    public static Enemy getEnemyInfo() {
        System.out.println("----- Enemy Creation -----");

        // Ask user for the name of the enemy
        System.out.println("Enter enemy name: ");
        String name = inputs.nextLine();
        // Capitalize the name by calling the capitalizeNames() method
        String newName = capitalizeNames(name);

        // Ask user for the x position for the enemy
        System.out.println("Enter xPosition for " + newName + ": ");
        int newXPosition = inputs.nextInt();

        // Ask user for the y position for the enemy
        System.out.println("Enter yPosition for " + newName + ": ");
        int newYPosition = inputs.nextInt();

        // Ask user for the health for the enemy
        System.out.println("Enter health for " + newName + ": ");
        int newHealth = inputs.nextInt();

        // Validate the health of the enemy is over zero
        while (newHealth <= 0) {
            System.out.println("Invalid!! Enter again!");
            newHealth = inputs.nextInt();
        }

        // Skipping the line and create extra empty line
        inputs.nextLine();
        System.out.println("\n");

        // Return the Enemy object with the given inputs
        return new Enemy(newName, newXPosition, newYPosition, newHealth);

    }  // getEnemyInfo


    // Extra Methods

    // Capitalize Names
    ///capitalizeNames - Capitalize the first letter of the name whatever is a single word or words with white space
    ///                - Check if the name is a single word or more
    ///                - If it's more than one word, use StringBuilder class to separate the words,
    ///                -     then build a new whole string with capitalize first letter of each word.
    ///                - If it's one word, then capitalize the first letter
    ///@param - names [String] a String value of name
    ///return: the new name String with capitalize first letter
    public static String capitalizeNames(String names) {

        // Check if names contains white space
        if (names.contains(" ")) {
            // Separate the words by the white space and put them into an array
            String[] nameArray = names.split(" ");
            // Use StringBuilder class
            StringBuilder stringBuilder = new StringBuilder();

            // Literal the word array and rebuild with capitalize first letter
            for (String s : nameArray) {
                stringBuilder.append(Character.toUpperCase(s.charAt(0)))
                        .append(s.substring(1)).append(" ");
            }
            return stringBuilder.toString().trim();
        }
        else {
            // Capitalize the first letter for the value of the name
            return names.substring(0, 1).toUpperCase() + names.substring(1);
        }

    } // capitalizeNames


    // Check Multiple Distances
    ///checkDistances - Check two distance: the item distance and the enemy distance
    ///                - Call getItemDistance() and getBattleDistance() methods
    ///                - If meet conditions then either pick up the item or go for a battle
    ///@param - player, the Player object
    ///@param - enemy, the Enemy object
    ///@param - item, the Item object
    ///return: None
    public static void checkDistances(Player player, Enemy enemy, Item item) {

        // Get the item distance between player and item
        // If the distance equal or less than zero, call pickUp method from Item object
        if (getItemDistance(player, item) <= 0.0) {
            item.pickUp(player);
        }

        // Get the battle distance between player and enemy
        // If the distance equal or less than 5, call attackPlayer method from Enemy object
        if (getBattleDistance(player, enemy) <= 5.0) {
            enemy.attackPlayer(player);
        }

    } // checkDistances


    // Get the battle distance between Player and Enemy
    ///getBattleDistance - Calculates the distance between Player and Enemy
    ///                  - using the Pythagorean Theorem
    ///@param - player, the Player object
    ///@param - enemy, the Enemy object
    ///@return - a double type number of the distance between Player and Enemy
    public static double getBattleDistance(Player player, Enemy enemy) {

        // Get the player's x and y coordinates
        int playerX = player.getXPosition();
        int playerY = player.getYPosition();

        // Get the enemy's x and y coordinates
        int enemyX = enemy.getXPosition();
        int enemyY = enemy.getYPosition();

        // Calculate the distance using formula of the Pythagorean Theorem
        double battleDistance = Math.pow((Math.pow((enemyX - playerX), 2) + Math.pow((enemyY - playerY), 2)), 0.5);

        // Display details
        System.out.println("\nthe Player position: (" + playerX + ", " + playerY + ") ");
        System.out.println("the Enemy position: (" + enemyX + ", " + enemyY + ") ");
        System.out.println("Enemy Distance is " + battleDistance);

        // Return the distance value
        return battleDistance;

    }  // getBattleDistance


    // Get the item distance between Player and Item
    ///getItemDistance - Calculates the distance between Player and Enemy
    ///                -  using the Pythagorean Theorem
    ///                -  Check if the item had been picked up
    ///@param - player, the Player object
    ///@param - item, the Item object
    ///@return - a double type number of the distance between Player and Item
    public static double getItemDistance(Player player, Item item) {

        // Initialize the itemDistance value
        double itemDistance = 0.0;

        // Check if the item had been picked up
        // If Not picked up, then calculate the distance
        if (!item.getIsPickedUp()) {
            // Get the player's x and y coordinates
            int playerX = player.getXPosition();
            int playerY = player.getYPosition();

            // Get the item's x and y coordinates
            int itemX = item.getXPosition();
            int itemY = item.getYPosition();

            // Calculate the distance using formula of the Pythagorean Theorem
            // Update the itemDistance value
            itemDistance = Math.pow((Math.pow((itemX - playerX), 2) + Math.pow((itemY - playerY), 2)), 0.5);

            // Display the details
            System.out.println("\nthe Player position: (" + playerX + ", " + playerY + ") ");
            System.out.println("the Item position: (" + itemX + ", " + itemY + ") ");
            System.out.println("Item Distance is " + itemDistance);
        }

        // Return the updated distance value
        return itemDistance;

    }  // getItemDistance


    // Player's Move
    ///playerMove - Prompt user input the player's new positions (x and y coordinates)
    ///           -  Then call player's move() method to update to new x and y coordinates
    ///@param - player, the Player object
    ///@return - None
    public static void playerMove(Player player) {

        System.out.println("\n" + player.getName() + ", Your Move!!");
        System.out.println("Please Enter the Position you would like to move to, ");
        System.out.println("Enter xPosition: ");
        int playerX = inputs.nextInt();
        System.out.println("Enter yPosition: ");
        int playerY = inputs.nextInt();

        // Call player's move() method to update x and y coordinates
        player.move(playerX, playerY);

    } // playerMove


    // Enemy's Move
    ///enemyMove - Update the enemy's new positions (x and y coordinates)
    ///          - Use Random class to create two random numbers, assign them for x and y values
    ///          - Then call enemy's move() method to update to new x and y coordinates
    ///@param - enemy, the enemy object
    ///@return - None
    public static void enemyMove(Enemy enemy) {

        int randomX = randomNum.nextInt(0, 11);
        int randomY = randomNum.nextInt(0, 11);

        // Call enemy's move() method to update new x and y coordinates using random numbers just created
        enemy.move(randomX, randomY);

        // Display a message showing enemy's new coordinates updated
        System.out.println("\nEnemy have moved!!\n");

    } // enemyMove


}