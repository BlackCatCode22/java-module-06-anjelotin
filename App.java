package angelo.zoo.com;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static angelo.zoo.com.Utilities.getUniqueName;

public class App {
    public static void main(String[] args) {
        // Load the animal names from the file
        String filePath = "animalNames.txt";
        AnimalNameListsWrapper animalLists = Utilities.createAnimalNameLists(filePath);
        Random random = new Random();

        // Initialize used names lists for each species
        List<String> usedHyenaNames = new ArrayList<>();
        List<String> usedLionNames = new ArrayList<>();
        List<String> usedTigerNames = new ArrayList<>();
        List<String> usedBearNames = new ArrayList<>();

        // This will hold the details of all animals for the report
        StringBuilder reportContent = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader("arrivingAnimals.txt"))) {
            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                String[] arrayOfStrPartsOnComma = line.split(", ");

                // Extracting animal attributes
                String aniAge = arrayOfStrPartsOnComma[0].split(" ")[0];
                int intAniAge = Integer.parseInt(aniAge);
                String aniSex = arrayOfStrPartsOnComma[0].split(" ")[3];
                String aniSpecies = arrayOfStrPartsOnComma[0].split(" ")[4];

                // Get weight, color, and origins
                int intAniWeight = Integer.parseInt(arrayOfStrPartsOnComma[3].replaceAll("[^\\d]", ""));
                String aniColor = arrayOfStrPartsOnComma[2];
                String origin1 = arrayOfStrPartsOnComma[4];
                String origin2 = arrayOfStrPartsOnComma[5];

                // Get a unique animal ID
                String animalID = Utilities.generateAnimalID(aniSpecies);

                // Calculate the animal birthdate
                String animalBirthSeason = arrayOfStrPartsOnComma[1].split(" ")[2];
                String animalBirthdate = Utilities.calcAnimalBirthDate(intAniAge, animalBirthSeason);

                // Create the animal object with a unique name
                Animal myNewAnimal = createAnimal(aniSpecies, aniSex, intAniAge, intAniWeight, animalID, animalLists, animalBirthdate, aniColor, origin1 + " " + origin2, usedHyenaNames, usedLionNames, usedTigerNames, usedBearNames);

                if (myNewAnimal != null) {
                    // Get the current date for arrival
                    String arrivalDate = LocalDate.now().toString();

                    // Print details of the new animal
                    String animalDetails = myNewAnimal.getAnimalID() + "; " + myNewAnimal.getAnimalName() + "; " + animalBirthdate + "; " + intAniAge + " years old; " + aniColor + " " + aniSex + "; " + intAniWeight + " pounds" + "; " + myNewAnimal.makeSound() + "; arrive date: " + arrivalDate;
                    System.out.println(animalDetails);

                    // Append animal details to the report content
                    reportContent.append(animalDetails).append("\n");
                }
            }

            // Write the report to a file
            writeZooPopulationReport(reportContent.toString());

        } catch (IOException e) {
            System.out.println("An error occurred while reading the animal data file: " + e.getMessage());
        }
    }

    private static Animal createAnimal(String species, String sex, int age, int weight, String id, AnimalNameListsWrapper animalLists, String animalBirthdate, String color, String origin, List<String> usedHyenaNames, List<String> usedLionNames, List<String> usedTigerNames, List<String> usedBearNames) {
        Random random = new Random();
        String animalName = null;

        switch (species.toLowerCase()) {
            case "hyena":
                animalName = getUniqueName(animalLists.getHyenaNameList(), usedHyenaNames, random);
                return new Hyena(sex, age, weight, id, animalName, animalBirthdate, color, origin);
            case "lion":
                animalName = getUniqueName(animalLists.getLionNameList(), usedLionNames, random);
                return new Lion(sex, age, weight, id, animalName, animalBirthdate, color, origin);
            case "tiger":
                animalName = getUniqueName(animalLists.getTigerNameList(), usedTigerNames, random);
                return new Tiger(sex, age, weight, id, animalName, animalBirthdate, color, origin);
            case "bear":
                animalName = getUniqueName(animalLists.getBearNameList(), usedBearNames, random);
                return new Bear(sex, age, weight, id, animalName, animalBirthdate, color, origin);
            default:
                System.out.println("\nUnknown species: " + species);
                return null;
        }
    }


    private static void writeZooPopulationReport(String reportContent) {
        String fileName = "zooPopulation.txt";
        File file = new File(fileName);

        // Create the file if it doesn't exist
        try {
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists. Appending data...");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while creating the file: " + e.getMessage());
        }

        // Write the report content to the file
        try (PrintWriter writer = new PrintWriter(new FileWriter(file, true))) { // Append mode
            writer.println("******* Zoo Population Report ********");

            // Split the report content into lines for processing
            String[] lines = reportContent.split("\n");
            String lastSpecies = "";

            for (String line : lines) {
                // Determine the species from the line
                String[] parts = line.split("; ");
                String speciesCode = parts[0].substring(0, 2); // Extract species code (e.g., "Hy" for Hyena)

                // Add a header if the species changes
                switch (speciesCode) {
                    case "Hy":
                        if (!lastSpecies.equals("Hy")) {
                            writer.println("\nHyena Habitat:");
                            lastSpecies = "Hy";
                        }
                        break;
                    case "Li":
                        if (!lastSpecies.equals("Li")) {
                            writer.println("\nLion Habitat:");
                            lastSpecies = "Li";
                        }
                        break;
                    case "Ti":
                        if (!lastSpecies.equals("Ti")) {
                            writer.println("\nTiger Habitat:");
                            lastSpecies = "Ti";
                        }
                        break;
                    case "Be":
                        if (!lastSpecies.equals("Be")) {
                            writer.println("\nBear Habitat:");
                            lastSpecies = "Be";
                        }
                        break;
                    default:
                        break; // Unknown species
                }

                // Write the animal details to the file
                writer.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while writing the zoo population report: " + e.getMessage());
        }
    }
}
