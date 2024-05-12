public class Workout {
    private String exerciseName;
    private int reps;
    private String focus;

    public Workout(String focus, String exerciseName, int reps) {
        this.focus = focus;
        this.exerciseName = exerciseName;
        this.reps = reps;
    }

    // Getters
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

    public int getReps() {
        return reps;
    }

    public void setReps() {
        this.reps = reps;
    }
}
