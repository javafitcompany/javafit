import java.util.ArrayList;
import java.util.Scanner;

public class Workout {
    boolean done = false;
    private String date;
    private String focus;
    private ArrayList<String> exercises;
    private ArrayList<Integer> reps;

    public Workout(String date, Scanner scanner) {
        this.date = date;

        System.out.println("Enter today's workout focus (legs, arms, core, etc.):");
        this.focus = scanner.nextLine();

        this.exercises = new ArrayList<>();
        this.reps = new ArrayList<>();


        while (!done) {
            System.out.println("Enter an exercise you did:");
            String exercise = scanner.nextLine();
            exercises.add(exercise);

            System.out.println("Enter the number of reps for " + exercise + ":");
            int reps = scanner.nextInt();
            scanner.nextLine();
            this.reps.add(reps);

            System.out.println("Are you done adding exercises? (yes/no):");
            String response = scanner.nextLine();
            done = response.equalsIgnoreCase("yes");
        }
    }

    // Getters
    public String getDate() {
        return date;
    }

    public String getFocus() {
        return focus;
    }

    public ArrayList<String> getExercises() {
        return exercises;
    }

    public ArrayList<Integer> getReps() {
        return reps;
    }
}
