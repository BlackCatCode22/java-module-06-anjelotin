package angelo.zoo.com;


public class Animal {
    // Create a static int that keep track of the number of animals created.
    static int numOfAnimals = 0;

    // Create a constructor for our new Animal objects
    public Animal() {
        numOfAnimals++;
    }


    // Create a constructor that will accept all fields as arguments.
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
    }


    // Create a few attributes (fields)
    // Sex will be 'male' or 'female'
    private String sex;
    // age will be in years
    private int age;
    // weight will be in pounds
    private int weight;
    // a unique ID for each animal
    private String animalID;
    // animal names come from a text file called animalsNames.txt
    private String animalName;
    // animal birthdate.
    private String animalBirthdate;
    // color of animal
    private String animalColor;
    // animal origin
    private String animalOrigin;
    // origin will be a string like: "from Friguia Park, Tunisia".

    // Create a getter and setters


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

    public String getAnimalID() {return animalID;}
    public void setAnimalID(String animalID) {this.animalID = animalID;}

    public String getAnimalName() {return animalName;}
    public void setAnimalName(String animalName) {this.animalName = animalName;}

    public String getAnimalBirthdate() {return animalBirthdate;}
    public void setAnimalBirthdate(String animalBirthdate) {this.animalBirthdate = animalBirthdate;}

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
