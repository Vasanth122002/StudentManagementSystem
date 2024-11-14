package StudentManagementSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        while (true) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search for Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Update Student Details");
            System.out.println("6. Students(Asending order by Name)");
            System.out.println("7. Students(Asending order by RollNo)");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter roll number: ");
                    int rollNo = scanner.nextInt();
                    scanner.nextLine();  
                    System.out.print("Enter course: ");
                    String course = scanner.nextLine();
                    manager.addStudent(name, rollNo, course);
                    break;
                case 2:
                    manager.viewAllStudents();
                    break;
                case 3:
                    System.out.print("Enter roll number to search: ");
                    int searchRollNo = scanner.nextInt();
                    Student student = manager.searchStudent(searchRollNo);
                    if (student != null) {
                        System.out.println("Student found: " + student);
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;
                case 4:
                    System.out.print("Enter roll number to delete: ");
                    int deleteRollNo = scanner.nextInt();
                    manager.deleteStudent(deleteRollNo);
                    break;
                case 5:
                    System.out.print("Enter roll number to update: ");
                    int updateRollNo = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new course: ");
                    String newCourse = scanner.nextLine();
                    manager.updateStudent(updateRollNo, newName, newCourse);
                    break;
                case 6:
                	System.out.println();
                    System.out.print("students(Asending order by Name)");
                    System.out.println();
              
                    manager.sortStudentsByName();
                    break;
                case 7:
                	System.out.println();
                    System.out.print("students(Asending order by RollNo)");
                    System.out.println();
              
                    manager.sortStudentsByRollNo();
                    break;
                case 8:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
