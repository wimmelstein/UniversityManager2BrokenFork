package nl.inholland.universitymanager2.data;

import nl.inholland.universitymanager2.annotations.WimMadeThis;
import nl.inholland.universitymanager2.model.Grade;
import nl.inholland.universitymanager2.model.Group;
import nl.inholland.universitymanager2.model.Student;
import nl.inholland.universitymanager2.model.Teacher;

import java.util.ArrayList;
import java.util.List;

public class Database {

    private List<Student> students = new ArrayList<>();
    private List<Group> groups = new ArrayList<>();
    private List<Teacher> teachers = new ArrayList<>();

    public List<Student> getStudents() {
        return students;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public Database() {
        // teachers
        Teacher wim = new Teacher("Wim", "Wiltenburg", "willem.wiltenburg@inholland.nl", 500000);
        Teacher niels = new Teacher("Niels", "van der Zwet", "niels.vanDerZwet@inholland.nl", 400000);
        teachers.addAll(List.of(wim, niels));


        // groups
        Group inf2a = new Group("INF2A");
        inf2a.setCoach(niels);
        groups.add(inf2a);

        @WimMadeThis
        Group inf2b = new Group("INF2B");
        inf2b.setCoach(wim);
        groups.add(inf2b);

        // students
        Student piet = new Student("Piet", "de Vries", "121231@student.inholland.nl", inf2a);
        piet.getGrades().add(new Grade("Java Fundamentals", 10));
        piet.setGroup(inf2b);
        students.add(piet);

        // students
        Student maartje = new Student("Maartje", "Hendriks", "122341@student.inholland.nl", inf2a);
        maartje.getGrades().add(new Grade("Wiskunde", 8));
        maartje.setGroup(inf2a);
        students.add(maartje);
    }
}
