package com.wiley.schoolJPA.dao;

import com.wiley.schoolJPA.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepo extends JpaRepository<Teacher, Integer > {
}