package com.sg.studentquizgrades.controller;

import com.sg.studentquizgrades.ui.StudentQuizGradesView;
import com.sg.studentquizgrades.ui.UserIO;
import com.sg.studentquizgrades.ui.UserIOConsoleImpl;

public class StudentQuizGradesController {
    private StudentQuizGradesView view = new StudentQuizGradesView();
    private UserIO io = new UserIOConsoleImpl();

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        while (keepGoing) {
            io.print("Main Menu");
            io.print("1. List Student IDs");
            io.print("2. Create New Student");
            io.print("3. View a Student");
            io.print("4. Remove a Student");
            io.print("5. Exit");

            menuSelection = getMenuSelection();

            switch (menuSelection) {
                case 1:
                    io.print("View a list of students");
                    break;
                case 2:
                    io.print("CREATE STUDENT");
                    break;
                case 3:
                    io.print("VIEW STUDENT");
                    break;
                case 4:
                    io.print("REMOVE STUDENT");
                    break;
                case 5:
                    keepGoing = false;
                    break;
                default:
                    io.print("UNKNOWN COMMAND");
            }

        }
        io.print("GOOD BYE");
    }
    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }
}
