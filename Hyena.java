package angelo.zoo.com;

public class Hyena extends angelo.zoo.com.Animal {
    // Create a static int that keep track of the number hyenas created.
    static int numOfHyenas = 0;

    // Create a constructor.
    public Hyena() {
        super();
        numOfHyenas++;
    }

}
