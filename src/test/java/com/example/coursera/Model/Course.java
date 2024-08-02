package com.example.coursera.Model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Valid
public class Course {



        private int id;
        @NotEmpty(message = "Course name cannot be blank")
        private String name;
        @NotEmpty(message = "Course description cannot be empty")
        private String description;
        @NotEmpty(message = "Start date cannot be null")
        private LocalDate startDate;
        @NotEmpty(message = "End date cannot be null")
        private LocalDate endDate;
        @NotEmpty(message = "courseHours  cannot be empty")
        private String courseHours;

}
