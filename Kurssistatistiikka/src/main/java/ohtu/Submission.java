package ohtu;

public class Submission {
    private int week;
    private int hours;
    private int[] exercises;
    private int exercisesCount;

    public void setWeek(int week) {
        this.week = week;
    }

    public int getWeek() {
        return week;
    }
    
    public void setHours(int hours) {
        this.hours = hours;
    }
    
    public int getHours() {
        return hours;
    }
    
    public void setExercises(int[] exercises) {
        this.exercises = exercises;
    }
    
    public int[] getExercises() {
        return exercises;
    }
    
    public void setExercisesCount (int count) {
        this.exercisesCount = count;
    }
    
    public int getExercisesCount() {
        return exercisesCount;
    }

    @Override
    public String toString() {
        String p = "viikko "+week + ": tehtyjä tehtäviä yhteensä: " + exercises.length + " (maksimi " + exercisesCount + "), aikaa kului " + hours + " tuntia, tehdyt tehtävät: ";
        for (int i : exercises) {
            p = p + i + " ";
        }
        return p;
    }
    
}