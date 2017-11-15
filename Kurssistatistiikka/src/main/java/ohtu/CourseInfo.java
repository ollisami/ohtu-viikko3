
package ohtu;

import java.util.List;

public class CourseInfo {
    private String id;
    private String name;
    private String term;
    private String url;
    private int curWeek;
    private boolean enabled;
    private int v;
    private int[] exercises;

    public String getId() {
        return id;
    }

    public void setId(String _id) {
        this.id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getWeek() {
        return curWeek;
    }

    public void setWeek(int week) {
        this.curWeek = week;
    }
    
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    
    public boolean getEnabled() {
        return enabled;
    }
    
    public void setV (int v) {
        this.v = v;
    }
    
    public int getV () {
        return this.v;
    }

    public int[] getExercises() {
        return exercises;
    }

    public void setExercises(int[] exercises) {
        this.exercises = exercises;
    }
    
    
}
