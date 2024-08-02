package com.example.coursera.Controler;

import com.example.coursera.ApiResponse.ApiResponseStudent;
import com.example.coursera.Model.Student;
import com.example.coursera.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/get")
    public ResponseEntity getStudents() {
        ArrayList<Student> students = studentService.getStudents();
        return ResponseEntity.ok(students);

    }

    @PostMapping("add")
    public ResponseEntity addStudent(@Valid @RequestBody Student student, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getAllErrors().get(0).getDefaultMessage();
            return ResponseEntity.badRequest().body(message);
        }
        studentService.addStudent(student);
        return ResponseEntity.status(200).body(new ApiResponseStudent("student added successfully"));
    }

    @PutMapping("update{id}")
    public ResponseEntity updateStudent(@PathVariable int id, @Valid @RequestBody Student student, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getAllErrors().get(0).getDefaultMessage();
            return ResponseEntity.badRequest().body(message);
        }

        boolean isUpdated = studentService.updateStudent(id, student);
        if (isUpdated) {
            return ResponseEntity.status(200).body(new ApiResponseStudent("student updated successfully"));
        }
        return ResponseEntity.status(404).body(new ApiResponseStudent("student not found"));
    }
    @DeleteMapping("/delete{id}")
    public ResponseEntity deleteStudent(@PathVariable int id) {
        boolean isDeleted = studentService.deleteStudent(id);
        if (isDeleted) {
            return ResponseEntity.status(200).body(new ApiResponseStudent("student deleted successfully"));

        }
return ResponseEntity.status(404).body(new ApiResponseStudent("student not found"));
    }
    @GetMapping("/get/{courses}")
    public ResponseEntity getStudentsByCourses(@PathVariable String courses) {
        ArrayList<Student> students = studentService.getStudentsByCourse(courses);
        return ResponseEntity.ok(students);
    }
    @GetMapping("/get/{age}")
    public ResponseEntity getStudentsByAge(@PathVariable int age) {
        ArrayList<Student> students = studentService.getStudentsByAge(age);
        return ResponseEntity.ok(students);
    }
    @GetMapping("/get/{phone}")
    public ResponseEntity getStudentsByPhone(@PathVariable String phone) {
        ArrayList<Student> students=studentService.getStudentsByphone(phone);
        return ResponseEntity.ok(students);

    }

@GetMapping("get/{major}")
    public ResponseEntity getStudentsByMajor(@PathVariable String major) {
        ArrayList<Student> students = studentService.getStudentsByphone(major);
        return ResponseEntity.ok(students);
}





}
