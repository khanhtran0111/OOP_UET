package com.khanhtran0111;


public class Student {
    private String name;

    private String id;

    private String group;

    private String email;

    public String getName() {
        return name;
    }

    public void setName(String n) {
        this.name = n;
    }

    public String getId() {
        return id;
    }

    public void setId(String i) {
        this.id = i;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String g) {
        this.group = g;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String e) {
        this.email = e;
    }

    String getInfo() {
        return name + " - " + id + " - " + group + " - " + email;
    }

    Student() {
        name =  "Student";
        id = "000";
        group = "K62CB";
        email = "uet@vnu.edu.vn";
    }

    Student(String name, String id, String email) {
        this.name = name;
        this.id = id;
        this.group = "K62CB";
        this.email = email;
    }

    Student(Student s) {
        this.name = s.name;
        this.id = s.id;
        this.group = s.group;
        this.email = s.email;
    }

    public static void main(String[] args) {
    }
}
