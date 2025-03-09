package com.learning.elevate_ed.elevate_ed.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Learner {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @NotEmpty(message = "UserID should not be empty")
    @NotNull(message = "User ID should not be null")
    String userId;
    @NotEmpty(message = "Mentor name should not be empty")
    @NotNull(message = "Mentor name should not be null")
    String name;
    @NotEmpty(message = "Password should not be empty")
    @NotNull(message = "Password should not be null")
    String password;
    @NotNull(message = "Email should not be null")
    @NotEmpty(message = "Email should not be empty")
    String email;
    LocalDate dateOfBirth;
    String interests;
    String occupation;
    String qualification;

}
