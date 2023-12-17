
//
// ------------------------------------------
/*
    @brief This Program:
    This Java program defines the class Enemy based on the following:
    • Enemy name
    • Enemy x position
    • Enemy y position
    • Enemy health value
    • Enemy move to new position (new x and new y positions)
    • Enemy attacks Player (Player takes damage)
    • Display the details (toString method)

 */
//
// ------------------------------------------
/*
    @note
    UML Diagram for Enemy class
    ----------------------
    Enemy
    ----------------------
    - xPosition: int
    - yPosition: int
    - health: int
    - name: String
    ----------------------
    + Enemy()
    + Enemy(xPosition: int, yPosition: int, health: int, name: String)
    ----------------------
    + setXPosition(xPosition: int): void
    + setYPosition(yPosition: int): void
    + setHealth(health: int): void
    + setName(name: String): void
    + getXPosition(): int
    + getYPosition(): int
    + getHealth(): int
    + getName(): String
    + move(x: int, y: int): void
    + attackPlayer(Player player): void
    + toString(): String
    ----------------------
 */
//
// ------------------------------------------
//
//
//


@SuppressWarnings("java:S106") // Disable the warning about System.out from SonarLint

// Define the Enemy class object
public class Enemy {
    // Attributes for Enemy class
    private int xPosition;
    private int yPosition;
    private int health;
    private String name;


    // Constructors for Enemy class

    // No-arg Constructor that sets initiate values for each attribute
    public Enemy() {
        xPosition = 0;
        yPosition = 0;
        health = 100;
        name = "Default Enemy";

    } // No-arg Constructor

    // Arg Constructor
    // that defines the X Position, the Y Position, the Health, the Name
    public Enemy(String name, int xPosition, int yPosition, int health) {
        // Define the Name, the X Position, the Y Position, the Health
        this.name = name;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.health = health;

    } // Arg Constructor

    // Methods for Enemy class

    // Setters

    // Set the X Position
    ///setXPosition - Set the X Position
    ///@param - xPosition [int] , integer number for x
    ///return: None
    public void setXPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    // Set the Y Position
    ///setYPosition - Set the Y Position
    ///@param - yPosition [int] , integer number for y
    ///return: None
    public void setYPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    // Set the Health
    ///setHealth - Set the Health
    ///@param - health [int] , integer number for health
    ///return: None
    public void setHealth(int health) {
        this.health = health;
    }

    // Set the Name
    ///setName - Set the Name
    ///@param - name [String] , String type for name
    ///return: None
    public void setName(String name) {
        this.name = name;
    }


    // Getters

    // Get the X Position
    ///getXPosition - Get the X Position
    ///@param - None
    ///return: the value [int] of the x position
    public int getXPosition() {
        return xPosition;
    }

    // Get the Y Position
    ///getYPosition - Get the Y Position
    ///@param - None
    ///return: the value [int] of the y position
    public int getYPosition() {
        return yPosition;
    }

    // Get the Health
    ///getHealth - Get the Health
    ///@param - None
    ///return: the value [int] of the health
    public int getHealth() {
        return health;
    }

    // Get the Name
    ///getName - Get the Name
    ///@param - None
    ///return: the value [String] of the name
    public String getName() {
        return name;
    }


    // Other Methods

    // Move to New Position
    // Adjusts the xPosition and yPosition
    ///move - Update Enemy to New Position, by calling setXPosition and setYPosition methods
    ///@param - x [int] the x coordinate
    ///@param - y [int] the y coordinate
    ///return: None
    public void move(int x, int y) {
        setXPosition(x);
        setYPosition(y);
    } // move


    // Attack Player
    // Players takes damage
    // Passing in Player object, let player takes damage
    ///attackPlayer - After passed Player object, call Player's takeDamage() method,
    ///             -   to reduce player's health value
    ///@param - player, Player object
    ///return: None
    public void attackPlayer(Player player) {
        System.out.println("\nEnemy Attack!!");

        // Call player's takeDamage() method, pass a int number to reduce player's health value
        // (for shorten the game, pass a large number, so that game over shortly)
        player.takeDamage(50);

        // Display a message showing updated player's health value
        System.out.println("After Attacked, " + player.getName() + " has " + player.getHealth() + " health.\n");

    } // attackPlayer


    // toString() Method
    // Display the object outputs
    ///toString - Display the formatted object data by overriding the toString() method
    ///@param - None
    ///return: the String type of the formatted object data
    @Override
    public String toString() {

        return "Enemy: \n Name: " + name +
                ", X: " + xPosition + ", Y: " + yPosition +
                ", Health: " + health +
                "\n";

    } // toString


}
