/**
 * User class to store user information, inheriting from Person.
 */
public class User extends Person {
    private double weight;
    private double height; // Need this for BMI calculation

    public User(String name, int age, double weight, double height) {
        super(name, age); // Calls the constructor of the Person class
        this.weight = weight;
        this.height = height;
    }

    // Getter and setter for weight and height
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    // Method to calculate BMI using pounds and inches
    public double calculateBMI() {
        return (weight * 703) / (height * height);
    }
}
