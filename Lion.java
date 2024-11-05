package angelo.zoo.com;

public class Lion extends Animal {
    // Constructor for Lion
    public Lion(String sex, int age, int weight, String animalID, String animalName,
                String animalBirthdate, String animalColor, String animalOrigin) {
        super(sex, age, weight, animalID, animalName, animalBirthdate, animalColor, animalOrigin);
    }

    // Method to return the sound specific to Lion
    public String makeSound() {
        return "roar";
    }
}
