package angelo.zoo.com;

public class Hyena extends Animal {
    // Constructor for Hyena
    public Hyena(String sex, int age, int weight, String animalID, String animalName,
                 String animalBirthdate, String animalColor, String animalOrigin) {
        super(sex, age, weight, animalID, animalName, animalBirthdate, animalColor, animalOrigin);
    }

    // Method to return the sound specific to Hyena
    public String makeSound() {
        return "laugh";
    }
}
