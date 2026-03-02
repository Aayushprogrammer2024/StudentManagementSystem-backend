package com.example.Practice2CRUD.Controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Practice2CRUD.Entity.Student;
import com.example.Practice2CRUD.Service.StudentService;

import jakarta.validation.Valid;



@RestController
@RequestMapping("/students")
@CrossOrigin(origins = "http://localhost:5174")
public class AppControlller {
    private final StudentService studentService;
    public AppControlller(StudentService studentService)
    {
        this.studentService=studentService;
    }
    @GetMapping
    public Page<Student> getAll(Pageable pageable)
    {
        return studentService.getAll(pageable);
    }
    @PostMapping
    public Student CreatStudent(@Valid @RequestBody Student student)
    {
        return studentService.CreatStudent(student);
    }
    @GetMapping("/{id}")
public Student getById(@PathVariable Integer id) {
    return studentService.getById(id);
}

@DeleteMapping("/{id}")
public String deleteStudent(@PathVariable Integer id)
{
    studentService.deleteStudent(id);
    return "Student Deleted Successfully";
}
    
  @PutMapping("/{id}")
public Student updateStudent(@PathVariable Integer id, @RequestBody Student updatedStudent) {

   return studentService.updateStudent(id, updatedStudent);
}
   @GetMapping("/search")
public Page<Student> searchStudents(
        @RequestParam String name,
        Pageable pageable) {
    return studentService.searchStudents(name, pageable);
} 
    
}
