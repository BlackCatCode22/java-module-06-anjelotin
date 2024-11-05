package angelo.zoo.com;

public class Bear extends Animal {
    // Constructor for Bear
    public Bear(String sex, int age, int weight, String animalID, String animalName,
                String animalBirthdate, String animalColor, String animalOrigin) {
        super(sex, age, weight, animalID, animalName, animalBirthdate, animalColor, animalOrigin);
    }

    // Method to return the sound specific to Bear

    public String makeSound() {
        return "growl";
    }
}
