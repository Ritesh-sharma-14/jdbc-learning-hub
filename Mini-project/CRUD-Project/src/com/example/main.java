package com.example;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== STUDENT MANAGEMENT SYSTEM ===");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sc.nextLine();
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter email: ");
                    String email = sc.nextLine();
                    System.out.print("Enter age: ");
                    int age = sc.nextInt();
                    dao.addStudent(new Student(name, email, age));
                    break;

                case 2:
                    List<Student> list = dao.getAllStudents();
                    System.out.println("\n--- Student List ---");
                    for (Student s : list) {
                        System.out.println(s.getId() + " | " + s.getName() + " | " + s.getEmail() + " | " + s.getAge());
                    }
                    break;

                case 3:
                    System.out.print("Enter student ID to update: ");
                    int idU = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter new name: ");
                    String newName = sc.nextLine();
                    System.out.print("Enter new email: ");
                    String newEmail = sc.nextLine();
                    System.out.print("Enter new age: ");
                    int newAge = sc.nextInt();
                    dao.updateStudent(idU, newName, newEmail, newAge);
                    break;

                case 4:
                    System.out.print("Enter student ID to delete: ");
                    int idD = sc.nextInt();
                    dao.deleteStudent(idD);
                    break;

                case 5:
                    System.out.println("👋 Exiting...");
                    break;

                default:
                    System.out.println("❌ Invalid choice!");
            }
        } while (choice != 5);
    }
}

