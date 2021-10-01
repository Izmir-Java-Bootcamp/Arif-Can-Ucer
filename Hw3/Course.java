package com.kodluyoruz.weekone;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Course {

    private String name;
    private int capacity;
    private Student[] students = new Student[0];
    private int numberOfStudents = 0;

    // Course oluşturulurken 'capacity'
    // girilmezse, default olarak 40 değeri atanır.
    public Course(String name) {
        this.name = name;
        this.capacity = 40;
    }

    public Course(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    // Eğer aynı ID'de başka bir öğrenci yok ise, öğrenciyi sınıfa ekler.
    public boolean addStudent(Student student){

        if (numberOfStudents < capacity){
            for (int i = 0; i < students.length; i++){
                if (students[i].getId() == student.getId()){
                    return false;
                }
            }
            students = Arrays.copyOf(students,students.length + 1);
            numberOfStudents++;
            students[numberOfStudents -1] = student;
            return true;
        }
        return false;
    }

    // Öğrenciyi sınıftan atar.
    public boolean dropStudent(Student student){

        List<Student> s = new LinkedList<Student>(Arrays.asList(students));
        for (int i = 0; i < students.length; i++){
            if(students[i].getId() == student.getId()){
                s.remove(i);
                students = s.toArray(new Student[students.length - 1]);
                numberOfStudents--;
                return true;
            }
        }
            return false;
    }

    // Sınıf kapasitesini '5' artırır.
    public void increaseCapacity(){
        this.capacity += 5;
    }

    // GPA değeri en yüksek öğreniciyi döndürür.
    public Student getBestStudent(){

        for (int i = 0; i < students.length; i++){
            for (int j = i+1; j < students.length; j++){
                if (students[i].getGpa() > students[j].getGpa()){
                    Student student = students[i];
                    students[i] = students[j];
                    students[j] = student;
                }
            }
        }
        return students[students.length-1];
    }

    // Doğum tarihi en büyük öğrenciyi döndürür.
    public Student getYoungestStudent(){
        for (int i = 0; i < students.length; i++){
            for (int j = i+1; j < students.length; j++){
                if (students[i].getPd().getBirthDate().isAfter(students[j].getPd().getBirthDate())){
                    Student student = students[i];
                    students[i] = students[j];
                    students[j] = student;
                }
            }
        }
        return students[students.length-1];
    }

    // Course içerisindeki tüm öğrencileri siler.
    public void clear(){
        this.students = new Student[0];
        numberOfStudents = 0;
    }

    // Kurstaki bütün öğrencileri ekrana yazdırır.
    public void list(){
        for (Student std : students){
            System.out.println("Öğrencinin adı : " + std.getName());
            System.out.println("Öğrencinin ID'si : " + std.getId());
        }

        if (numberOfStudents == 0)
            System.out.println("Bu kursta hiç öğrenci yok...");

    }

    public String getName() {
        return name;
    }

    public Student[] getStudents() {
        return students;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }
}
