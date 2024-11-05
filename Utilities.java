package angelo.zoo.com;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Utilities {

    static String getUniqueName(List<String> nameList, List<String> usedNames, Random random) {
        String name;
        do {
            name = nameList.get(random.nextInt(nameList.size()));
        } while (usedNames.contains(name));
        usedNames.add(name);
        return name;
    }

    // Count of each species
    private static int hyenaCount = 1;
    private static int lionCount = 1;
    private static int tigerCount = 1;
    private static int bearCount = 1;

    // Constants for species names
    private static final String HYENA = "hyena";
    private static final String LION = "lion";
    private static final String TIGER = "tiger";
    private static final String BEAR = "bear";

    public static String generateAnimalID(String species) {
        String prefix = "";
        int count = 0; // Local count for the current species

        switch (species.toLowerCase()) {
            case HYENA:
                count = hyenaCount++;
                prefix = "Hy";
                break;
            case LION:
                count = lionCount++;
                prefix = "Li";
                break;
            case TIGER:
                count = tigerCount++;
                prefix = "Ti";
                break;
            case BEAR:
                count = bearCount++;
                prefix = "Be";
                break;
            default:
                throw new IllegalArgumentException("Unknown species: " + species);
        }

        // Format the ID with leading zeros
        return prefix + String.format("%02d", count);
    }

    public static String calcAnimalBirthDate(int age, String theSeason) {
        // Create a Date object to represent the current date
        Date today = new Date();
        SimpleDateFormat formatterYear = new SimpleDateFormat("yyyy");
        int todaysYear = Integer.parseInt(formatterYear.format(today));
        int animalBirthYear = todaysYear - age;

        // Normalize the input season to lower case for case-insensitive comparison
        String season = theSeason.toLowerCase();
        String birthDate = animalBirthYear + "-01-01"; // Default case for anything else

        switch (season) {
            case "spring":
                birthDate = animalBirthYear + "-03-21";
                break;
            case "summer":
                birthDate = animalBirthYear + "-06-21";
                break;
            case "fall":
                birthDate = animalBirthYear + "-09-21";
                break;
            case "winter":
                birthDate = animalBirthYear + "-12-21";
                break;
        }

        return birthDate;
    }

    public static AnimalNameListsWrapper createAnimalNameLists(String filePath) {
        // Create ArrayLists for each species
        ArrayList<String> hyenaNameList = new ArrayList<>();
        ArrayList<String> lionNameList = new ArrayList<>();
        ArrayList<String> tigerNameList = new ArrayList<>();
        ArrayList<String> bearNameList = new ArrayList<>();

        // Try-with-resources to automatically close the reader
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            ArrayList<String> currentList = null;

            while ((line = reader.readLine()) != null) {
                line = line.trim();  // Trim any leading or trailing spaces

                // Check for the species names and assign the appropriate list
                switch (line) {
                    case "Hyena Names:":
                        currentList = hyenaNameList;
                        break;
                    case "Lion Names:":
                        currentList = lionNameList;
                        break;
                    case "Tiger Names:":
                        currentList = tigerNameList;
                        break;
                    case "Bear Names:":
                        currentList = bearNameList;
                        break;
                    default:
                        if (!line.isEmpty() && currentList != null) {
                            // Add names to the current list
                            String[] names = line.split(",\\s*");
                            for (String name : names) {
                                currentList.add(name);
                            }
                        }
                        break;
                }
            }
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }

        // Return the wrapper object containing all lists
        return new AnimalNameListsWrapper(hyenaNameList, lionNameList, tigerNameList, bearNameList);
    }
}
