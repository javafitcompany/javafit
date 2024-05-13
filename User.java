/**
 * User class to store user information, inheriting from Person.
 */
public class User extends Person {
    private double weight;

    public User(String name, int age, double weight) {
        super(name, age); // Calls the constructor of the Person class
        this.weight = weight;
    }

    // Getter and setter for weight
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
