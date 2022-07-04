package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class StudentService {

    private final StudentRepositery studentRepositery;
    
    
    public StudentService(StudentRepositery studentRepositery) {
        this.studentRepositery = studentRepositery;
    }

    public List<Student> getStudents(){
       return studentRepositery.findAll();
    }

    public void addNewStudent(Student student) { 
         studentRepositery.save(student);
//        System.out.println(student);
    }

    public void deleteById(Long id) {
        boolean blnExist=studentRepositery.existsById(id);
        if(!blnExist){
            throw new IllegalStateException("student id"+id+"is not available");
        }
        studentRepositery.deleteById(id);
    }
@Transactional
    public void updateStudent(Long id, String name, String email) {
        Student student=studentRepositery.findById(id).orElseThrow(() -> new IllegalStateException(
                "student not exist"));
        student.setName(name);
        student.setEmail(email);
    }
}
