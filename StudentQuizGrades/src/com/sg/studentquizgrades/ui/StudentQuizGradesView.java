package com.sg.studentquizgrades.ui;

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
}
