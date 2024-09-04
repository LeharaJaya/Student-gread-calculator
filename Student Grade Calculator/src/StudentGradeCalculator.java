import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private ArrayList<Integer> grades;

    public Student(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addGrade(int grade) {
        grades.add(grade);
    }

    public ArrayList<Integer> getGrades() {
        return grades;
    }

    public double calculateAverage() {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return grades.size() > 0 ? (double) sum / grades.size() : 0;
    }
}

public class StudentGradeCalculator {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int option;

        do {
            System.out.println("\n--- Student Grade Calculator ---");
            System.out.println("1. Add Student");
            System.out.println("2. Add Grade to Student");
            System.out.println("3. View All Students");
            System.out.println("4. Calculate Student Average");
            System.out.println("5. Update Student Name");
            System.out.println("6. Remove Student");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            option = scanner.nextInt();
            scanner.nextLine(); // consume newline character

            switch (option) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    addGradeToStudent();
                    break;
                case 3:
                    viewAllStudents();
                    break;
                case 4:
                    calculateStudentAverage();
                    break;
                case 5:
                    updateStudentName();
                    break;
                case 6:
                    removeStudent();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        } while (option != 7);
    }

    private static void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        students.add(new Student(name));
        System.out.println("Student added successfully!");
    }

    private static void addGradeToStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        Student student = findStudentByName(name);
        if (student != null) {
            System.out.print("Enter grade: ");
            int grade = scanner.nextInt();
            scanner.nextLine(); // consume newline character
            student.addGrade(grade);
            System.out.println("Grade added successfully!");
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void viewAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
        } else {
            System.out.println("\n--- Student List ---");
            for (Student student : students) {
                System.out.println("Name: " + student.getName() + " | Grades: " + student.getGrades());
            }
        }
    }

    private static void calculateStudentAverage() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        Student student = findStudentByName(name);
        if (student != null) {
            double average = student.calculateAverage();
            System.out.println("Average grade for " + name + ": " + average);
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void updateStudentName() {
        System.out.print("Enter current student name: ");
        String currentName = scanner.nextLine();
        Student student = findStudentByName(currentName);
        if (student != null) {
            System.out.print("Enter new student name: ");
            String newName = scanner.nextLine();
            students.remove(student);
            students.add(new Student(newName));
            System.out.println("Student name updated successfully!");
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void removeStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        Student student = findStudentByName(name);
        if (student != null) {
            students.remove(student);
            System.out.println("Student removed successfully!");
        } else {
            System.out.println("Student not found.");
        }
    }

    private static Student findStudentByName(String name) {
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                return student;
            }
        }
        return null;
    }
}

