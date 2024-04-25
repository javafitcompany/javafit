import java.util.Scanner;

public class User {
    private String name;
    private int age;
    private double weight;

    public User(Scanner scanner) {

        System.out.println("The following messages will ask you for information about you: ");
        System.out.println("Enter your name:");
        this.name = scanner.nextLine();
        System.out.println("Enter your age:");
        this.age = scanner.nextInt();
        System.out.println("Enter your weight:");
        this.weight = scanner.nextDouble();
        scanner.nextLine();     }

    // Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }
}
