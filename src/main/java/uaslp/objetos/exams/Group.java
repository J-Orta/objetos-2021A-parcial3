package uaslp.objetos.exams;

import java.util.LinkedList;

public class Group {

    private LinkedList<Student> students;
    private int capacity;
    private int availability;
    private double average;

    public Group(int capacity) {
        this.capacity = capacity;
        students = new LinkedList<>();
    }

    public LinkedList<Student> getStudents() {
        return students;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getAvailability() {
        availability = capacity - students.size();
        return availability;
    }

    public void addStudent(Student student) {

        if (getAvailability() == 0) {
            throw new GroupIsFullException();
        }
        students.add(student);
    }

    public double getAverage() {

        Student student;
        double sum = 0.0;

        for (int i = 0; i < students.size(); i++) {
            student = students.get(i);
            sum += student.getAverage();
        }
            average = sum / students.size();

            return average;


    }
}
