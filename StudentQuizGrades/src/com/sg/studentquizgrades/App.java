package com.sg.studentquizgrades;

import com.sg.studentquizgrades.controller.StudentQuizGradesController;

public class App {

    public static void main(String[] args) {
        StudentQuizGradesController controller = new StudentQuizGradesController();
        controller.run();
    }
}