package com.driver;

import java.util.List;

public class StudentService {

    StudentRepository studentRepository = new StudentRepository();

    public void addStudent(Student student){
        studentRepository.saveStudent(student);
    }

    public void addTeacher(Teacher teacher){
        studentRepository.saveTeacher(teacher);
    }

    public void addStudentTeacherPair(String student, String teacher){
        studentRepository.saveTeacherStudentPair(student, teacher);
    }

    public Student getStudentByName(String studentName){
        return studentRepository.findStudent(studentName);
    }

    public Teacher getTeacherByName(String teacherName){
        return studentRepository.findTeacher(teacherName);
    }

    public List<String> getStudentByTeacherName(String teacher){
        return studentRepository.findStudentNameFromTeacher(teacher);
    }

    public List<String> getAllStudent(){
        return studentRepository.allStudentFind();
    }

    public void deleteTeacherByName(String teacher){
        studentRepository.deleteTeacher(teacher);
    }

    public void deleteAllTeacher(){
        studentRepository.deleteAllTeacher();
    }
}
