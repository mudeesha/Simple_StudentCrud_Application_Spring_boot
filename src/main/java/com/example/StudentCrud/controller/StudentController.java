package com.example.StudentCrud.controller;

import com.example.StudentCrud.dto.StudentDTO;
import com.example.StudentCrud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/student")
@CrossOrigin("http://localhost:3000")
public class StudentController {
    //inject user service
    @Autowired
    private StudentService studentService;

    //create methods
    //Get method
    @GetMapping("/getStudents")
    public List<StudentDTO> getStudent(){
        return studentService.getAllStudents();
    }

    //post method
    @PostMapping("/saveStudent")
    public StudentDTO saveStudent(@RequestBody StudentDTO studentDTO){
        //call Studentservice
        return studentService.saveStudent(studentDTO);
    }

    //update method
    @PutMapping("/updateStudent")
    public StudentDTO updateStudent(@RequestBody StudentDTO studentDTO){
        return studentService.updateStudent(studentDTO);
    }

    @DeleteMapping("/deleteStudent")
    public boolean deleteUser(@RequestBody StudentDTO studentDTO){
        return studentService.deleteStudent(studentDTO);
    }

    @GetMapping("/getStudentById/{studentId}")
    public StudentDTO getStudentById(@PathVariable String studentId){
        //call method in service layer
        return studentService.getStudentById(studentId);
    }
}
