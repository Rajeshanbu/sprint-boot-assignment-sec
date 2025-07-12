/*package com.hitman.student_management.service;

import com.hitman.student_management.model.Student;
import com.hitman.student_management.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public Student createStudent(Student student) {
        return repository.save(student);
    }

    public Optional<Student> getStudent(Long id) {
        return repository.findById(id);
    }

    public Optional<Student> updateStudent(Long id, Student updated) {
        return repository.findById(id).map(student -> {
            student.setFirstName(updated.getFirstName());
            student.setLastName(updated.getLastName());
            student.setEmail(updated.getEmail());
            student.setDateOfBirth(updated.getDateOfBirth());
            student.setEnrollmentDate(updated.getEnrollmentDate());
            student.setGpa(updated.getGpa());
            student.setStatus(updated.getStatus());
            return repository.save(student);
        });
    }

    public boolean softDeleteStudent(Long id) {
        return repository.findById(id).map(student -> {
            student.setStatus(Student.Status.INACTIVE);
            repository.save(student);
            return true;
        }).orElse(false);
    }

    public Page<Student> listStudents(String status, Double minGpa, Double maxGpa, String name,
                                      Pageable pageable) {
        Page<Student> page;

        if (status != null) {
            page = repository.findByStatus(Student.Status.valueOf(status), pageable);
        } else if (minGpa != null && maxGpa != null) {
            page = repository.findByGpaBetween(minGpa, maxGpa, pageable);
        } else if (name != null) {
            page = repository.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(name, name, pageable);
        } else {
            page = repository.findAll(pageable);
        }

        return page;
    }
}
*/
package com.hitman.student_management.service;

import com.hitman.student_management.model.Student;
import com.hitman.student_management.repository.StudentRepository;
import jakarta.persistence.criteria.Predicate; // ✅ Add this line
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public Student createStudent(Student student) {
        return repository.save(student);
    }

    public Optional<Student> getStudent(Long id) {
        return repository.findById(id);
    }

    public Optional<Student> updateStudent(Long id, Student updated) {
        return repository.findById(id).map(student -> {
            student.setFirstName(updated.getFirstName());
            student.setLastName(updated.getLastName());
            student.setEmail(updated.getEmail());
            student.setDateOfBirth(updated.getDateOfBirth());
            student.setEnrollmentDate(updated.getEnrollmentDate());
            student.setGpa(updated.getGpa());
            student.setStatus(updated.getStatus());
            return repository.save(student);
        });
    }

    public boolean softDeleteStudent(Long id) {
        return repository.findById(id).map(student -> {
            student.setStatus(Student.Status.INACTIVE);
            repository.save(student);
            return true;
        }).orElse(false);
    }

    public Page<Student> listStudents(String status, Double minGpa, Double maxGpa, String name, Pageable pageable) {
        return repository.findAll((root, query, cb) -> {
            Predicate predicate = cb.conjunction();

            if (status != null) {
                predicate = cb.and(predicate, cb.equal(root.get("status"), Student.Status.valueOf(status.toUpperCase())));
            }

            if (minGpa != null && maxGpa != null) {
                predicate = cb.and(predicate, cb.between(root.get("gpa"), minGpa, maxGpa));
            }

            if (name != null && !name.isBlank()) {
                Predicate firstNameLike = cb.like(cb.lower(root.get("firstName")), "%" + name.toLowerCase() + "%");
                Predicate lastNameLike = cb.like(cb.lower(root.get("lastName")), "%" + name.toLowerCase() + "%");
                predicate = cb.and(predicate, cb.or(firstNameLike, lastNameLike));
            }

            return predicate;
        }, pageable);
    }

    public void deleteAllStudents() {
        repository.deleteAll();
    }
}

