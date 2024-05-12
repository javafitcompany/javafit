public class Workout {
    private String exerciseName;
    private int sets;
    private int reps;
    private String focus;

    public Workout(String focus, String exerciseName, int sets, int reps) {
        this.focus = focus;
        this.exerciseName = exerciseName;
        this.sets = sets;
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
