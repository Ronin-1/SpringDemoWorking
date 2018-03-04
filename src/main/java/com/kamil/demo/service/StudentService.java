package com.kamil.demo.service;

import com.kamil.demo.dao.StudentDao;
import com.kamil.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentService {

    private final StudentDao studentDao;
@Autowired
    public StudentService(@Qualifier("fakeDao") StudentDao studentDao) {
        this.studentDao = studentDao;
    }


    public int persistNewStudent(UUID studentId, Student student){
        UUID studentUid = studentId == null ? UUID.randomUUID() : studentId;
        student.setId( studentId );
        return studentDao.insertNewStudent( studentUid, student);

    }

    public Student getStudentById(UUID studentId){
        return studentDao.selectStudentById( studentId );

    }

    public List<Student> getAllStudents(){
        return studentDao.selectAllStudents();

    }

    public int updateStudentById(UUID studentId, Student studentUpdate){
        return studentDao.updateStudentById( studentId, studentUpdate );
    }

    public int deleteStudentById(UUID studentId) {
        Student studentById = getStudentById( studentId );
        return studentDao.deleteStudentById( studentId );

    }



}
