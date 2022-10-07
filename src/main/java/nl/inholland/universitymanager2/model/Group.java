package nl.inholland.universitymanager2.model;

public class Group {
    private String name;
    private Teacher coach;

    public Group(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getCoach() {
        return coach;
    }

    public void setCoach(Teacher coach) {
        this.coach = coach;
    }

    @Override
    public String toString() {
        return name;
    }


}
