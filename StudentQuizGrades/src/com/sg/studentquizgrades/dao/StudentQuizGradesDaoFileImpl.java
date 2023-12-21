package com.sg.studentquizgrades.dao;

import com.sg.studentquizgrades.dto.Student;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentQuizGradesDaoFileImpl implements StudentQuizGradesDao {

    private Map<String, Student> students = new HashMap<>();
    private Map<String, List<Integer> quizGrades = new HashMap<>();
    @Override
    public Student addStudent(String studentId, Student student) {
        Student prevStudent = students.put(studentId, student);
        return prevStudent;
    }
    @Override
    public Student quizScores(String studentName, List<Integer> quizzes) {
        Student prevStudent = quizGrades.put(studentName,quizzes);
        return prevStudent;
    }
    @Override
    public List<Student> getAllStudents() {
        return new ArrayList<Student>(students.values());
    }

    @Override
    public Student removeStudent(String studentId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Student getStudent(String studentId) {
        return students.get(studentId);
    }


}
