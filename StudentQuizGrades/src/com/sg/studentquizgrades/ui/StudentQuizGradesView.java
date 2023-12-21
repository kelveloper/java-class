package com.sg.studentquizgrades.ui;

import com.sg.studentquizgrades.dto.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentQuizGradesView {
    private UserIO io = new UserIOConsoleImpl();

    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. List Students");
        io.print("2. Create New Student");
        io.print("3. Remove a Student");
        io.print("4. List of Quiz Scores For a Student");
        io.print("5. Average Quiz Scores For a Student");
        io.print("6. Exit");

        return io.readInt("Please select from the above choices.", 1, 6);
    }

    public void displayStudentList(List<Student> studentList) {
        for (Student currentStudent : studentList) {
            String studentInfo = String.format("#%s : %s %s",
                    currentStudent.getStudentId(),
                    currentStudent.getFirstName(),
                    currentStudent.getLastName());
            io.print(studentInfo);
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayDisplayAllBanner() {
        io.print("=== Display All Students ===");
    }
    public void displayDisplayStudentQuizScores() {
        io.print("=== Display Student's Quiz Scores ===");
    }

    public Student getNewStudentInfo() {
        String studentId = io.readString("Please enter Student ID");
        String firstName = io.readString("Please enter First Name");
        String lastName = io.readString("Please enter Last Name");
        Student currentStudent = new Student(studentId);
        currentStudent.setFirstName(firstName);
        currentStudent.setLastName(lastName);
        return currentStudent;
    }

    public Student getStudentQuizGrades() {
        ArrayList<Integer> quizList = new ArrayList<>();
        int quizGrade  = io.readInt("Please enter a List of Quiz  Grade");
        while(io.readInt() != 0) {
            quizList.
        }

    }

    public void displayCreateStudentBanner() {
        io.print("=== Create Student ===");
    }
    public void displayCreateSuccessBanner() {
        io.readString(
                "Student successfully created.  Please hit enter to continue");
    }

    public void displayDisplayStudentBanner () {
        io.print("=== Display Student ===");
    }

    public String getStudentIdChoice() {
        return io.readString("Please enter the Student ID.");
    }

    public void displayStudent(Student student) {
        if (student != null) {
            io.print(student.getStudentId());
            io.print(student.getFirstName() + " " + student.getLastName());
            io.printInt(student.getQuizGrade());
            io.print("");
        } else {
            io.print("No such student.");
        }
        io.readString("Please hit enter to continue.");
    }

}
