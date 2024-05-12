import java.util.Date;

/**
 * Schedule class to manage workout dates using an array.
 */
public class Schedule {
    private Date workoutDate;
    private Workout[] exercises;
    private int reps;

    public Schedule(Date workoutDate) {
        this.workoutDate = workoutDate;
        this.exercises = new Workout[10];
        this.reps = 0;
    }

    public void addWorkout(Workout workout) {
        if (reps < exercises.length) {
            exercises[reps++] = workout;
        } else {
            System.out.println("Maximum workouts reached for this schedule.");
        }
    }

    public Workout[] getWorkouts() {
        return exercises;
    }

    public Date getWorkoutDate() {
        return workoutDate;
    }

    public int getWorkoutCount() {
        return reps;
    }
}
