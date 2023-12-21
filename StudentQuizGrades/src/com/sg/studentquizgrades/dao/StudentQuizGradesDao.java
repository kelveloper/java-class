package com.sg.studentquizgrades.dao;

import com.sg.studentquizgrades.dto.Student;

import java.util.List;

public interface StudentQuizGradesDao {
    Student addStudent(String studentId, Student student );
    Student quizScores(String studentName, List<Integer> quizzes);
    List<Student> getAllStudents();
    Student getStudent(String studentId);
    Student removeStudent(String studentId);
}
