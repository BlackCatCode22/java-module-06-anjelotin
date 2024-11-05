package angelo.zoo.com;

public class Tiger extends Animal {
    // Constructor for Tiger
    public Tiger(String sex, int age, int weight, String animalID, String animalName,
                 String animalBirthdate, String animalColor, String animalOrigin) {
        super(sex, age, weight, animalID, animalName, animalBirthdate, animalColor, animalOrigin);
    }

    // Method to return the sound specific to Tiger

    public String makeSound() {
        return "roar";
    }
}
