import java.util.Scanner;
import java.sql.Date; // sql.Date allows easy parsing from strings

/**
 * Main class to run JavaFit
 */
public class Main {
    private static Schedule[] schedules = new Schedule[5];
    private static int scheduleCount = 0;
    private static Scanner scanner = new Scanner(System.in);
    private static User user;

    public static void main(String[] args) {
        System.out.println("Welcome to the JavaFit Fitness Tracker");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        System.out.print("Enter your weight: ");
        double weight = scanner.nextDouble();
        scanner.nextLine();

        User user = new User(name, age, weight);

        boolean addingNewDate = true;
        do {
            System.out.print("Enter the date for the workout session (yyyy-mm-dd): ");
            Date date = Date.valueOf(scanner.nextLine());
            Schedule schedule = new Schedule(date);

            boolean addingWorkouts = true;
            while (addingWorkouts) {
                System.out.print("Enter the workout focus (core, chest, etc): ");
                String focus = scanner.nextLine();

                System.out.print("Enter exercise name: ");
                String exercise = scanner.nextLine();
                System.out.print("Enter the number of reps: ");
                int reps = scanner.nextInt();
                scanner.nextLine();

                schedule.addWorkout(new Workout(exercise, reps, focus));

                System.out.print("Are you finished adding exercises? (yes/no): ");
                addingWorkouts = !scanner.nextLine().trim().equalsIgnoreCase("yes");
            }

            if (scheduleCount < schedules.length) {
                schedules[scheduleCount++] = schedule;
            } else {
                System.out.println("Maximum number of schedules reached.");
                break;
            }

            System.out.print("Do you want to enter workouts for another date? (yes/no): ");
            addingNewDate = scanner.nextLine().trim().equalsIgnoreCase("yes");

        } while (addingNewDate);

        printReport();

        scanner.close();
    }

    private static void printReport() {
        System.out.println("\n" + user.getName() + "'s Latest Information:");
        System.out.println("Name: " + user.getName());
        System.out.println("Age: " + user.getAge());
        System.out.println("Weight: " + user.getWeight() + " lbs");

        System.out.println("\n" + user.getName() + "'s Workout Report:");
        for (int i = 0; i < scheduleCount; i++) {
            Schedule schedule = schedules[i];
            System.out.println("Date: " + schedule.getWorkoutDate());
            for (int j = 0; j < schedule.getWorkoutCount(); j++) {
                Workout workout = schedule.getWorkouts()[j];
                if (workout != null) {
                    System.out.println(" Focus: ") +workout.getFocus() + ", Exercise: " + workout.getExercises() + ", Reps: " + workout.getReps());
                }
            }
        }
    }
}