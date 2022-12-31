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

    public void saveStudent(Student student){
        studentMap.put(student.getName(), student);
    }

    public void saveTeacher(Teacher teacher){
        teacherMap.put(teacher.getName(), teacher);
    }

    public void saveTeacherStudentPair(String student, String teacher){
        if(studentMap.containsKey(student) && teacherMap.containsKey(teacher)){
            List<String> currentStudentListForTeacher = new ArrayList<>();
            if(teacherStudentMapping.containsKey(teacher)){
                currentStudentListForTeacher = teacherStudentMapping.get(teacher);
                currentStudentListForTeacher.add(student);
                teacherStudentMapping.put(teacher, currentStudentListForTeacher);
            }
        }
    }

    public Student findStudent(String studentName){
        return studentMap.get(studentName);
    }

    public Teacher findTeacher(String teacherName){
        return teacherMap.get(teacherName);
    }

    public List<String> findStudentNameFromTeacher(String teacher){
        List<String> studentNameList = new ArrayList<>();
        if(teacherStudentMapping.containsKey(teacher))
            studentNameList = teacherStudentMapping.get(teacher);
            return studentNameList;
    }

    public List<String> allStudentFind(){
        return new ArrayList<>(studentMap.keySet());
    }

    public void deleteTeacher(String teacher){
        List<String> studentList = new ArrayList<>();
        if(teacherStudentMapping.containsKey(teacher)){
            studentList = teacherStudentMapping.get(teacher);

            for(String student: studentList){
                if(studentMap.containsKey(student)){
                    studentMap.remove(student);
                }
            }
            teacherStudentMapping.remove(teacher);
        }
        if (teacherMap.containsKey(teacher)){
            teacherMap.remove(teacher);
        }
    }

    public void deleteAllTeacher(){
        HashSet<String> studentSet = new HashSet<>();
        teacherMap = new HashMap<>();
        for(String teacher: teacherStudentMapping.keySet()){
            for(String student: teacherStudentMapping.get(teacher)){
                studentSet.add(student);
            }
        }
        for(String student: studentSet){
            if(studentMap.containsKey(student)){
                studentMap.remove(student);
            }
        }
        teacherStudentMapping = new HashMap<>();
    }


}
