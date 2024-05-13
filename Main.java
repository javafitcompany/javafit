import java.util.Scanner;
import java.sql.Date; // sql.Date is better for parsing from strings

/**
 * Main class to run JavaFit
 */
public class Main {
    /**
     * private variables for encapsulation
     */
    private static Schedule[] schedules = new Schedule[5];
    private static int scheduleCount = 0;
    private static Scanner scanner = new Scanner(System.in);
    private static User user;

    /**
     * main method that takes user input using Scanner
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Welcome to the JavaFit Fitness Tracker");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        System.out.print("Enter your height (in inches): ");
        double height = scanner.nextDouble();
        System.out.print("Enter your weight (in pounds): ");
        double weight = scanner.nextDouble();
        scanner.nextLine();

        /**
         * Constructor call for User
         */
        user = new User(name, age, weight, height);

        /**
         * Creates choice variable and do switch loop which gives user options for entering data, calculating BMI, or exiting
         */
        int choice;
        do {
            System.out.println("Choose an option:");
            System.out.println("1. Add Workout (Maximum of 5 days' worth)");
            System.out.println("2. Calculate BMI");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            /**
             * Switch loop for user to select entering workout data, calculating BMI, or exiting
             */
            switch (choice) {
                case 1:
                    enterWorkoutData();
                    printReport();
                    break;
                case 2:
                    printBMI();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            }
        } while (choice != 3);

        scanner.close();
    }

    /**
     * Method for entering workout data
     */
    private static void enterWorkoutData() {
        boolean addingNewDate = true;
        do {
            /**
             * Causes getWorkoutData to exit if max number of dates has been entered
             */
            if (scheduleCount >= schedules.length) {
                System.out.println("Maximum number of schedules reached. No further schedules can be added.");
                break; // Exit the loop if the array is full
            }
            /**
             * Schedule object created for data input
             */
            System.out.print("Enter the date for the workout session (yyyy-mm-dd): ");
            Date date = Date.valueOf(scanner.nextLine());
            Schedule schedule = new Schedule(date);
            /**
             * Loop to add workout data if the user chooses to do so
             */
            boolean addingWorkouts = true;
            while (addingWorkouts) {
                System.out.print("Enter the workout focus (core, chest, etc): ");
                String focus = scanner.nextLine();
                System.out.print("Enter exercise name: ");
                String exercise = scanner.nextLine();
                System.out.print("Enter the number of sets: ");
                int sets = scanner.nextInt();
                System.out.print("Enter the number of reps: ");
                int reps = scanner.nextInt();
                scanner.nextLine();

                schedule.addWorkout(new Workout(focus, exercise, sets, reps));

                System.out.print("Are you finished adding exercises? (yes/no): ");
                addingWorkouts = !scanner.nextLine().trim().equalsIgnoreCase("yes");
            }

            schedules[scheduleCount++] = schedule;

            /**
             * Ask user if they want to add workouts for another date if there's room left in the array
             */
            if (scheduleCount < schedules.length) {
                System.out.print("Do you want to enter workouts for another date? (yes/no): ");
                addingNewDate = scanner.nextLine().trim().equalsIgnoreCase("yes");
            } else {
                System.out.println("You have reached the maximum number of dates allowed.");
                addingNewDate = false; // Stop the loop because the data array is full
            }

        } while (addingNewDate);
    }

    /**
     * Method for printing the user's BMI calculation
     */
    private static void printBMI() {
        double bmi = user.calculateBMI();
        System.out.printf("%s's BMI: %.2f\n", user.getName(), bmi);
    }

    /**
     * Method for printing the workout report after the user is finished entering the data
     */
    private static void printReport() {
        System.out.println("\n" + user.getName() + "'s Latest Information:"); // first prints the user's personal info
        System.out.println("Name: " + user.getName());
        user.displayRole(); // prints the user's role from the abstract override in User class
        System.out.println("Age: " + user.getAge());
        System.out.println("Weight: " + user.getWeight() + " lbs");

        System.out.println("\n" + user.getName() + "'s Workout Report:"); // then prints the workout report
        for (int i = 0; i < scheduleCount; i++) { // loop that allows for date input until the date array is full
            Schedule schedule = schedules[i];
            System.out.println("Date: " + schedule.getWorkoutDate());
            for (int j = 0; j < schedule.getWorkoutCount(); j++) { // loop that allows for workout input until the workout array is full
                Workout workout = schedule.getWorkouts()[j];
                if (workout != null) { // as long as the workout input exists then a report will be printed
                    System.out.println(" Focus: " + workout.getFocus());
                    System.out.println(" Exercise: " + workout.getExerciseName() + " Sets: " + workout.getSets() + " Reps: " + workout.getReps());
                }
            }
        }
    }
}
