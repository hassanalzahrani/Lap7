package com.example.coursera.service;

import com.example.coursera.Model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentService {
    ArrayList<Student> students = new ArrayList<Student>();

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public boolean updateStudent(int id, Student student) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                students.set(i, student);
                return true;
            }
        }
        return false;
    }

    public boolean deleteStudent(int id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                students.remove(i);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Student> getStudentsByCourse(String course) {
        ArrayList<Student> newstudent = new ArrayList<>();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getCourses().equalsIgnoreCase(course)) {
                newstudent.add(students.get(i));
            }
        }
        return newstudent;


    }

    public ArrayList<Student> getStudentsByAge(int age) {
        ArrayList<Student> studentAge = new ArrayList<>();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getAge() == age) {
                studentAge.add(students.get(i));

            }
        }
        return studentAge;
    }

    public ArrayList<Student> getStudentsByphone(String phone) {
        ArrayList<Student> studentByPhone = new ArrayList<>();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getPhoneNumber().equals(phone)) {
                studentByPhone.add(students.get(i));

            }

        }
        return studentByPhone;
    }
    public ArrayList<Student> getStudentsByMajors(String major) {
        ArrayList<Student> studentByMajor = new ArrayList<>();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getMajor().equals(major)) {
                studentByMajor.add(students.get(i));
            }
        }
        return studentByMajor;
    }





}

