/**
 * Workout class encapsulated variables
 */

public class Workout {
    private String exerciseName;
    private int sets;
    private int reps;
    private String focus;

    /**
     * Workout constructor invocation
     * @param focus
     * @param exerciseName
     * @param sets
     * @param reps
     */
    public Workout(String focus, String exerciseName, int sets, int reps) {
        this.focus = focus;
        this.exerciseName = exerciseName;
        this.sets = sets;
        this.reps = reps;
    }

    /**
     * Overloaded method with defaults
     */
    public Workout() {
        this("General Focus", "General Exercise", 1, 10); // Default focus, exercise, 1 set, 10 reps
    }

    /**
     * Getters and Setters for Workout focus, exercise name, number of sets, and number of reps
     * @return
     */
    public String getFocus() {
        return focus;
    }

    public void setFocus(String focus) {
        this.focus = focus;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public int getSets() {
        return sets;
    }

    public void setSets() {
        this.sets = sets;
    }

    public int getReps() {
        return reps;
    }

    public void setReps() {
        this.reps = reps;
    }
}
