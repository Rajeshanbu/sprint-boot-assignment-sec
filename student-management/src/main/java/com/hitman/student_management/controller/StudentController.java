/*package com.hitman.student_management.controller;

import com.hitman.student_management.model.Student;
import com.hitman.student_management.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping
    public ResponseEntity<Student> create(@Valid @RequestBody Student student) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createStudent(student));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> get(@PathVariable Long id) {
        return service.getStudent(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> update(@PathVariable Long id, @Valid @RequestBody Student updated) {
        return service.updateStudent(id, updated)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return service.softDeleteStudent(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<Page<Student>> list(
            @RequestParam(required = false) String status,
            @RequestParam(required = false) Double minGpa,
            @RequestParam(required = false) Double maxGpa,
            @RequestParam(required = false) String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id,asc") String[] sort
    ) {
        Sort sortOrder = Sort.by("id");

        if (sort != null && sort.length > 0) {
            sortOrder = Sort.by(
                    Arrays.stream(sort)
                            .map(s -> {
                                String[] parts = s.split(",");
                                if (parts.length == 2) {
                                    String field = parts[0];
                                    Sort.Direction direction = parts[1].equalsIgnoreCase("desc")
                                            ? Sort.Direction.DESC
                                            : Sort.Direction.ASC;
                                    return new Sort.Order(direction, field);
                                } else {
                                    return new Sort.Order(Sort.Direction.ASC, s);
                                }
                            }).toList()
            );
        }

        Pageable pageable = PageRequest.of(page, size, sortOrder);
        return ResponseEntity.ok(service.listStudents(status, minGpa, maxGpa, name, pageable));
    }
}
*/
/* 
package com.hitman.student_management.controller;

import com.hitman.student_management.model.Student;
import com.hitman.student_management.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping
    public ResponseEntity<Student> create(@Valid @RequestBody Student student) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createStudent(student));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> get(@PathVariable Long id) {
        return service.getStudent(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> update(@PathVariable Long id, @Valid @RequestBody Student updated) {
        return service.updateStudent(id, updated)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return service.softDeleteStudent(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<Page<Student>> list(
            @RequestParam(required = false) String status,
            @RequestParam(required = false) Double minGpa,
            @RequestParam(required = false) Double maxGpa,
            @RequestParam(required = false) String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id,asc") String[] sort
    ) {
        Sort sortOrder = Sort.by("id");

        if (sort != null && sort.length > 0) {
            sortOrder = Sort.by(
                    Arrays.stream(sort)
                            .map(s -> {
                                String[] parts = s.split(",");
                                if (parts.length == 2) {
                                    String field = parts[0];
                                    Sort.Direction direction = parts[1].equalsIgnoreCase("desc")
                                            ? Sort.Direction.DESC
                                            : Sort.Direction.ASC;
                                    return new Sort.Order(direction, field);
                                } else {
                                    return new Sort.Order(Sort.Direction.ASC, s);
                                }
                            }).toList()
            );
        }

        Pageable pageable = PageRequest.of(page, size, sortOrder);
        return ResponseEntity.ok(service.listStudents(status, minGpa, maxGpa, name, pageable));
    }
}
*/
/* 
package com.hitman.student_management.controller;

import com.hitman.student_management.model.Student;
import com.hitman.student_management.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping
    public ResponseEntity<Student> create(@Valid @RequestBody Student student) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createStudent(student));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> get(@PathVariable Long id) {
        return service.getStudent(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> update(@PathVariable Long id, @Valid @RequestBody Student updated) {
        return service.updateStudent(id, updated)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return service.softDeleteStudent(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<Page<Student>> list(
            @RequestParam(required = false) String status,
            @RequestParam(required = false) Double minGpa,
            @RequestParam(required = false) Double maxGpa,
            @RequestParam(required = false) String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(value = "sort", required = false) String[] sortParams
    ) {
        Sort sort = Sort.by("id"); // default sort

        if (sortParams != null && sortParams.length > 0) {
            sort = Sort.by(
                Arrays.stream(sortParams)
                        .map(param -> {
                            String[] parts = param.split(",");
                            if (parts.length == 2) {
                                return new Sort.Order(Sort.Direction.fromString(parts[1]), parts[0]);
                            } else {
                                return new Sort.Order(Sort.Direction.ASC, parts[0]);
                            }
                        }).toList()
            );
        }

        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Student> result = service.listStudents(status, minGpa, maxGpa, name, pageable);
        return ResponseEntity.ok(result);
    }
}
*/
package com.hitman.student_management.controller;

import com.hitman.student_management.model.Student;
import com.hitman.student_management.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService service;

    // Create a new student
    @PostMapping
    public ResponseEntity<Student> create(@Valid @RequestBody Student student) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createStudent(student));
    }

    // Get a single student by ID (works for active/inactive)
    @GetMapping("/{id}")
    public ResponseEntity<Student> get(@PathVariable Long id) {
        return service.getStudent(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update student
    @PutMapping("/{id}")
    public ResponseEntity<Student> update(@PathVariable Long id, @Valid @RequestBody Student updated) {
        return service.updateStudent(id, updated)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Soft delete student (mark INACTIVE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return service.softDeleteStudent(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }

    // List all students with pagination, sorting, and filtering
    @GetMapping
    public ResponseEntity<Page<Student>> list(
            @RequestParam(required = false) String status,
            @RequestParam(required = false) Double minGpa,
            @RequestParam(required = false) Double maxGpa,
            @RequestParam(required = false) String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(value = "sort", defaultValue = "id,asc") List<String> sort
    ) {
        Sort sortOrder = Sort.by(
                sort.stream().map(s -> {
                    String[] parts = s.split(",");
                    if (parts.length == 2) {
                        return new Sort.Order(Sort.Direction.fromString(parts[1].trim()), parts[0].trim());
                    } else {
                        return new Sort.Order(Sort.Direction.ASC, s.trim());
                    }
                }).toList()
        );

        Pageable pageable = PageRequest.of(page, size, sortOrder);
        Page<Student> students = service.listStudents(status, minGpa, maxGpa, name, pageable);
        return ResponseEntity.ok(students);
    }
}
