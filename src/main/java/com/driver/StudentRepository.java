/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Vikas_Singh
 */
@Repository
public class StudentRepository {

    HashMap<String, Student> studentDb = new HashMap<>();
    HashMap<String, Teacher> teacherDb = new HashMap<>();
    HashMap<String, List<String>> teacherStudentsDb = new HashMap<>();

    void addStudent(Student student) {
        studentDb.put(student.getName(), student);
    }

    void addTeacher(Teacher teacher) {
        teacherDb.put(teacher.getName(), teacher);
    }

    void addTeacherStudentPair(String teacherName, String studentName) {
        if (!teacherStudentsDb.containsKey(teacherName)) {
            teacherStudentsDb.put(teacherName, new ArrayList<>());
        }
        teacherStudentsDb.get(teacherName).add(studentName);
    }

    Student getStudentByName(String studentName) {
        return studentDb.get(studentName);
    }

    Teacher getTeacherByName(String teacherName) {
        return teacherDb.get(teacherName);
    }

    List<String> getStudentsByTeacherName(String teacherName) {
        return teacherStudentsDb.get(teacherName);
    }

    List<String> getAllStudents() {
        return new ArrayList<>(studentDb.keySet());
    }

    void deleteTeacherByName(String teacherName) {
        if (teacherStudentsDb.containsKey(teacherName)) {
            for (String s : teacherStudentsDb.get(teacherName)) {
                studentDb.remove(s);
            }
        }
        teacherDb.remove(teacherName);
    }

    void deleteAllTeachers() {
        for (String teacherName : teacherDb.keySet()) {
            if (teacherStudentsDb.containsKey(teacherName)) {
                for (String s : teacherStudentsDb.get(teacherName)) {
                    studentDb.remove(s);
                }
            }
            teacherDb.remove(teacherName);
        }
    }
}
