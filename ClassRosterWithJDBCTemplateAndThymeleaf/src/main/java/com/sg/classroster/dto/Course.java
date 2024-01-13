package com.sg.classroster.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.Objects;

public class Course {
    private int id;
    @NotBlank(message = "Name must not be blank")
    @Size(max = 50, message="Name must be fewer than 50 characters")
    private String name;

    @Size(max = 255, message = "Description must be fewer than 255 characters")
    private String description;

    private Teacher teacher;
    private List<Student> students;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course course)) return false;
        return getId() == course.getId() && Objects.equals(getName(), course.getName()) && Objects.equals(getDescription(), course.getDescription()) && Objects.equals(getTeacher(), course.getTeacher()) && Objects.equals(getStudents(), course.getStudents());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getDescription(), getTeacher(), getStudents());
    }
}
