package dennisMohle.myZoo.com;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;
import java.time.Month;
import java.io.BufferedWriter;
import java.io.FileWriter;

/* References:
 *   https://www.w3schools.com/java/java_user_input.asp
 *   https://www.w3schools.com/java/java_files.asp
 *   https://www.w3schools.com/java/java_arrays.asp
 *   https://www.w3schools.com/java/java_ref_string.asp
 *   https://www.geeksforgeeks.org/different-ways-for-integer-to-string-conversions-in-java/
 *   https://www.w3schools.com/java/java_date.asp
 *   https://www.quickprogrammingtips.com/java/how-to-calculate-age-from-date-of-birth-in-java.html
 */

/*
 * Sample Input from arrivingAnimals.txt:
 *   4 year old female hyena, born in spring, tan color, 70 pounds, from Friguia Park, Tunisia
 *
 * Sample Output line:
 *   Hy01; Kamari; 4 years old; birth date: 2018-03-21; tan color; female; 70 pounds; from Friguia Park, Tunisia;
 *   arrived: 2024-04-06
 */

public class DriverMain {
    static LocalDate calcBirthdate(int yearsOld, String birthSeason) {
        int birthYear = LocalDate.now().getYear() - yearsOld;
        LocalDate birthDate;

        switch (birthSeason.trim().toLowerCase()) {
            case "spring":
                birthDate = LocalDate.of(birthYear, Month.MARCH, 21);
                break;
            case "summer":
                birthDate = LocalDate.of(birthYear, Month.JUNE, 21);
                break;
            case "fall":
                birthDate = LocalDate.of(birthYear, Month.SEPTEMBER, 21);
                break;
            case "winter":
                birthDate = LocalDate.of(birthYear, Month.DECEMBER, 21);
                break;
            default:
                birthDate = LocalDate.of(birthYear, Month.JANUARY, 1);
                break;
        }
        return birthDate;
    }

    static String genUniqueID(String speciesName, int numOfSpecies) {
        String uniqueID;

        switch (speciesName) {
            case "hyena":
                uniqueID = "Hy" + String.format("%02d", numOfSpecies);
                break;
            case "lion":
                uniqueID = "Li" +  String.format("%02d", numOfSpecies);
                break;
            case "tiger":
                uniqueID = "Ti" +  String.format("%02d", numOfSpecies);
                break;
            case "bear":
                uniqueID = "Be" +  String.format("%02d", numOfSpecies);
                break;
            default:
                uniqueID = "error";
                break;
        }
        return uniqueID;
    }

    static int calculateAge(LocalDate birthDate, LocalDate currentDate) {
        if ((birthDate != null) && (currentDate != null)) {
            return Period.between(birthDate, currentDate).getYears();
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println("\n\n Welcome to the \"Zoo Keeper Challenge\" Program!\n\n");
        System.out.println("\n Number of animals is: " + Animal.getNumOfAnimals());

        // Example usage of calcBirthdate and displaying the age with Period
        LocalDate birthDate = calcBirthdate(4, "spring");
        LocalDate arrivalDate = LocalDate.now(); // Assuming today's date as arrival
        Period age = Period.between(birthDate, arrivalDate);

        System.out.println("Birthdate: " + birthDate);
        System.out.println("Arrival Date: " + arrivalDate);
        System.out.println("Age: " + age.getYears() + " years, " + age.getMonths() + " months, "
                + age.getDays() + " days");

        // ArrayList of Hyena names.
        ArrayList<String> hyenaNames = new ArrayList<>();
        // ArrayList of Lion names.
        ArrayList<String> lionNames = new ArrayList<>();
        // ArrayList of Tiger names.
        ArrayList<String> tigerNames = new ArrayList<>();
        // ArrayList of Bear names.
        ArrayList<String> bearNames = new ArrayList<>();

        // ArrayList to hold Hyena objects
        ArrayList<Hyena> hyenaList = new ArrayList<>();
        // ArrayList to hold Lion objects
        ArrayList<Lion> lionsList = new ArrayList<>();
        // ArrayList to hold Tiger objects
        ArrayList<Tiger> tigersList = new ArrayList<>();
        // ArrayList to hold Bear objects
        ArrayList<Bear> bearsList = new ArrayList<>();

        // Open animalNames.txt, parse it line by line, and fill the name arrayLists.
        String aFilePath = "C:/2024_Spring/midtermFiles/animalNames.txt";
        File aFile = new File(aFilePath);

        try (Scanner scanner = new Scanner(aFile)) {
            while (scanner.hasNextLine()) {
                String aLine = scanner.nextLine();

                System.out.println("\n aLine = " + aLine);

                if (aLine.contains("Hyena")) {
                    // Skip the next line because it is a blank line.
                    scanner.nextLine();

                    // Now... this line will have the hyena names!
                    // Split this line on a comma and a space and save the hyena names to a String array.
                    String[] myHyenaNamesArray = scanner.nextLine().split(", ");

                    // Output the names to see if this works.
                    for (String someName : myHyenaNamesArray)
                        System.out.println(someName);

                    // Use the same for loop to get the array into the proper ArrayList.
                    for (String someName : myHyenaNamesArray)
                        hyenaNames.add(someName);

                    // Pop the first hyena name off the list
                    String firstHyenaName = hyenaNames.remove(0);
                    System.out.println("First hyena name: " + firstHyenaName);

                    // and do this again and observe what is happening
                    firstHyenaName = hyenaNames.remove(0);
                    System.out.println("First hyena name: " + firstHyenaName);

                    // and one more time
                    firstHyenaName = hyenaNames.remove(0);
                    System.out.println("First hyena name: " + firstHyenaName);
                }
                // Get Lion names.
                if (aLine.contains("Lion")) {
                    // Skip the next line because it is a blank line.
                    scanner.nextLine();

                    // Now... this line will have the hyena names!
                    // Split this line on a comma and a space and save the hyena names to a String array.
                    String[] myLionNamesArray = scanner.nextLine().split(", ");

                    // Output the names to see if this works.
                    for (String someName : myLionNamesArray)
                        System.out.println(someName);

                    // Use the same for loop to get the array into the proper ArrayList.
                    for (String someName : myLionNamesArray)
                        lionNames.add(someName);

                    // Pop the first hyena name off the list
                    String firstLionName = lionNames.remove(0);
                    System.out.println("First lion name: " + firstLionName);

                    // and do this again and observe what is happening
                    firstLionName = lionNames.remove(0);
                    System.out.println("First lion name: " + firstLionName);

                    // and one more time
                    firstLionName = lionNames.remove(0);
                    System.out.println("First lion name: " + firstLionName);
                }
                // Get Tiger names.
                if (aLine.contains("Tiger")) {
                    // Skip the next line because it is a blank line.
                    scanner.nextLine();

                    // Now... this line will have the hyena names!
                    // Split this line on a comma and a space and save the hyena names to a String array.
                    String[] myTigerNamesArray = scanner.nextLine().split(", ");

                    // Output the names to see if this works.
                    for (String someName : myTigerNamesArray)
                        System.out.println(someName);

                    // Use the same for loop to get the array into the proper ArrayList.
                    for (String someName : myTigerNamesArray)
                        tigerNames.add(someName);

                    // Pop the first tiger name off the list
                    String firstTigerName = tigerNames.remove(0);
                    System.out.println("First tiger name: " + firstTigerName);

                    // and do this again and observe what is happening
                    firstTigerName = tigerNames.remove(0);
                    System.out.println("First lion name: " + firstTigerName);

                    // and one more time
                    firstTigerName = tigerNames.remove(0);
                    System.out.println("First lion name: " + firstTigerName);
                }
                // Get Bear names.
                if (aLine.contains("Bear")) {
                    // Skip the next line because it is a blank line.
                    scanner.nextLine();

                    // Now... this line will have the hyena names!
                    // Split this line on a comma and a space and save the hyena names to a String array.
                    String[] myBearNamesArray = scanner.nextLine().split(", ");

                    // Output the names to see if this works.
                    for (String someName : myBearNamesArray)
                        System.out.println(someName);

                    // Use the same for loop to get the array into the proper ArrayList.
                    for (String someName : myBearNamesArray)
                        bearNames.add(someName);

                    // Pop the first bear name off the list
                    String firstBearName = bearNames.remove(0);
                    System.out.println("First bear name: " + firstBearName);

                    // and do this again and observe what is happening
                    firstBearName = bearNames.remove(0);
                    System.out.println("First lion name: " + firstBearName);

                    // and one more time
                    firstBearName = bearNames.remove(0);
                    System.out.println("First lion name: " + firstBearName);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + aFilePath);
            e.printStackTrace();
        }

        // Open arrivingAnimals.txt, parse it line by line, and get all the variable (field) values you can.
        // A line from this text file looks like this:
        //   4 year old female hyena, born in spring, tan color, 70 pounds, from Friguia Park, Tunisia

        String filePath = "C:/2024_Spring/midtermFiles/arrivingAnimals.txt";
        File file = new File(filePath);

        String species = null;
        String animalSex = null;
        String animalColor = null;
        String animalOrigin = null;
        String animalSound = null;
        int ageInYears = 0;
        int animalWeight = 0;
        LocalDate animalBirthDate = null;
        LocalDate animalArrivalDate = null;

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                // Split the line by ", "
                // This gives us six elements in an array.
                String[] parts = line.split(", ");
                if (parts.length > 0) {

                    // The first part is age in years and species and looks like: "4 year old female hyena"
                    String ageAndSpecies = parts[0];
                    System.out.println("ageAndSpecies: " + ageAndSpecies);

                    // Split "4 year old female hyena" on a blank space and we have five words.
                    String[] ageSpeciesWords = ageAndSpecies.split(" ");

                    if (ageSpeciesWords.length >= 4) {

                        // The first word is age in years.
                        ageInYears = Integer.parseInt(ageSpeciesWords[0]);
                        // In the example, this should be a 4. Let's output to check this.
                        System.out.println("\n ageInYears is: " + ageInYears);

                        // We need the sex as well, which is the fourth word (array index 3). Output to check...
                        animalSex = ageSpeciesWords[3];
                        System.out.println("\n animalSex is: " + animalSex);

                        // Species is always the last word in the ageAndSpecies part (array index 4).
                        species = ageSpeciesWords[4];
                        System.out.println("\n ********* species is: " + species);
                    } else {
                        System.out.println("\n Error in data input file.\n");
                    }

                    // The second part is birth season and looks like: "born in spring"
                    String animalBirthSeason = parts[1];
                    System.out.println("animalBirthSeason: " + animalBirthSeason);

                    // Split "born in spring" on a blank space and we have three words. Let's get
                    //   these three words into a String array.
                    String[] animalBirthSeasonWords = animalBirthSeason.split(" ");
                    // Check to make sure we have at least three words.
                    String aniBirthSeason = null;
                    if (animalBirthSeasonWords.length >= 3) {
                        // The third word is season.
                        aniBirthSeason = animalBirthSeasonWords[2];
                        // Let's take a look at it!
                        System.out.println("\n aniBirthSeason is: " + aniBirthSeason);
                    }
                    // Get the animal birthday.
                    animalBirthDate = calcBirthdate(ageInYears, aniBirthSeason);
                    System.out.println("\n animalBirthDate is: " + animalBirthDate);

                    // The third part is color and looks like this: "tan color"
                    animalColor = parts[2];
                    System.out.println("animalColor: " + animalColor);

                    // The fourth part is weight and looks like this: "70 pounds"
                    String animalWeightStr = parts[3];
                    // Split it!
                    String[] theAnimalWeight = animalWeightStr.split(" ");
                    animalWeight = Integer.parseInt(theAnimalWeight[0]);
                    System.out.println("animalWeight: " + animalWeight);

                    // Combine the last two parts into origin.
                    animalOrigin = parts[4] + ", " + parts[5];
                    System.out.println("\n animalOrigin is: " + animalOrigin);

                    // Calculate a birthdate!
                    LocalDate theBirthDate = calcBirthdate(ageInYears, aniBirthSeason);
                    System.out.println("\n theBirthDate is: " + theBirthDate + "\n");
                } else {
                    System.out.println("\nError in data file: right after scanning a next line.\n");
                }
                // Now that we have all the information on the animal, let's create a species animal.
                // Hyena.
                if (species.equals("hyena")) {
                    // Create a new Hyena
                    // First, let's get a name for the new hyena.
                    String aHyenaName = hyenaNames.remove(0);
                    // Next, let's get an id.
                    int howManyHyenas = Hyena.getNumOfHyenas();
                    String animalID = genUniqueID("hyena", howManyHyenas+1);
                    // The hyena arrived now.
                    animalArrivalDate = LocalDate.now();
                    // Create this animal's unique sound.
                    String hyenaSound = null;
                    for (int i = 1; i <= howManyHyenas+1; i++) {
                        switch (i % 4) {
                            case 1:
                                hyenaSound = "haha";
                                break;
                            case 2:
                                hyenaSound = "hehe";
                                break;
                            case 3:
                                hyenaSound = "xaxa";
                                break;
                            case 0: // Note: 0 corresponds to a multiple of 4
                                hyenaSound = "chacha";
                                break;
                        }
                    }
                    // Create a new Hyena object.
                    Hyena newHyena = new Hyena(aHyenaName, animalSex, animalColor, animalID, animalOrigin, animalWeight,
                            animalBirthDate, animalArrivalDate,hyenaSound);
                    // Add the new hyena to the arrayList.
                    hyenaList.add(newHyena);
                }
                // Lion.
                if (species.equals("lion")) {
                    // Create a new Lion
                    // First, let's get a name for the new lion.
                    String aLionName = lionNames.remove(0);
                    // Next, let's get an id.
                    int howManyLions = Lion.getNumOfLions();
                    String animalID = genUniqueID("lion", howManyLions+1);
                    // The hyena arrived now.
                    animalArrivalDate = LocalDate.now();
                    // Create this animal's unique sound.
                    String lionSound = null;
                    for (int i = 1; i <= howManyLions+1; i++) {
                        switch (i % 4) {
                            case 1:
                                lionSound = "Roarrr";
                                break;
                            case 2:
                                lionSound = "RoooarRoooar";
                                break;
                            case 3:
                                lionSound = "Roaaar!";
                                break;
                            case 0: // Note: 0 corresponds to a multiple of 4
                                lionSound = "Rrrrroarrrr";
                                break;
                        }
                    }
                    // Create a new Lion object.
                    Lion newLion = new Lion(aLionName, animalSex, animalColor, animalID, animalOrigin, animalWeight,
                            animalBirthDate, animalArrivalDate,lionSound);
                    // Add the new lion to the arrayList.
                    lionsList.add(newLion);
                }
                // Tiger.
                if (species.equals("tiger")) {
                    // Create a new Tiger
                    // First, let's get a name for the new tiger.
                    String aTigerName = tigerNames.remove(0);
                    // Next, let's get an id.
                    int howManyTigers = Tiger.getNumOfTigers();
                    String animalID = genUniqueID("tiger", howManyTigers+1);
                    // The hyena arrived now.
                    animalArrivalDate = LocalDate.now();
                    // Create this animal's unique sound.
                    String tigerSound = null;
                    for (int i = 1; i <= howManyTigers+1; i++) {
                        switch (i % 4) {
                            case 1:
                                tigerSound = "Mew";
                                break;
                            case 2:
                                tigerSound = "Meowww";
                                break;
                            case 3:
                                tigerSound = "Mrrrrew!";
                                break;
                            case 0: // Note: 0 corresponds to a multiple of 4
                                tigerSound = "Mew! Mew!";
                                break;
                        }
                    }
                    // Create a new Tiger object.
                    Tiger newTiger = new Tiger(aTigerName, animalSex, animalColor, animalID, animalOrigin, animalWeight,
                            animalBirthDate, animalArrivalDate,tigerSound);
                    // Add the new lion to the arrayList.
                    tigersList.add(newTiger);
                }
                // Bear.
                if (species.equals("bear")) {
                    // Create a new Bear
                    // First, let's get a name for the new bear.
                    String aBearName = bearNames.remove(0);
                    // Next, let's get an id.
                    int howManyBears = Bear.getNumOfBears();
                    String animalID = genUniqueID("bear", howManyBears+1);
                    // The hyena arrived now.
                    animalArrivalDate = LocalDate.now();
                    // Create this animal's unique sound.
                    String bearSound = null;
                    for (int i = 1; i <= howManyBears+1; i++) {
                        switch (i % 4) {
                            case 1:
                                bearSound = "Grrrrr";
                                break;
                            case 2:
                                bearSound = "RrrrRrrr";
                                break;
                            case 3:
                                bearSound = "Gruff!";
                                break;
                            case 0: // Note: 0 corresponds to a multiple of 4
                                bearSound = "Rrruff";
                                break;
                        }
                    }
                    // Create a new Bear object.
                    Bear newBear = new Bear(aBearName, animalSex, animalColor, animalID, animalOrigin, animalWeight,
                            animalBirthDate, animalArrivalDate,bearSound);
                    // Add the new lion to the arrayList.
                    bearsList.add(newBear);
                }


            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
            e.printStackTrace();
        }
        // Output the list of Hyenas.
        // The Hyenas are:
        for (Hyena hyena : hyenaList) {
            // get age in years
            int animalAgeInYears = calculateAge(hyena.getBirthDate(), hyena.getArrivalDate());
            System.out.println(hyena.getId() + "; " +  animalAgeInYears + " years old; " + hyena.getName()
                    + "; birthDate: " + hyena.getBirthDate() + "; " + hyena.getColor() + "; " + hyena.getSex()
                    + "; " + hyena.getWeight() + " pounds" + "; " + "laugh: " + hyena.getLaughSound()
                    + "; from: " + hyena.getOrigin() + "; " + "arrived: " + hyena.getArrivalDate());
        }
        System.out.println("\n");
        // Output the list of Lions.
        // The Lions are:
        for (Lion lion : lionsList) {
            // get age in years
            int animalAgeInYears = calculateAge(lion.getBirthDate(), lion.getArrivalDate());
            System.out.println(lion.getId() + "; " +  animalAgeInYears + " years old; " + lion.getName()
                    + "; birthDate: " + lion.getBirthDate() + "; " + lion.getColor() + "; " + lion.getSex()
                    + "; " + lion.getWeight() + " pounds" + "; " + "roar: " + lion.getRoarSound()
                    + "; from: " + lion.getOrigin() + "; " + "arrived: " + lion.getArrivalDate());
        }
        System.out.println("\n");
        // Output the list of Tigers.
        // The Tigers are:
        for (Tiger tiger : tigersList) {
            // get age in years
            int animalAgeInYears = calculateAge(tiger.getBirthDate(), tiger.getArrivalDate());
            System.out.println(tiger.getId() + "; " +  animalAgeInYears + " years old; " + tiger.getName()
                    + "; birthDate: " + tiger.getBirthDate() + "; " + tiger.getColor() + "; " + tiger.getSex()
                    + "; " + tiger.getWeight() + " pounds" + "; " + "mew: " + tiger.getMewSound()
                    + "; from: " + tiger.getOrigin() + "; " + "arrived: " + tiger.getArrivalDate());
        }
        System.out.println("\n");
        // Output the list of Bears.
        // The Bears are:
        for (Bear bear : bearsList) {
            // get age in years
            int animalAgeInYears = calculateAge(bear.getBirthDate(), bear.getArrivalDate());
            System.out.println(bear.getId() + "; " +  animalAgeInYears + " years old; " + bear.getName()
                    + "; birthDate: " + bear.getBirthDate() + "; " + bear.getColor() + "; " + bear.getSex()
                    + "; " + bear.getWeight() + " pounds" + "; " + "mew: " + bear.getGrowlSound()
                    + "; from: " + bear.getOrigin() + "; " + "arrived: " + bear.getArrivalDate());
        }
        System.out.println("\n");



        // Write to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(
                "C:/2024_Spring/midtermFiles/zooPopulation.txt", true))) {
            writer.write("\n ******* Zoo Population and Habitat Assignment Report ******** \n\n");
            writer.write("Hyena Habitat:\n\n");
            for (Hyena hyena : hyenaList) {
                // Age in years is required for the report.
                int animalAgeInYears = calculateAge(hyena.getBirthDate(), LocalDate.now());
                writer.write(hyena.getId() + "; " + animalAgeInYears + " years old; " + hyena.getName()
                        + "; birthDate: " + hyena.getBirthDate() + "; " + hyena.getColor() + "; " + hyena.getSex()
                        + "; " + hyena.getWeight() + " pounds" + "; " + "laugh: " + hyena.getLaughSound()
                        + "; from: " + hyena.getOrigin() + "; " + "arrived: " + hyena.getArrivalDate() + "\n");
            }
            writer.write("\nLion Habitat:\n\n");
            for (Lion lion : lionsList) {
                // Age in years is required for the report.
                int animalAgeInYears = calculateAge(lion.getBirthDate(), LocalDate.now());
                writer.write(lion.getId() + "; " + animalAgeInYears + " years old; " + lion.getName()
                        + "; birthDate: " + lion.getBirthDate() + "; " + lion.getColor() + "; " + lion.getSex()
                        + "; " + lion.getWeight() + " pounds" + "; " + "roar: " + lion.getRoarSound()
                        + "; from: " + lion.getOrigin() + "; " + "arrived: " + lion.getArrivalDate() + "\n");
            }
            writer.write("\nTiger Habitat:\n\n");
            for (Tiger tiger : tigersList) {
                // Age in years is required for the report.
                int animalAgeInYears = calculateAge(tiger.getBirthDate(), LocalDate.now());
                writer.write(tiger.getId() + "; " + animalAgeInYears + " years old; " + tiger.getName()
                        + "; birthDate: " + tiger.getBirthDate() + "; " + tiger.getColor() + "; " + tiger.getSex()
                        + "; " + tiger.getWeight() + " pounds" + "; " + "roar: " + tiger.getMewSound()
                        + "; from: " + tiger.getOrigin() + "; " + "arrived: " + tiger.getArrivalDate() + "\n");
            }
            writer.write("\nBear Habitat:\n\n");
            for (Bear bear : bearsList) {
                // Age in years is required for the report.
                int animalAgeInYears = calculateAge(bear.getBirthDate(), LocalDate.now());
                writer.write(bear.getId() + "; " + animalAgeInYears + " years old; " + bear.getName()
                        + "; birthDate: " + bear.getBirthDate() + "; " + bear.getColor() + "; " + bear.getSex()
                        + "; " + bear.getWeight() + " pounds" + "; " + "roar: " + bear.getGrowlSound()
                        + "; from: " + bear.getOrigin() + "; " + "arrived: " + bear.getArrivalDate() + "\n");
            }




            // Flush the writer to ensure all outputs are written out.
            writer.flush();
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }



    }
}
