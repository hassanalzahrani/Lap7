package com.example.coursera.service;

import com.example.coursera.Model.Course;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;

@Service
public class CourseService {
    ArrayList<Course> courses = new ArrayList<Course>();

    public ArrayList<Course> getCourses() {
        return courses;
    }
    public void addCourse(Course course) {
        courses.add(course);

    }
    public boolean updateCourse(int id,Course course) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getId() == id) {
                courses.set(i, course);
                return true;
            }
        }
        return false;

    }
    public boolean deleteCourse(int id) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getId() == id) {
                courses.remove(i);
                return true;
            }
        }
        return false;
    }
    public ArrayList<Course> getCoursesByName(String name) {
        ArrayList<Course>coursesname=new ArrayList<>();
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getName().equalsIgnoreCase(name)) {
                coursesname.add(courses.get(i));

            }
        }
        return coursesname;
    }
    public ArrayList<Course> getCoursesByID(int id) {
        ArrayList<Course> coursesbyid =new ArrayList<>();
        for (int i = 0; i < courses.size(); i++) {
        if (courses.get(i).getId() == id) {
        coursesbyid.add(courses.get(i));
        }
        }
        return coursesbyid;
    }
    public ArrayList<Course> getCourseByStartDate(String startDate) {
    ArrayList<Course> coursesbystartdate =new ArrayList<>();
    for (int i = 0; i < courses.size(); i++) {
        if (courses.get(i).getStartDate().equals(startDate)) {
            coursesbystartdate.add(courses.get(i));

        }

    }
    return coursesbystartdate;
    }
    public ArrayList<Course> getCourseBycourshours(String courshours) {
        ArrayList<Course> coursesbycourshours =new ArrayList<>();
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getCourseHours().equals(courshours)) {
                coursesbycourshours.add(courses.get(i));
            }
        }
        return coursesbycourshours;
    }
}
