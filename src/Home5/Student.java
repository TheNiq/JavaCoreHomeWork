package Home5;
import java.util.Arrays;

public class Student {
    private int id;
    private String surName;
    private int marks[];
    private boolean visits[];


    public Student(int id, String surName, int number) {
        this.id = id;
        this.surName = surName;
        this.marks = new int[number];
        this.visits = new boolean[number];
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public int[] getMarks() {
        return marks;
    }
    public int getMark(int lesson){
        return this.marks[lesson-1];
    }

    public void setMarks(int[] marks) {
        this.marks = marks;
    }
    public void setMark(int lesson,int mark){
        this.marks[lesson-1] = mark;
    }

    public boolean[] getVisits() {
        return visits;
    }
    public boolean getVisit(int lesson){
        return this.visits[lesson-1];
    }

    public void setVisits(boolean[] visits) {
        this.visits = visits;
    }
    public void setVisit(int lesson, boolean visit){
        this.visits[lesson-1] = visit;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", surName='" + surName + '\'' +
                ", marks=" + Arrays.toString(marks) +
                ", visits=" + Arrays.toString(visits) +
                '}';
    }
}
