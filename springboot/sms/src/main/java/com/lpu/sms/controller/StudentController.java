package com.lpu.sms.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.lpu.sms.entity.Student;
import com.lpu.sms.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // CREATE
    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    // GET BY ID
    @GetMapping("/{id}")
    public Optional<Student> getStudentById(@PathVariable int id) {
        return studentService.getStudentById(id);
    }

    // GET ALL
    @GetMapping
    public List<Student> getAllStudents(Authentication authentication) {

        return studentService.getAllStudents(authentication);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable int id, @RequestBody Student student) {
        return studentService.updateStudent(id, student);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
        return "Student deleted successfully";
    }
    
    @GetMapping("/studentSort/{page}/{size}/{field}")
    public Page<Student> getStudentsPagination(
            @PathVariable int page,
            @PathVariable int size,
            @PathVariable String field) {

        return studentService.getStudentsWithPagination(page, size, field);
    }
    
 // Upload Profile Image
    @PostMapping("/uploadProfile/{id}")
    public Student uploadProfileImage(
            @PathVariable int id,
            @RequestParam("file") MultipartFile file) throws IOException {

        return studentService.uploadProfileImage(id, file);
    }

    // Upload Assignment File
    @PostMapping("/uploadAssignment/{id}")
    public Student uploadAssignmentFile(
            @PathVariable int id,
            @RequestParam("file") MultipartFile file) throws IOException {

        return studentService.uploadAssignmentFile(id, file);
    }
    
    @GetMapping("/download/profile/{id}")
    public ResponseEntity<byte[]> downloadProfileImage(@PathVariable int id) {

        Student student = studentService.getStudentById(id).orElseThrow();

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(student.getImageType()))
                .body(student.getProfileImage());
    }

    // Download assignment
    @GetMapping("/download/assignment/{id}")
    public ResponseEntity<byte[]> downloadAssignment(@PathVariable int id) {

        byte[] file = studentService.downloadAssignment(id);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=assignment.pdf")
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(file);
    }
}