package com.example.Practice2CRUD.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.Practice2CRUD.Entity.Student;
import com.example.Practice2CRUD.Repository.StudentRepository;

@Service
public class StudentService {
    private final StudentRepository studentRepo;
    public StudentService(StudentRepository studentRepo){
        this.studentRepo=studentRepo;
    }
    
    public Page<Student> getAll(Pageable pageable)
    {
        return studentRepo.findAll(pageable);
    }
    public Student getById(Integer id) {
    return studentRepo.findById(id).orElse(null);
}

public Page<Student> searchStudents(String name, Pageable pageable) {
    return studentRepo.findByNameContainingIgnoreCase(name, pageable);
}

 public Student CreatStudent( Student student)
    {
        return studentRepo.save(student);
    }

    public String deleteStudent(Integer id)
{
    studentRepo.deleteById(id);
    return "Student Deleted Successfully";
}

public Student updateStudent(Integer id, @RequestBody Student updatedStudent) {

    Student existing = studentRepo.findById(id).orElse(null);

    if (existing != null) {
        existing.setName(updatedStudent.getName());
        existing.setEmail(updatedStudent.getEmail());
        return studentRepo.save(existing);
    }

    return null;
}

}
