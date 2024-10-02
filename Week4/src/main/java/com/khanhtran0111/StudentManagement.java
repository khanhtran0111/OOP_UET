package com.khanhtran0111;

public class StudentManagement {
    Student[] students = new Student[100];

    public static boolean sameGroup(Student s1, Student s2) {
        String gr1 = s1.getGroup();
        String gr2 = s2.getGroup();
        if (gr1.equals(gr2)) {
            return true;
        }
        return false;
    }

    public void addStudent(Student newStudent) {
        int i = 0;
        while (students[i] != null && i < 100) {
            i++;
        }
        students[i] = new Student();
        students[i].setName(newStudent.getName());
        students[i].setId(newStudent.getId());
        students[i].setGroup(newStudent.getGroup());
        students[i].setEmail(newStudent.getEmail());
    }

    public String studentsByGroup() {
        //TO DO
        int i = 0;
        int k = 0;
        String[] check = new String[101];
        while (students[i] != null && i < 100) {
            int j = 0;
            while (check[j] != null && j < i) {
                if (check[j].equals(students[i].getGroup())) {
                    j = 100;
                } else {
                    j++;
                }
            }
            if (check[j] == null && j != 100) {
                check[k] = students[i].getGroup();
                k++;
            }
            i++;
        }
        i = 0;
        String rs = "";
        while (i < k) {
            rs = rs + check[i] + '\n';
            int j = 0;
            while (students[j] != null) {
                if (check[i].equals(students[j].getGroup())) {
                    rs = rs + students[j].getInfo() + '\n';
                }
                j++;
            }
            i++;
        }
        return rs;
    }

    public void removeStudent(String id) {
        //TO DO:
        int i = 0;
        while (students[i] != null && !id.equals(students[i].getId())) {
            i++;
        }
        int j = i;
        if (students[i + 1] != null) {
            for (; students[j + 1] != null; j++) {
                assert students[j] != null;
                students[j].setName(students[j + 1].getName());
                students[j].setId(students[j + 1].getId());
                students[j].setGroup(students[j + 1].getGroup());
                students[j].setEmail(students[j + 1].getEmail());
            }
        }
        students[j] = null;
    }

    public static void main(String[] args) {

    }
}
