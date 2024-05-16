package dennisMohle.myZoo.com;

import java.time.LocalDate;

public class Bear extends Animal {

    private String growlSound; // Unique field for the Bear class
    private static int numOfBears = 0; // Static field to count the number of Bears

    // Constructor that includes the growlSound parameter
    public Bear(String name, String sex, String color, String id, String origin, int weight,
                LocalDate birthDate, LocalDate arrivalDate, String growlSound) {
        super(name, sex, color, id, origin, weight, birthDate, arrivalDate);
        this.growlSound = growlSound; // Initialize the unique Bear growl sound
        numOfBears++; // Increment the count of Bears
        System.out.println("A new Bear has been added to the zoo.");
    }

    // Default constructor
    public Bear() {
        super(); // Call the parent's default constructor
        this.growlSound = "Grrr"; // Default growl sound
        numOfBears++; // Increment the count of Bears
        System.out.println("A new Bear has been added to the zoo.");
    }

    // Getter for the growlSound
    public String getGrowlSound() {
        return growlSound;
    }

    // Setter for the growlSound
    public void setGrowlSound(String growlSound) {
        this.growlSound = growlSound;
    }

    // Method to simulate the Bear's growl
    public void growl() {
        System.out.println(getName() + " says " + growlSound + "!");
    }

    // Public static getter for numOfBears
    public static int getNumOfBears() {
        return numOfBears;
    }
}
