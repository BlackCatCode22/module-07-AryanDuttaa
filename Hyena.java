package dennisMohle.myZoo.com;

import java.time.LocalDate;

public class Hyena extends Animal {

    private String laughSound; // Unique field for the Hyena class
    private static int numOfHyenas = 0; // Static field to count the number of Hyenas

    // Constructor that includes the laughSound parameter
    public Hyena(String name, String sex, String color, String id, String origin, int weight,
                 LocalDate birthDate, LocalDate arrivalDate, String laughSound) {
        super(name, sex, color, id, origin, weight, birthDate, arrivalDate);
        this.laughSound = laughSound; // Initialize the unique Hyena laugh sound
        numOfHyenas++; // Increment the count of Hyenas
        System.out.println("A new Hyena has been added to the zoo.");
    }

    // Default constructor
    public Hyena() {
        super(); // Call the parent's default constructor
        this.laughSound = "Haha"; // Default laugh sound
        numOfHyenas++; // Increment the count of Hyenas
        System.out.println("A new Hyena has been added to the zoo.");
    }

    // Getter for the laughSound
    public String getLaughSound() {
        return laughSound;
    }

    // Setter for the laughSound
    public void setLaughSound(String laughSound) {
        this.laughSound = laughSound;
    }

    // Method to simulate the Hyena's laugh
    public void laugh() {
        System.out.println(getName() + " says " + laughSound + "!");
    }

    // Public static getter for numOfHyenas
    public static int getNumOfHyenas() {
        return numOfHyenas;
    }
}
