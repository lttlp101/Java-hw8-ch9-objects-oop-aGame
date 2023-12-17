
//
// ------------------------------------------
/*
    @brief This Program:
    This Java program defines the class Player based on the following:
    • Player name
    • Player x position
    • Player y position
    • Player health value
    • Player move to new position (new x and new y positions)
    • Player takes damage (reduces the health)
    • Display the details (toString method)
    • Pick Up item
    • Drop item

 */
//
// ------------------------------------------
/*
    @note
    UML Diagram for Player class
    ----------------------
    Player
    ----------------------
    - xPosition: int
    - yPosition: int
    - health: int
    - name: String
    - inventory: ArrayList
    ----------------------
    + Player()
    + Player(xPosition: int, yPosition: int, health: int, name: String)
    ----------------------
    + setXPosition(xPosition: int): void
    + setYPosition(yPosition: int): void
    + setHealth(health: int): void
    + setName(name: String): void
    + getXPosition(): int
    + getYPosition(): int
    + getHealth(): int
    + getName(): String
    + getInventory(): ArrayList
    + move(x: int, y: int): void
    + takeDamage(damage: int): void
    + toString(): String
    + pickUp(Item item): void
    + drop(Item item): void
    ----------------------
 */
//
// ------------------------------------------
//
//
//


import java.util.ArrayList;
import java.util.List;


@SuppressWarnings("java:S106") // Disable the warning about System.out from SonarLint

// Define the Player class object
public class Player {
    // Attributes for Player class
    private int xPosition;
    private int yPosition;
    private int health;
    private String name;
    private final List<Item> inventory = new ArrayList<>();


    // Constructors for Player class

    // No-arg Constructor that sets initiate values for each attribute
    public Player() {
        xPosition = 0;
        yPosition = 0;
        health = 100;
        name = "Default Player";

    } // No-arg Constructor

    // Arg Constructor
    // that defines the X Position, the Y Position, the Health, the Name
    public Player(String name, int xPosition, int yPosition, int health) {
        // Define the Name, the X Position, the Y Position, the Health
        this.name = name;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.health = health;

    } // Arg Constructor


    // Methods for Player class

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

    // Get the Inventory
    ///getInventory - Get the Inventory
    ///@param - None
    ///return: the value [List] of the inventory
    public List<Item> getInventory() {
        return inventory;
    }


    // Other Methods

    // Move to New Position
    // Adjusts the xPosition and yPosition
    ///move - Update Player to New Position, by calling setXPosition and setYPosition methods
    ///@param - x [int] the x coordinate
    ///@param - y [int] the y coordinate
    ///return: None
    public void move(int x, int y) {
        setXPosition(x);
        setYPosition(y);
    } // move


    // Take Damage
    // Reduces the health
    ///takeDamage - Update to New Position, by calling setXPosition and setYPosition methods
    ///@param - damage [int] the integer number that reduce the health from
    ///return: None
    public void takeDamage(int damage) {
        setHealth((getHealth() - damage));
    } // takeDamage


    // Pick Up Item
    ///pickUp - Pick up item, by calling add method from inventory
    ///@param - Item object, passing the item object in
    ///return: None
    public void pickUp(Item item) {
        inventory.add(item);
        System.out.println("\n" + getName() + " has picked up " + item.getName() + " into inventory. ");
    } // pickUp


    // Drop Item
    ///drop - Drop item, by calling remove method from inventory
    ///@param - Item object, passing the item object in
    ///return: None
    public void drop(Item item) {
        inventory.remove(item);
        System.out.println("\n" + getName() + " has dropped " + item.getName() + " from inventory. ");
    } // drop


    // toString() Method
    // Display the object outputs
    ///toString - Display the formatted object data by overriding the toString() method
    ///@param - None
    ///return: the String type of the formatted object data
    @Override
    public String toString() {

        return "Player: \n Name: " + name +
                ", X: " + xPosition + ", Y: " + yPosition +
                ", Health: " + health +
                "\n";

    } // toString


}
