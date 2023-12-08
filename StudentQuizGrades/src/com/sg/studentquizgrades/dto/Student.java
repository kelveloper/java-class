package com.sg.studentquizgrades.dto;

public class Student {
    private String firstName;
    private String lastName;
    private String studentId;
    private String [] studentQuizScores;

    public Student(String studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStudentId() {
        return studentId;
    }

    public String[] studentQuizScores() {
        return studentQuizScores;
    }

    public void studentQuizScores(String [] studentQuizScores) {
        this.studentQuizScores = studentQuizScores;
    }
}
