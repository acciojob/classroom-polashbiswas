package com.driver;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    StudentRepository studentRepository = new StudentRepository();

    String addStudent(Student student){
        String result = studentRepository.saveStudent(student);
        return result;
    }

    String addTeacher(Teacher teacher){
        String result = studentRepository.saveTeacher(teacher);
        return result;
    }

    String addStudentTeacherPair(String student, String teacher){
        String result = studentRepository.saveTeacherStudentPair(student, teacher);
        return result;
    }

    public Student getStudentByName(String studentName){
        Student student = studentRepository.findStudent(studentName);
        return student;
    }

    public Teacher getTeacherByName(String teacherName){
        Teacher teacher = studentRepository.findTeacher(teacherName);
        return teacher;
    }

    public List<String> getStudentByTeacherName(String teacher){
        List<String> studentNameList = studentRepository.findStudentNameFromTeacher(teacher);
        return studentNameList;
    }

    public List<String> getAllStudent(){
        List<String> studentList = studentRepository.allStudentFind();
        return studentList;
    }

    public void deleteTeacherByName(String teacher){
        studentRepository.deleteTeacher(teacher);
        return;
    }

    public void deleteAllTeacher(){
        studentRepository.deleteAllTeacher();
        return;
    }
}
