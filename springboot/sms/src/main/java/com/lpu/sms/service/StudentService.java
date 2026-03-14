package com.lpu.sms.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.lpu.sms.entity.Student;
import com.lpu.sms.repository.StudentRepository;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // CREATE STUDENT (ADMIN only)
    //@PreAuthorize("hasRole('ADMIN')")
    public Student saveStudent(Student student) {

        student.setPassword(passwordEncoder.encode(student.getPassword()));

        return studentRepository.save(student);
    }

    // GET STUDENT BY ID (Cache + PostAuthorize)
    @Cacheable(value = "students", key = "#id")
    @PostAuthorize("hasRole('ADMIN') or (returnObject.isPresent() and returnObject.get().email.equals(authentication.name))")
    public Optional<Student> getStudentById(int id) {
        return studentRepository.findById(id);
    }

    // GET ALL STUDENTS
    public List<Student> getAllStudents(Authentication authentication) {

        String email = authentication.getName();
        Student student = studentRepository.findByEmail(email).orElseThrow();

        if(student.getRole().equals("ADMIN")) {
            return studentRepository.findAll();
        }

        return List.of(student);
    }

    // UPDATE STUDENT
    @CachePut(value = "students", key = "#id")
    @PreAuthorize("hasRole('ADMIN')")
    public Student updateStudent(int id, Student student) {

        Student existing = studentRepository.findById(id).orElseThrow();

        existing.setName(student.getName());
        existing.setEmail(student.getEmail());
        existing.setPassword(passwordEncoder.encode(student.getPassword()));
        existing.setCourse(student.getCourse());
        existing.setMarks(student.getMarks());

        return studentRepository.save(existing);
    }

    // DELETE STUDENT
    @CacheEvict(value = "students", key = "#id")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteStudent(int id) {

        studentRepository.deleteById(id);
    }

    // PAGINATION + SORTING
    public Page<Student> getStudentsWithPagination(int page, int size, String field) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(field));

        return studentRepository.findAll(pageable);
    }

    // UPLOAD PROFILE IMAGE
    //@PreAuthorize("#id == authentication.principal.username || hasRole('ADMIN')")
    public Student uploadProfileImage(int id, MultipartFile file) throws IOException {

        Student student = studentRepository.findById(id).orElseThrow();

        student.setProfileImage(file.getBytes());
        student.setImageType(file.getContentType());

        return studentRepository.save(student);
    }

    // UPLOAD ASSIGNMENT
    //@PreAuthorize("#id == authentication.principal.username || hasRole('ADMIN')")
    public Student uploadAssignmentFile(int id, MultipartFile file) throws IOException {

        Student student = studentRepository.findById(id).orElseThrow();

        student.setAssignmentFile(file.getBytes());

        return studentRepository.save(student);
    }

    // DOWNLOAD PROFILE IMAGE
    public byte[] downloadProfileImage(int id) {

        Student student = studentRepository.findById(id).orElseThrow();

        return student.getProfileImage();
    }

    // DOWNLOAD ASSIGNMENT
    public byte[] downloadAssignment(int id) {

        Student student = studentRepository.findById(id).orElseThrow();

        return student.getAssignmentFile();
    }
}