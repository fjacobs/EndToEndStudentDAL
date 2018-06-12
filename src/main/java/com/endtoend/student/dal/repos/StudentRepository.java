package com.endtoend.student.dal.repos;

import com.endtoend.student.dal.entities.Student;
import org.springframework.data.repository.CrudRepository;

//Spring Data Access Layer.
//At runtime Spring will create an implementation of this interface on the fly.
public interface StudentRepository extends CrudRepository <Student, Long> {
}
