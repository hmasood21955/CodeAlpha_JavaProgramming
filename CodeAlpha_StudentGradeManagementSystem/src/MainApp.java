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

    public void displayStudentDetails() {
        System.out.println("\nStudent Name: " + name);
        System.out.println("Grades: " + grades);
        System.out.println("Average Grade: " + calculateAverage());
        System.out.println("Highest Grade: " + findHighestGrade());
        System.out.println("Lowest Grade: " + findLowestGrade());
    }
}

// Class to manage students and their grades
class GradeTracker {
    private ArrayList<Student> students;

    public GradeTracker() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public Student findStudent(String name) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getName().equalsIgnoreCase(name)) {
                return students.get(i);
            }
        }
        return null;
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found!");
            return;
        }
        for (int i = 0; i < students.size(); i++) {
            students.get(i).displayStudentDetails();
        }
    }
}

// Class to handle user interaction
class StudentManager {
    private Scanner scanner;
    private GradeTracker gradeTracker;

    public StudentManager() {
        scanner = new Scanner(System.in);
        gradeTracker = new GradeTracker();
    }
