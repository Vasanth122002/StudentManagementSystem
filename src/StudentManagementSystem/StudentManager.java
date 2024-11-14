package StudentManagementSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;



public class StudentManager {
    private List<Student> students;

    public StudentManager() {
        students = new ArrayList<>();
    }

   

    public void deleteStudent(int rollNo) {
        students.removeIf(student -> student.getRollNo() == rollNo);
    }

    public void viewAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    public void updateStudent(int rollNo, String newName, String newCourse) {
        for (Student student : students) {
            if (student.getRollNo() == rollNo) {
                student.setName(newName);
                student.setCourse(newCourse);
                break;
            }
        }
    }

    public Student searchStudent(int rollNo) {
        for (Student student : students) {
            if (student.getRollNo() == rollNo) {
                return student;
            }
        }
        return null;
    }
    public boolean addStudent(String name, int rollNo, String course) {
        for (Student student : students) {
            if (student.getRollNo() == rollNo) {
                System.out.println("Roll number already exists!");
                return false;  
            }
        }
        students.add(new Student(name, rollNo, course));
        return true;  
    }
    public void sortStudentsByRollNo() {
        Collections.sort(students, Comparator.comparingInt(Student::getRollNo));
        viewAllStudents();
    }

    public void sortStudentsByName() {
        Collections.sort(students, Comparator.comparing(Student::getName));
        viewAllStudents();
    }


public void displayStatistics() {
    System.out.println("Total number of students: " + students.size());


    Map<String, Integer> courseCount = new HashMap<>();
    for (Student student : students) {
        courseCount.put(student.getCourse(), courseCount.getOrDefault(student.getCourse(), 0) + 1);
    }
    System.out.println("Number of students per course:");
    for (Map.Entry<String, Integer> entry : courseCount.entrySet()) {
        System.out.println(entry.getKey() + ": " + entry.getValue());
    }
}


}