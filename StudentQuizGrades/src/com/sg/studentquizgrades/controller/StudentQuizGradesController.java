package com.sg.studentquizgrades.controller;

import com.sg.studentquizgrades.dao.StudentQuizGradesDao;
import com.sg.studentquizgrades.dao.StudentQuizGradesDaoFileImpl;
import com.sg.studentquizgrades.dto.Student;
import com.sg.studentquizgrades.ui.StudentQuizGradesView;
import com.sg.studentquizgrades.ui.UserIO;
import com.sg.studentquizgrades.ui.UserIOConsoleImpl;

import java.util.List;

public class StudentQuizGradesController {
    private StudentQuizGradesView view = new StudentQuizGradesView();
    private StudentQuizGradesDao dao = new StudentQuizGradesDaoFileImpl();
    private UserIO io = new UserIOConsoleImpl();

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        while (keepGoing) {

            menuSelection = getMenuSelection();

            switch (menuSelection) {
                case 1:
                    listStudents();
                    break;
                case 2:
                    createStudent();
                    break;
                case 3:
                    viewStudent();;
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

    private void listStudents() {
        view.displayDisplayAllBanner();
        List<Student> studentList = dao.getAllStudents();
        view.displayStudentList(studentList);
    }

    private void listNameQuizScore() {
        view.displayCreateStudentBanner();

    }

    private void createStudent() {
        view.displayCreateStudentBanner();
        Student newStudent = view.getNewStudentInfo();
        dao.addStudent(newStudent.getStudentId(), newStudent);
        view.displayCreateSuccessBanner();
    }

    private void viewStudent() {
        view.displayDisplayStudentBanner();
        String studentId = view.getStudentIdChoice();
        Student student = dao.getStudent(studentId);
        view.displayStudent(student);
    }
}
