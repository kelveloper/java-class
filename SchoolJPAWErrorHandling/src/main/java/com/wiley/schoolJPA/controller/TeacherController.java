package com.wiley.schoolJPA.controller;

import com.wiley.schoolJPA.dao.TeacherRepo;
import com.wiley.schoolJPA.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/teacher")
@CrossOrigin
public class TeacherController {
    @Autowired
    private TeacherRepo teacherRepo;

    @GetMapping("/teachers")
    public ResponseEntity<List<Teacher>> allTeachers() {
        List<Teacher> teachers = teacherRepo.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(teachers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Teacher> getTeachersById(@PathVariable("id") Integer id) {
        Teacher teacher = teacherRepo.findById(id).orElse(null);
        if (teacher == null) {
            return new ResponseEntity<Teacher>(teacher, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<Teacher>(teacher, HttpStatus.OK);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addNewTeacher(@Valid @RequestBody Teacher teacher, BindingResult result) {
        try {
            if (result.hasErrors()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }

            teacherRepo.save(teacher);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeacher(@PathVariable("id") Integer id) {
        try {
            if (!teacherRepo.existsById(id)) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }

            teacherRepo.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Teacher> updateTeacher(@PathVariable("id") Integer id, @Valid @RequestBody Teacher teacher, BindingResult result) {
        try {
            if (result.hasErrors()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }

            if (!teacherRepo.existsById(id)) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }

            teacher.setId(id);
            teacherRepo.save(teacher);
            return new ResponseEntity<>(teacher, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}