package com.wiley.schoolJPA.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cid", nullable = false)
    private Integer id;

    @Column(name = "coursename")
    @Size(max = 255, message="Name must be fewer than 255 characters")
    private String courseName;

    @Column(name = "coursedesc")
    @Size(max = 255, message="Name must be fewer than 255 characters")
    private String courseDesc;

    @ManyToOne
    @JoinColumn(name = "teacherid")
    private Teacher courseTeacher;

    @ManyToMany
    @JoinTable(
            name = "course_student",
            joinColumns = {@JoinColumn(name = "course_id")},
            inverseJoinColumns = {@JoinColumn(name = "student_id")}
    )
    private Set<Student> studentRoster;

    public Course() {}

    public Course(Set<Student> studentRoster) {
        this.studentRoster = studentRoster;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDesc() {
        return courseDesc;
    }

    public void setCourseDesc(String courseDesc) {
        this.courseDesc = courseDesc;
    }

    public Teacher getCourseTeacher() {
        return courseTeacher;
    }

    public void setCourseTeacher(Teacher courseTeacher) {
        this.courseTeacher = courseTeacher;
    }
}