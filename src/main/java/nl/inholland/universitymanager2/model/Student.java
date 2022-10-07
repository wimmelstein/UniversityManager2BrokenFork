package nl.inholland.universitymanager2.model;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
    private Group group;
    private List<Grade> grades = new ArrayList<>();

    public Student(String firstName, String lastName, String email, Group group) {
        super(firstName, lastName, email);
        this.group = group;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public List<Grade> getGrades() {
        return grades;
    }
}
