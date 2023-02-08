package com.tpe.controller;


import com.tpe.domain.Student;
import com.tpe.dto.StudentDTO;
import com.tpe.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/students")  // http://localhost:8080/students. end point neyse ona gore yonlendiriyor
public class StudentController {

    Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentService studentService;

    // Get all students
    @GetMapping   // http://localhost:8080/students. +get
   // @PreAuthorize("hasRole('ADMIN')")  // HasRole den dolayi ROLE_ADMIN
    public ResponseEntity<List <Student> >getAll() {
        List<Student> students = studentService.getAll();
        return ResponseEntity.ok(students);  //200 kodunu HTTP status kodu olarak gonderir.

    }

    // student objesi olusturalim.
    @PostMapping  // http://localhost:8080/students. +post + json
    public ResponseEntity<Map<String,String>> createStudent(@Valid @RequestBody Student student) {
      studentService.createStudent(student);
      Map<String,String> map = new HashMap<>();
      map.put("message","Student is created successfully");
      map.put("status","true");
        // @Valid : parametreler valid mi kontrol eder, bu örenekte Student
        //objesi oluşturmak için  gönderilen fieldlar yani
        //name gibi özellikler düzgün set edilmiş mi ona bakar.
        // @RequestBody = gelen parametreyi, requestin bodysindeki bilgilerin ,
        //Student objesine map edilmesini sağlıyor.

      return new ResponseEntity<>(map, HttpStatus.CREATED);  //201
    }

    //id ile ogrenci getirelim @RequestParam ile ...
    @GetMapping("/query")  // http://localhost:8080/students/query?id=1 birden fazla field istenirse bu kullanilir.
    public ResponseEntity<Student> getStudent(@RequestParam ("id") Long id) { // birden fazla data olursa bu sekilde
        Student student = studentService.findStudent(id);
        return ResponseEntity.ok(student);

    }

    //!! id ile ogrenci getirelim @pathvariable tek data alinacaksa pathvariable kullanilir.

    @GetMapping("{id}") // http://localhost:8080/students/1 get ile
    public ResponseEntity <Student> getStudentWithPath (@PathVariable("id")Long id) {
        Student student = studentService.findStudent(id);
        return ResponseEntity.ok(student);  //student +200 kodu
    }

    // Delete
    // !!! Delete
    @DeleteMapping("/{id}") // http://localhost:8080/students/1  + DELETE
    public ResponseEntity<Map<String,String>> deleteStudent(@PathVariable("id") Long id) {

        studentService.deleteStudent(id);

        Map<String,String> map = new HashMap<>();
        map.put("message","Student is deleted successfuly");
        map.put("status" ,"true");

        return new ResponseEntity<>(map, HttpStatus.OK); // return ResponseEntity.ok(map);
    }

       // !!! Update:
    @PutMapping("{id}")  // http://localhost:8080/students/1  + PUT +json
    public ResponseEntity<Map<String,String>> updateStudent (@PathVariable("id") Long id, @Valid
                                                             @RequestBody StudentDTO studentDTO){ //jsondan geleni studentDTO ya mapliyorum.
        studentService.updateStudent(id,studentDTO);
        Map<String,String> map = new HashMap<>();
        map.put("message","Student is updated successfuly");
        map.put("status" ,"true");

        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    //  Pageable :
    @GetMapping("/page")
    public ResponseEntity<Page <Student>> getAllWithPage (
            @RequestParam("page") int page, //hangi page dondurlulecek .. 0 dan basliyor.
            @RequestParam("size") int size, // page basi kac student olacak
            @RequestParam ("sort") String prop, // siralama hangi field a gore yapilacak
            @RequestParam("direction") Sort.Direction direction) // dogal sirali mi olsun?

    {
        Pageable pageable = PageRequest.of(page,size,Sort.by(direction,prop));
        Page<Student> studentPage = studentService.getAllWithPage(pageable);
        return ResponseEntity.ok(studentPage);

    }

    // Get by Lastname:
    @GetMapping("/querylastname")  // http://localhost:8080/students/querylastname
    public ResponseEntity<List<Student>> getStudentByLastName (@RequestParam("lastName") String lastName) {
       List<Student> list = studentService.findStudent(lastName);

       return ResponseEntity.ok(list);
    }

    // Get All Student By Grade (JPQL) Java persistence Query Language.
    @GetMapping ("/grade/{grade}")  //http://localhost:8080/students/grade/75 +get
    public ResponseEntity <List<Student>> getStudentsEqualsGrade (@PathVariable ("grade") Integer grade) {
        List<Student> list = studentService.findAllEqualsGrade(grade);

        return ResponseEntity.ok(list);
    }

    // DB den direct DTO olarak data alabilir miyim?
    @GetMapping("/query/dto") // http://localhost:8080/students/query/dto?id=1
    public ResponseEntity<StudentDTO> getStudentDTO (@RequestParam("id") Long id) {
        StudentDTO studentDTO=studentService.findStudentDTOById(id);
        return ResponseEntity.ok(studentDTO);

    }

    @GetMapping ("/welcome")  // http://localhost:8080/students/welcome + GET
    public String welcome(HttpServletRequest request) {  //HttpsServletRequest ile requeste ulastim
        logger.warn("---------------- Welcome {}", request.getServletPath());
        return "Student Controller'a Hosgeldiniz";

    }










}
