package com.obs.controller;

import com.obs.entity.EntityStudent;
import com.obs.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@CrossOrigin(origins = "*")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    public List<EntityStudent> getAllStudents() {
        return studentRepository.findAll();
    }

    @PostMapping
    public EntityStudent createStudent(@RequestBody EntityStudent student) {
        calculateAverage(student);
        return studentRepository.save(student);
    }

    @PutMapping("/{id}")
    public EntityStudent updateStudent(@PathVariable Long id, @RequestBody EntityStudent updatedStudent) {
        EntityStudent student = studentRepository.findById(id).orElseThrow();
        student.setName(updatedStudent.getName());
        student.setSurname(updatedStudent.getSurname());
        student.setEmail(updatedStudent.getEmail());
        student.setMidterm(updatedStudent.getMidterm());
        student.setFinalExam(updatedStudent.getFinalExam());
        student.setProject(updatedStudent.getProject());
        student.setAttendance(updatedStudent.getAttendance());
        calculateAverage(student);
        return studentRepository.save(student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentRepository.deleteById(id);
    }

    private void calculateAverage(EntityStudent student) {
        Double midterm = student.getMidterm() != null ? student.getMidterm() : 0.0;
        Double finalExam = student.getFinalExam() != null ? student.getFinalExam() : 0.0;
        Double project = student.getProject() != null ? student.getProject() : 0.0;
        Double average = (midterm * 0.3) + (finalExam * 0.5) + (project * 0.2);
        student.setAverage(average);
    }
}
