package com.learning.elevate_ed.elevate_ed.dto;


import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class User {

    @NotNull
    String userId;
    @NotNull
    String password;
}
