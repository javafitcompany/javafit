/**
 * User class to store user information, inheriting from Person.
 */
public class User extends Person {
    private double weight;
    private double height; // Need this for BMI calculation

    /**
     * User inherits name and age from the abstract Person class
     * @param name
     * @param age
     * @param weight
     * @param height
     */
    public User(String name, int age, double weight, double height) {
        super(name, age); // Calls the constructor of the Person class
        this.weight = weight;
        this.height = height;
    }

    /**
     * Method override for "role" from Person class
     */
    @Override
    public void displayRole() {
        System.out.println("Role: User");
    }

    /**
     * Getter and setter for weight and height
     */
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

    /**
     * Method to calculate BMI using pounds and inches
     * @return
     */
    public double calculateBMI() {
        return (weight * 703) / (height * height);
    }
}
