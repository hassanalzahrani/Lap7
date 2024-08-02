package com.example.coursera.Controler;

import com.example.coursera.ApiResponse.ApiREsponseCourse;
import com.example.coursera.Model.Course;
import com.example.coursera.service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/course")
public class courseController {
    private final CourseService courseService;

    @GetMapping("/get")
    public ResponseEntity getCourse() {
        List<Course> courses = courseService.getCourses();
        return ResponseEntity.ok(courses);



    }
    @PostMapping("add")
    public ResponseEntity addCourse(@Valid @RequestBody Course course, Errors errors) {
        if (errors.hasErrors()) {
            String meessage = errors.getAllErrors().get(0).getDefaultMessage();
            return ResponseEntity.badRequest().body(meessage);
        }
        courseService.addCourse(course);
        return ResponseEntity.status(200).body(new ApiREsponseCourse("course added successfully"));


        }
        @PutMapping("update/{id}")
    public ResponseEntity updateCourse(@PathVariable int id ,@Valid @RequestBody Course course, Errors errors) {
        if (errors.hasErrors()) {
            String meessage = errors.getAllErrors().get(0).getDefaultMessage();
            return ResponseEntity.badRequest().body(meessage);
        }
      boolean isupdated = courseService.updateCourse(id, course);
        if (isupdated) {
            return ResponseEntity.status(200).body(new ApiREsponseCourse("course updated successfully"));
        }
        return ResponseEntity.status(404).body(new ApiREsponseCourse("course not found"));
        }
        @DeleteMapping("delete/{id}")
    public ResponseEntity deleteCourse(@PathVariable int id) {
        boolean isdeleted = courseService.deleteCourse(id);
        if (isdeleted) {
            return ResponseEntity.status(200).body(new ApiREsponseCourse("course deleted successfully"));

        }
        return ResponseEntity.status(404).body(new ApiREsponseCourse("course not found"));
        }
        @GetMapping("/get/{course}")
public ResponseEntity getCoursesByname(@PathVariable String course) {
        return ResponseEntity.ok(courseService.getCoursesByName(course));



        }
        @GetMapping("/get/{id}")
    public ResponseEntity getCourseById(@PathVariable int id) {
        return ResponseEntity.ok(courseService.getCoursesByID(id));
        }
        @GetMapping("get/{startDate}")
        public ResponseEntity deleteCourseByStartDate(@RequestParam String startDate) {
        return ResponseEntity.ok(courseService.getCourseByStartDate(startDate));

        }
        @GetMapping("/get/{courseHours}")
    public ResponseEntity getCourseByHours(@PathVariable String courseHours) {
            return ResponseEntity.ok(courseService.getCourseBycourshours(courseHours));


        }



}
