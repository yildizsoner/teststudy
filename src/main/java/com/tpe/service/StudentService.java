package com.tpe.service;

import com.tpe.domain.Student;
import com.tpe.dto.StudentDTO;
import com.tpe.exception.ConflictException;
import com.tpe.exception.ResourceNotFoundException;
import com.tpe.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    public void createStudent(Student student) {
        if(studentRepository.existsByEmail(student.getEmail())) {
            throw new ConflictException("Email is already exist");
        }
        studentRepository.save(student);
    }

    public Student findStudent(Long id) {
        return studentRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Student not found with id :"+id) );
    }

    public void deleteStudent(Long id) {

        Student student = findStudent(id);
        studentRepository.delete(student);

    }


    public void updateStudent(Long id, StudentDTO studentDTO) {
        boolean existEmail=studentRepository.existsByEmail(studentDTO.getEmail()); //forma girilen deger
        Student student = findStudent(id);

        if(existEmail && ! studentDTO.getEmail().equals(student.getEmail())){
            throw new ConflictException("Email is already exist");
        }

        /*

        1. kendi email : mrc ayni email ile update --.true && false
        2. kendi email : mrc , ahmet farkli email ile ve DB de zaten ahmet var -->true && true
        3. kendi email : mrc , mehmet farkli email ve DB de yok --> false && true

         */

        student.setName(studentDTO.getFirstName());  //dersi tekrar ederken methodlari kendin yaz.
        student.setLastName(studentDTO.getLastName());
        student.setGrade(studentDTO.getGrade());
        student.setEmail(studentDTO.getEmail());
        student.setPhoneNumber(studentDTO.getPhoneNumber());

        studentRepository.save(student);

    }

    public Page<Student> getAllWithPage(Pageable pageable) {
        return studentRepository.findAll(pageable);  // sql

    }

    public List<Student> findStudent (String lastName) {

        return studentRepository.findByLastName(lastName);
    }


    public List<Student> findAllEqualsGrade(Integer grade) {
        return studentRepository.findAllEqualsGrade(grade);
    }

    public StudentDTO findStudentDTOById(Long id) {
        return studentRepository.findStudentDTOById(id).orElseThrow(()->
                new ResourceNotFoundException("Student not found with id"));
    }
}
