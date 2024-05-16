package dennisMohle.myZoo.com;

import java.time.LocalDate;

public class Lion extends Animal {

    private String roarSound; // Unique field for the Lion class
    private static int numOfLions = 0; // Static field to count the number of Lions

    // Constructor that includes the roarSound parameter
    public Lion(String name, String sex, String color, String id, String origin, int weight,
                LocalDate birthDate, LocalDate arrivalDate, String roarSound) {
        super(name, sex, color, id, origin, weight, birthDate, arrivalDate);
        this.roarSound = roarSound; // Initialize the unique Lion roar sound
        numOfLions++; // Increment the count of Lions
        System.out.println("A new Lion has been added to the zoo.");
    }

    // Default constructor
    public Lion() {
        super(); // Call the parent's default constructor
        this.roarSound = "Roar"; // Default roar sound
        numOfLions++; // Increment the count of Lions
        System.out.println("A new Lion has been added to the zoo.");
    }

    // Getter for the roarSound
    public String getRoarSound() {
        return roarSound;
    }

    // Setter for the roarSound
    public void setRoarSound(String roarSound) {
        this.roarSound = roarSound;
    }

    // Method to simulate the Lion's roar
    public void roar() {
        System.out.println(getName() + " says " + roarSound + "!");
    }

    // Public static getter for numOfLions
    public static int getNumOfLions() {
        return numOfLions;
    }
}
