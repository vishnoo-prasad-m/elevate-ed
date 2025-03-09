package com.learning.elevate_ed.elevate_ed.model;


import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Mentor {


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
    @Email
    String email;

    LocalDate dateOfBirth;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinTable(
            name = "mentor_skill",
            joinColumns = @JoinColumn(name = "mentor_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    private List<Skill> skills;

    String occupation;
    String qualification;

    @Lob
    byte[] image;

}
