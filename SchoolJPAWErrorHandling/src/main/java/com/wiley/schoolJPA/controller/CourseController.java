package com.wiley.schoolJPA.controller;

import com.wiley.schoolJPA.dao.CourseRepo;
import com.wiley.schoolJPA.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/course")
@CrossOrigin
public class CourseController {
    @Autowired
    private CourseRepo courseRepo;

    @GetMapping("/courses")
    public ResponseEntity<List<Course>> allCourses() {
        List<Course> courses = courseRepo.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(courses);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Course> getCourseById(@PathVariable("id") Integer id) {
        Course course = courseRepo.findById(id).orElse(null);
        return new ResponseEntity<Course>(course, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addNewCourse(@Valid @RequestBody Course course, BindingResult result) {
        try {
            if (result.hasErrors()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }

            courseRepo.save(course);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable("id") Integer id, @Valid @RequestBody Course course, BindingResult result) {
        try {
            if (result.hasErrors()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }

            if (!courseRepo.existsById(id)) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }

            course.setId(id);
            courseRepo.save(course);
            return new ResponseEntity<>(course, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable("id") Integer id) {
        try {
            if (!courseRepo.existsById(id)) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }

            courseRepo.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
