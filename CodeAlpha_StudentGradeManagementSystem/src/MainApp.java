import java.util.*;

// Class to represent a Student
class Student {
    private String name;
    private ArrayList<Double> grades;

    public Student(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addGrade(double grade) {
        grades.add(grade);
    }

    public double calculateAverage() {
        if (grades.isEmpty()) return 0.0;
        double sum = 0;
        for (int i = 0; i < grades.size(); i++)
        sum += grades.get(i);
        return sum / grades.size();
    }

    public double findHighestGrade() {
        if (grades.isEmpty()) return 0.0;
        double highest = grades.get(0);
        for (int i = 1; i < grades.size(); i++) {
            if (grades.get(i) > highest) 
            highest = grades.get(i);
        }
        return highest;
    }

    public double findLowestGrade() {
        if (grades.isEmpty()) return 0.0;
        double lowest = grades.get(0);
        for (int i = 1; i < grades.size(); i++) {
            if (grades.get(i) < lowest) 
            lowest = grades.get(i);
        }
        return lowest;
    }

