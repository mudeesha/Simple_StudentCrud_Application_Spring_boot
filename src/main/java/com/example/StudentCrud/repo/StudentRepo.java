package com.example.StudentCrud.repo;

import com.example.StudentCrud.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepo extends JpaRepository<Student, Integer> { //need to extend from JPA repository and give type of student entity & id type

    @Query(value = "SELECT * FROM student WHERE id=?1", nativeQuery = true)
    Student getStudentById(String studentId);
}
