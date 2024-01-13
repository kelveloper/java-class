package com.wiley.schoolJPA.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tid", nullable = false)
    private Integer id;

    @Column(name = "tfname")
    @Size(max = 255, message="Name must be fewer than 255 characters")
    private String fName;

    @Column(name = "tlname")
    @Size(max = 255, message="Name must be fewer than 255 characters")
    private String lName;

    @Column(name = "dept")
    @Size(max = 255, message="Name must be fewer than 255 characters")
    private String dept;

    @OneToMany(mappedBy = "courseTeacher")
    private Set<Course> teacherClasses;

    public Teacher() {
    }

    //added constructor for teacherClasses
    public Teacher(Set<Course> teacherClasses) {
        this.teacherClasses = teacherClasses;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }
}