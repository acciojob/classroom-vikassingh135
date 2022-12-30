/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.driver;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Vikas_Singh
 */
@Service
public class StudentService {
    
    @Autowired
    private StudentRepository studentRepo;
    
    void addStudent(Student student) {
        studentRepo.addStudent(student);
    }
    
    void addTeacher(Teacher teacher) {
        studentRepo.addTeacher(teacher);
    }
    
    void addTeacherStudentPair(String teacherName, String studentName) {
        studentRepo.addTeacherStudentPair(teacherName, studentName);
    }
    
    Student getStudentByName(String studentName) {
        return studentRepo.getStudentByName(studentName);
    }
    
    Teacher getTeacherByName(String teacherName) {
        return studentRepo.getTeacherByName(teacherName);
    }
    
    List<String> getStudentsbyTeacherName(String teacherName) {
        return studentRepo.getStudentsByTeacherName(teacherName);
    }
    
    List<String> getAllStudents() {
        return studentRepo.getAllStudents();
    }
    
    void deleteTeacherByName(String teacherName) {
        studentRepo.deleteTeacherByName(teacherName);
    }
    
    void deleteAllTeachers() {
        studentRepo.deleteAllTeachers();
    }
}
