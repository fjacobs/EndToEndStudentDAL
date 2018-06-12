package com.endtoend;

import com.endtoend.student.dal.entities.Student;
import com.endtoend.student.dal.repos.StudentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentdalApplicationTests {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void testCreateStudent(){
        Student student = new Student();
        student.setName("John");
        student.setCourse("Micro Services Training");
        student.setFee(30d);
        studentRepository.save(student);
    }

}
