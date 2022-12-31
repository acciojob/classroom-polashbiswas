package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Repository
public class StudentRepository {

    private HashMap<String, Student> studentMap;
    private HashMap<String, Teacher> teacherMap;
    private HashMap<String, List<String>> teacherStudentMapping;

    public StudentRepository() {
        this.studentMap = new HashMap<>();
        this.teacherMap = new HashMap<>();
        this.teacherStudentMapping = new HashMap<>();
    }

    String saveStudent(Student student){
        String name = student.getName();
        studentMap.put(name, student);
        return "Successfully added";
    }

    String saveTeacher(Teacher teacher){
        String name = teacher.getName();
        teacherMap.put(name, teacher);
        return "Successfully Added";
    }

    String saveTeacherStudentPair(String student, String teacher){
        List<String> studentList = teacherStudentMapping.getOrDefault(teacher, new ArrayList<>());
        studentList.add(student);
        teacherStudentMapping.put(teacher, studentList);
        return "Successfully added";
    }

    public Student findStudent(String studentName){
        return studentMap.get(studentName);
    }

    public Teacher findTeacher(String teacherName){
        return teacherMap.get(teacherName);
    }

    public List<String> findStudentNameFromTeacher(String teacher){
        List<String> studentNameList = teacherStudentMapping.getOrDefault(teacher, new ArrayList<>());
        return studentNameList;
    }

    public List<String> allStudentFind(){
        return new ArrayList<>(studentMap.keySet());
    }

    public void deleteTeacher(String teacher){
        List<String> studentList = teacherStudentMapping.get(teacher);
        for (String s : studentList) {
            if (studentMap.containsKey(s)) {
                studentMap.remove(s);
            }
        }
        teacherStudentMapping.remove(teacher);
    }

    public void deleteAllTeacher(){
        for (String teacher : teacherStudentMapping.keySet()) {
            List<String> StudentList = teacherStudentMapping.get(teacher);
            for (String s : StudentList) {
                if (studentMap.containsKey(s)) {
                    studentMap.remove(s);
                }
            }
        }
        teacherStudentMapping.clear();
    }


}
