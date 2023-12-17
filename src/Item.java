
//
// ------------------------------------------
/*
    @brief This Program:
    This Java program defines the class Item based on the following:
    • Item name
    • Item x position
    • Item y position
    • Item weight value
    • Item pick up status (display a message if item was picked up)
    • Display the details (toString method)

 */
//
// ------------------------------------------
/*
    @note
    UML Diagram for Item class
    ----------------------
    Item
    ----------------------
    - xPosition: int
    - yPosition: int
    - weight: double
    - name: String
    - isPickedUp: boolean
    ----------------------
    + Item()
    + Item(xPosition: int, yPosition: int, weight: double, name: String)
    ----------------------
    + setXPosition(xPosition: int): void
    + setYPosition(yPosition: int): void
    + setWeight(weight: double): void
    + setName(name: String): void
    + setIsPickedUp(isPickedUp: boolean): void
    + getXPosition(): int
    + getYPosition(): int
    + getWeight(): double
    + getName(): String
    + getIsPickedUp(): boolean
    + pickUp(Player player): void
    + toString(): String
    ----------------------
 */
//
// ------------------------------------------
//
//
//


import java.text.DecimalFormat;

@SuppressWarnings("java:S106") // Disable the warning about System.out from SonarLint

// Define the Item class object
public class Item {
    // Attributes for Item class
    private int xPosition;
    private int yPosition;
    private double weight;
    private String name;
    private boolean isPickedUp;


    // Constructors for Item class

    // No-arg Constructor that sets initiate values for each attribute
    public Item() {
        xPosition = 0;
        yPosition = 0;
        weight = 0.0;
        name = "Default Item";
        isPickedUp = false;

    } // No-arg Constructor

    // Arg Constructor
    // that defines the X Position, the Y Position, the Weight, the Name
    public Item(String name, int xPosition, int yPosition, double weight) {
        // Define the Name, the X Position, the Y Position, the Weight
        this.name = name;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.weight = weight;

    } // Arg Constructor


    // Methods for Item class

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

    // Set the Weight
    ///setWeight - Set the Weight
    ///@param - weight [double] , double number for weight
    ///return: None
    public void setWeight(double weight) {
        this.weight = weight;
    }

    // Set the Name
    ///setName - Set the Name
    ///@param - name [String] , String type for name
    ///return: None
    public void setName(String name) {
        this.name = name;
    }

    // Set the isPickedUp
    ///setIsPickedUp - Set the isPickedUp
    ///@param - isPickedUp [boolean] , boolean value for isPickedUp
    ///return: None
    public void setIsPickedUp(boolean isPickedUp) {
        this.isPickedUp = isPickedUp;
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

    // Get the Weight
    ///getWeight - Get the Weight
    ///@param - None
    ///return: the value [double] of the weight
    public double getWeight() {
        return weight;
    }

    // Get the Name
    ///getName - Get the Name
    ///@param - None
    ///return: the value [String] of the name
    public String getName() {
        return name;
    }

    // Get the isPickedUp
    ///getIsPickedUp - Get the isPickedUp
    ///@param - None
    ///return: the value [boolean] of isPickedUp
    public boolean getIsPickedUp() {
        return isPickedUp;
    }


    // Other Methods

    // Pick Up Item
    // Prints a message indicating item has been picked up
    ///pickUp - First check the isPickedUp value
    ///       -  If the isPickedUp value is false then Pick Up the item
    ///       -  Pick up the item, passing in the Player object,
    ///       - then passing the Item object to Player object,
    ///       - so that Player object can add the Item into inventory
    ///       - Then change the boolean value setIsPickedUp() to True
    ///       - Then update the item coordinates using players
    ///@param - player, the Player object
    ///return: None
    public void pickUp(Player player) {

        // Get isPickedUp value
        // If the isPickedUp value is false then Pick Up the item
        if (!getIsPickedUp()) {
            // Passing the Item object to Player by call Player's pickup method
            player.pickUp(this);

            // Update the isPickedUp boolean value to true
            setIsPickedUp(true);

            // Update the item's coordinates by using Players
            setXPosition(player.getXPosition());
            setYPosition(player.getYPosition());

            // Print out a message that the item has been picked up
            System.out.println("The Item " + getName() + " has been picked up!\n");

        }

    } // pickUp


    // toString() Method
    // Display the object outputs
    ///toString - Display the formatted object data by overriding the toString() method
    ///@param - None
    ///return: the String type of the formatted object data
    @Override
    public String toString() {

        // Use DecimalFormat class to set up the 2 digits decimal point for double type value
        DecimalFormat decimalFormat = new DecimalFormat("0.00");

        return "Item: \n Name: " + name +
                ", X: " + xPosition + ", Y: " + yPosition +
                ", Weight: " + decimalFormat.format(weight) +
                "\n";

    } // toString


}
