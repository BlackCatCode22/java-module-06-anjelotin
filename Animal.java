package angelo.zoo.com;

public abstract class Animal {
    // Static variable to keep track of the number of animals created.
    static int numOfAnimals = 0;

    // Animal attributes
    private String sex; // Sex will be 'male' or 'female'
    private int age; // Age will be in years
    private int weight; // Weight will be in pounds
    private String animalID; // Unique ID for each animal
    private String animalName; // Names come from a text file
    private String animalBirthdate; // Animal birthdate
    private String animalColor; // Color of the animal
    private String animalOrigin; // Origin of the animal

    // Default constructor
    public Animal() {
        numOfAnimals++;
    }

    // Constructor accepting all fields as arguments
    public Animal(String sex, int age, int weight, String animalID, String animalName,
                  String animalBirthdate, String animalColor, String animalOrigin) {
        this.sex = sex;
        this.age = age;
        this.weight = weight;
        this.animalID = animalID;
        this.animalName = animalName;
        this.animalBirthdate = animalBirthdate;
        this.animalColor = animalColor;
        this.animalOrigin = animalOrigin;
        numOfAnimals++; // Increment animal count
    }

    // Abstract method to be implemented by subclasses
    public abstract String makeSound();

    // Getters and Setters
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getAnimalID() {
        return animalID;
    }

    public void setAnimalID(String animalID) {
        this.animalID = animalID;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public String getAnimalBirthdate() {
        return animalBirthdate;
    }

    public void setAnimalBirthdate(String animalBirthdate) {
        this.animalBirthdate = animalBirthdate;
    }

    public String getAnimalColor() {
        return animalColor;
    }

    public void setAnimalColor(String animalColor) {
        this.animalColor = animalColor;
    }

    public String getAnimalOrigin() {
        return animalOrigin;
    }

    public void setAnimalOrigin(String animalOrigin) {
        this.animalOrigin = animalOrigin;
    }
}
