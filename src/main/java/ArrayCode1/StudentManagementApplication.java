package ArrayCode1;

import java.util.ArrayList;
import java.util.Scanner;


public class StudentManagementApplication {
    private final ArrayList<Student> students;
    private final Scanner scanner;

    public StudentManagementApplication() {
        students = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            System.out.println("***** STUDENT MANAGEMENT APPLICATION *****");
            System.out.println("Please select one of the following menu items:");
            System.out.println("(1) Capture a new student.");
            System.out.println("(2) Search for a student.");
            System.out.println("(3) Delete a student.");
            System.out.println("(4) Print student report.");
            System.out.println("(5) Exit Application.");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (choice) {
                case 1:
                    captureStudent();
                    break;
                case 2:
                    searchStudent();
                    break;
                case 3:
                    deleteStudent();
                    break;
                case 4:
                    printStudentReport();
                    break;
                case 5:
                    exitApplication();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public void captureStudent() {
        System.out.println("***** CAPTURE A NEW STUDENT *****");
        System.out.print("Enter the student id: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over
        System.out.print("Enter the student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter the student age: ");
        int age = getValidAge();
        System.out.print("Enter the student email: ");
        String email = scanner.nextLine();
        System.out.print("Enter the student course: ");
        String course = scanner.nextLine();

        Student student = new Student(id, name, age, email, course);
        students.add(student);
        System.out.println("Student details have been successfully saved.");
    }

    private int getValidAge() {
        while (true) {
            try {
                int age = scanner.nextInt();
                if (age >= 16) {
                    return age;
                } else {
                    System.out.println("You have entered an incorrect student age!!! Please re-enter the student age:");
                }
            } catch (Exception e) {
                System.out.println("You have entered an incorrect student age!!! Please re-enter the student age:");
                scanner.nextLine(); // Consume invalid input
            }
        }
    }

    private void searchStudent() {
        System.out.println("***** SEARCH FOR A STUDENT *****");
        System.out.print("Enter the student id to search: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        for (Student student : students) {
            if (student.getId() == id) {
                System.out.println("STUDENT ID: " + student.getId());
                System.out.println("STUDENT NAME: " + student.getName());
                System.out.println("STUDENT AGE: " + student.getAge());
                System.out.println("STUDENT EMAIL: " + student.getEmail());
                System.out.println("STUDENT COURSE: " + student.getCourse());
                return;
            }
        }
        System.out.println("Student with Student Id: " + id + " was not found!");
    }

    private void deleteStudent() {
        System.out.println("***** DELETE A STUDENT *****");
        System.out.print("Enter the student id to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        for (Student student : students) {
            if (student.getId() == id) {
                System.out.print("Are you sure you want to delete student " + id + " from the system? (y/n): ");
                String confirm = scanner.nextLine();
                if (confirm.equalsIgnoreCase("y")) {
                    students.remove(student);
                    System.out.println("Student with Student Id: " + id + " was deleted!");
                }
                return;
            }
        }
        System.out.println("Student with Student Id: " + id + " was not found!");
    }
    private void printStudentReport() {
        System.out.println("***** STUDENT REPORT *****");
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            System.out.println("STUDENT " + (i + 1));
            System.out.println("STUDENT ID: " + student.getId());
            System.out.println("STUDENT NAME: " + student.getName());
            System.out.println("STUDENT AGE: " + student.getAge());
            System.out.println("STUDENT EMAIL: " + student.getEmail());
            System.out.println("STUDENT COURSE: " + student.getCourse());
            System.out.println();
        }
    }

    private void exitApplication() {
        System.out.println("Exiting application. Goodbye!");
    }

    public static void main(String[] args) {
        StudentManagementApplication app = new StudentManagementApplication();
        app.run();
    }





    // Additional methods in StudentManagementApplication class
    public void captureStudent(Student student) {
        students.add(student);
    }

    public Student searchStudent(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public void deleteStudent(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                students.remove(student);
                return;
            }
        }
    }

    public Student getStudent(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }}
