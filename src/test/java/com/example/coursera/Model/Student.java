package com.example.coursera.Model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Valid
public class Student {
    @Size(min = 10,max = 10)
    @NotNull(message = "ID should not be empty")
        private int id;
    @NotEmpty(message = "email should not be empty")
    @Email
    private String email;
        @NotEmpty(message = "Name should not be empty")
        private String name;
        @NotNull(message = "Age should not be empty")
        @Min(value = 19,message = "you must be over 18")
        private int age;
        @NotEmpty(message = "Major should not be empty ")
        private String major ;
    @NotEmpty(message = "course should not be empty")
        @Pattern(regexp = "^(scientific|literary)$")
        private String courses;
        private String phoneNumber;



    }
