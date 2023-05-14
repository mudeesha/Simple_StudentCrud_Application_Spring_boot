package com.example.StudentCrud.service;

import com.example.StudentCrud.dto.StudentDTO;
import com.example.StudentCrud.entity.Student;
import com.example.StudentCrud.repo.StudentRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentService {
    //save student get from studentController.
    //After send it to StudentRepo
    //Need to inject repository using @autowired
    @Autowired
    private StudentRepo studentRepo; //inject student repository

    //11. use modelm,apper

    @Autowired
    private ModelMapper modelMapper;

    public StudentDTO saveStudent(StudentDTO studentDTO){
        //studentRepo.save(studentDTO); //error! need to map entity and dto class  .10
        studentRepo.save(modelMapper.map(studentDTO, Student.class)); //.12
        return studentDTO;
    }

    public List<StudentDTO> getAllStudents(){
        List<Student>studentList=studentRepo.findAll();
        return modelMapper.map(studentList,new TypeToken<List<StudentDTO>>(){}.getType());
    }

    public StudentDTO updateStudent(StudentDTO studentDTO){
        studentRepo.save(modelMapper.map(studentDTO, Student.class));
        return studentDTO;
    }

    public boolean deleteStudent(StudentDTO studentDTO){
        studentRepo.delete(modelMapper.map(studentDTO, Student.class));
        return true;
    }

    //Native queary
    //Enter student id and get *
    //select * from student where id=1
    //i.write method in repo
    public StudentDTO getStudentById(String studentId){
         Student student = studentRepo.getStudentById(studentId);
         return modelMapper.map(student, StudentDTO.class);
    }


    //Enter student id, address and get *
    //select * from student where id=1 and address = "abc"
}
