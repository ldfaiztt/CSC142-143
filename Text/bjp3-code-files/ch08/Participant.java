// A Participant object represents data about one person in a
// Body Mass Index (BMI) study program.

public class Participant {
    private String name;
    private double height;
    private double weight;

    // Constructs a participant with the given state.
    public Participant(String name, int height, int weight) {
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    // Returns the participant's body mass index (BMI).
    public double getBMI() {
        return weight / (height * height) * 703;
    }

    // Returns the participant's height.
    public double getHeight() {
        return height;
    }

    // Returns the participant's name.
    public String getName() {
        return name;
    }

    // Returns the participant's weight.
    public double getWeight() {
        return weight;
    }
}
