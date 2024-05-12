import java.util.Scanner;
import java.sql.Date; // sql.Date allows easy parsing from strings

/**
 * Main class to run JavaFit
 */
public class Main {
    private static Schedule[] schedules = new Schedule[5];
    private static int scheduleCount = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // Create users
        User user1 = new User(scanner);
        User user2 = new User(scanner);

        // Log workouts for user1
        Workout workout1 = new Workout("2024-04-01", scanner);
        Workout workout2 = new Workout("2024-04-01", scanner);

        // Print reports
        printReport(user1, workout1);
        printReport(user2, workout2);
    }

    public static void printReport(User user, Workout workout) {
        System.out.println("\n" + user.getName() + "'s Workout Report:");
        System.out.println("Date of: " + workout.getDate());
        System.out.println("Focus: " + workout.getFocus());
        System.out.println("Exercises:");

        for (int i = 0; i < workout.getExercises().size(); i++) {
            System.out.println(workout.getExercises().get(i) + ": " + workout.getReps().get(i) + " reps");
        }
    }
}
