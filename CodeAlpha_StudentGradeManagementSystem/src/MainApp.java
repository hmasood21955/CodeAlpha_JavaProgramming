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

    public void run() {
        System.out.println("Welcome to the Student Grade Tracker!");
        while (true) {
            System.out.println("\n1. Add a Student");
            System.out.println("2. Add Grades for a Student");
            System.out.println("3. View All Students' Details");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    addGrade();
                    break;
                case 3:
                    gradeTracker.displayAllStudents();
                    break;
                case 4:
                    System.out.println("Exiting the program. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        gradeTracker.addStudent(new Student(name));
        System.out.println("Student added successfully!");
    }

    private void addGrade() {
        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();
        Student student = gradeTracker.findStudent(studentName);
        if (student != null) {
            System.out.print("Enter grade: ");
            double grade = scanner.nextDouble();
            student.addGrade(grade);
            System.out.println("Grade added successfully!");
        } else {
            System.out.println("Student not found!");
        }
    }
}

// Main class to run the application
public class MainApp {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        manager.run();
    }
}
