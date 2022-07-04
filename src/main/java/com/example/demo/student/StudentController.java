package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



@RestController
//@RequestMapping(path = "api/v1/student")

public class StudentController {
    final private StudentService studentService;
    private static EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("example-unit");
    @Autowired
    StudentRepositery lRepo;
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    

    @GetMapping("/api/select")
	public ResponseEntity<List<Student>> getLaptopsByName(@RequestParam String name) {
		return new ResponseEntity<List<Student>>(lRepo.findByName(name), HttpStatus.OK);
	}
    /*
    @GetMapping("/api/selectemail")
    private static void findEmployeesByDept(String email) {
        EntityManager em = entityManagerFactory.createEntityManager();
        javax.persistence.Query query = em.createQuery("SELECT e FROM student e WHERE e.email = :emailName");
        query.setParameter("email", email);
        List<Student> resultList = query.getResultList();
        resultList.forEach(System.out::println);
        em.close();
    }
    */
    
    @GetMapping("/api/all")
    public List<Student> getStudents(){
    return studentService.getStudents();
    }
    @PostMapping
    public void registerNewStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }
    @DeleteMapping(path="/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        studentService.deleteById(id);
    }
    @PutMapping(path="/{id}")
    public void updateStudent(@PathVariable("id") Long id,
                              @RequestParam ( required= false ) String name,
                              @RequestParam( required= false ) String email
                    ) {
        studentService.updateStudent(id,name,email);
    }
}
