package com.kamil.demo.resource;
import java.util.List;
import java.util.UUID;

import com.kamil.demo.model.Student;
import com.kamil.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/students")
public class StudentResource {

    private final StudentService studentService;
@Autowired
    public StudentResource(StudentService studentService) {
        this.studentService = studentService;
    }
    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }


    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,
            path = "{studentId}"
    )
    public Student getStudentById(@PathVariable("studentId") UUID studentId){
    return studentService.getStudentById( studentId );
    }

    @RequestMapping(
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public void insertNewStudent(@RequestBody Student student){
        studentService.persistNewStudent( UUID.randomUUID(), student  );
    }

    @RequestMapping(
            method = RequestMethod.DELETE,
            path = "{studentId}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public void deleteStudent(@PathVariable("studentId ") UUID studentId){
        studentService.deleteStudentById(studentId);

    } /**
    @RequestMapping(
            method = RequestMethod.PUT,
            path = "{studentId}",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )

    public void updateStudent(@PathVariable("studentId") UUID studentId, Student student){
        studentService.updateStudentById( UUID studentId, student );
    }**/
}
