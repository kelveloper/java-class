package com.sg.studentquizgrades.dao;

import com.sg.studentquizgrades.dto.Student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentQuizGradesDaoFileImpl implements StudentQuizGradesDao {

    private Map<String, Integer[]> students = new HashMap<>();
    @Override
    public Integer[] addStudent(String studentId, Integer [] student) {

        Integer[] prevStudent = students.put(studentId, student);
        return prevStudent;
    }

    @Override
    public List<Student> getAllStudents() {
        return null;
    }

    @Override
    public Student getStudent(String studentId) {
        return null;
    }

    @Override
    public Student removeStudent(String studentId) {
        return null;
    }
}
