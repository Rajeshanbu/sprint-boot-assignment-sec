/*package com.hitman.student_management.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    @Email
    private String email;

    @NotNull
    private LocalDate dateOfBirth;

    @Enumerated(EnumType.STRING)
    private Status status = Status.ACTIVE;

    @NotNull
    private LocalDate enrollmentDate;

    @DecimalMin("0.0")
    @DecimalMax("10.0")
    private Double gpa;

    public enum Status {
        ACTIVE, INACTIVE
    }

    // 👉 Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public LocalDate getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }

    public LocalDate getEnrollmentDate() { return enrollmentDate; }
    public void setEnrollmentDate(LocalDate enrollmentDate) { this.enrollmentDate = enrollmentDate; }

    public Double getGpa() { return gpa; }
    public void setGpa(Double gpa) { this.gpa = gpa; }
}
*/
package com.hitman.student_management.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Entity
@Table(name = "students")
public class Student {

    @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@NotBlank(message = "First name is required")
private String firstName;

@NotBlank(message = "Last name is required")
private String lastName;

@NotBlank(message = "Email is required")
@Email(message = "Invalid email format")
private String email;

@NotNull(message = "Date of birth is required")
private LocalDate dateOfBirth;

@Enumerated(EnumType.STRING)
private Status status = Status.ACTIVE;

@NotNull(message = "Enrollment date is required")
private LocalDate enrollmentDate;

@DecimalMin(value = "0.0", message = "GPA must be >= 0.0")
@DecimalMax(value = "10.0", message = "GPA must be <= 10.0")
private Double gpa;

public enum Status {
    ACTIVE,
    INACTIVE
}

// Getters and Setters

public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

public String getFirstName() {
    return firstName;
}

public void setFirstName(String firstName) {
    this.firstName = firstName;
}

public String getLastName() {
    return lastName;
}

public void setLastName(String lastName) {
    this.lastName = lastName;
}

public String getEmail() {
    return email;
}

public void setEmail(String email) {
    this.email = email;
}

public LocalDate getDateOfBirth() {
    return dateOfBirth;
}

public void setDateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
}

public Status getStatus() {
    return status;
}

public void setStatus(Status status) {
    this.status = status;
}

public LocalDate getEnrollmentDate() {
    return enrollmentDate;
}

public void setEnrollmentDate(LocalDate enrollmentDate) {
    this.enrollmentDate = enrollmentDate;
}

public Double getGpa() {
    return gpa;
}

public void setGpa(Double gpa) {
    this.gpa = gpa;
}
}
