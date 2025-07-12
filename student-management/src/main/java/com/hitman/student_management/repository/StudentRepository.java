/*package com.hitman.student_management.repository;

import com.hitman.student_management.model.Student;
import com.hitman.student_management.model.Student.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Page<Student> findByStatus(Status status, Pageable pageable);
    
    Page<Student> findByGpaBetween(Double minGpa, Double maxGpa, Pageable pageable);

    Page<Student> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(
        String firstName, String lastName, Pageable pageable);
}*/
package com.hitman.student_management.repository;

import com.hitman.student_management.model.Student;
import com.hitman.student_management.model.Student.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface StudentRepository extends JpaRepository<Student, Long>, JpaSpecificationExecutor<Student> {

    Page<Student> findByStatus(Status status, Pageable pageable);
    Page<Student> findByGpaBetween(Double minGpa, Double maxGpa, Pageable pageable);
    Page<Student> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(
        String firstName, String lastName, Pageable pageable);
}

