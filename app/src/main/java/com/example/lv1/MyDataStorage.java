package com.example.lv1;

import java.util.ArrayList;
import java.util.List;

public class MyDataStorage {

    private List<Student> students;
    private MyDataStorage(){
        students = new ArrayList<>();
    }

    static  private MyDataStorage instance;
    static MyDataStorage getInstance(){
        if(instance == null) {
            instance = new MyDataStorage();
        }
        return instance;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student){
        students.add(student);

    }

    public List<Student> readStudents()
    {
        return students;
    }
}
