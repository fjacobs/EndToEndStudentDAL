package com.endtoend;

import com.endtoend.student.dal.entities.Student;
import com.endtoend.student.dal.repos.StudentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Iterator;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentdalApplicationTests {

    private static final String testStudentName = "TestJohn";
    private static final String testTraining =  "TestTraining";

    @Autowired
    private StudentRepository studentRepository;


    @Test
    public void testCrud() {
        testCreateStudent();
        testReadStudent();
        testUpdateStudent();
        testDeleteStudent();
    }

    private Student findTestStudent() {
        Iterator<Student> all = studentRepository.findAll().iterator();
        while (all.hasNext()) {
            Student student = all.next();
            if(student.getName().equals(testStudentName)) {
                return student;
            }
        }
        throw new RuntimeException("Can't find test student");
    }

    public void testCreateStudent(){
        Student student = new Student();
        student.setName(testStudentName);
        student.setCourse(testTraining);
        student.setFee(30d);
        studentRepository.save(student);
    }

    public void testReadStudent(){
        System.out.println(findTestStudent().toString());
    }

    public void testUpdateStudent(){
        Student student = findTestStudent();
        student.setFee(40d);
        studentRepository.save(student);
    }

    public void testDeleteStudent(){
        Student student = findTestStudent();
        studentRepository.delete(student);
    }

}
