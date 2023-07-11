package com.assignments;

public class StudentInformation {

    private Student[] students;

    public void display(){
        System.out.println("Student info:");
        System.out.println();
        for (Student student : students) {
            System.out.println("Student ID: " + student.getId());
            System.out.println("Student name: " + student.getName());
            System.out.println("Student department: " + student.getDepartment());
            System.out.println();
        }

    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public static void main(String[] args) {
        StudentInformation studentInformation = new StudentInformation();

        Student[] students = new Student[10];
        students[0] = new Student("Eric",1212 , "Comuter Science");
        students[1] = new Student("John",1213 , "Information technology");
        students[2] = new Student("Mary",1214 , "Health care management");
        students[3] = new Student("Ron",1215 , "Informantion business analysis");
        students[4] = new Student("Robert",1216 , "Mobile application developmeny");
        students[5] = new Student("Elman",1217 , "Electrical engineering");
        students[6] = new Student("Mohammad",1218 , "Data Science");
        students[7] = new Student("Imran",1219 , "Mechanical");
        students[8] = new Student("Morten",1220 , "Business Administration");
        students[9] = new Student("Richard",1221 , "Advanced Care Paramedic");

        studentInformation.setStudents(students);

        studentInformation.display();
    }
}

class Student{
    private String name;
    private int id;
    private String department;

    public Student(String name, int id, String department) {
        this.name = name;
        this.id = id;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
