package com.jeight.baiscs.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MINMAXAVGDemo {
    public static void main(String[] args) {

        Teacher e1 = new Teacher(1,"Robert",26500.00,"USA");
        Teacher e2 = new Teacher(2,"Abrahm",46500.00,"INDIA");
        Teacher e3 = new Teacher(3,"Chen",36500.00,"CHINA");
        Teacher e4 = new Teacher(4,"David",16500.00,"INDIA");
        Teacher e5 = new Teacher(5,"Cathy",25500.00,"USA");

        List<Teacher> TeachersList = Arrays.asList(e1,e2,e3,e4,e5);
        System.out.println("=============MAX, MIN and AVG salary from given employees============");

        Optional<Teacher> minSalary = TeachersList.stream().min(Comparator.comparing(person -> person.salary));
        System.out.println("Min salary::"+minSalary);

        Optional<Teacher> maxSalary = TeachersList.stream().max(Comparator.comparing(person -> person.salary));
        System.out.println("Max salary::"+maxSalary);

        Double avgSalary = TeachersList.stream().collect(Collectors.averagingDouble(Teachers->Teachers.salary));
        System.out.println("Average salary::"+avgSalary);
    }
}

class Teacher {
    int id;
    String name;
    double salary;
    String country;

    public Teacher(int id, String name, double salary,String country){
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.country = country;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", country='" + country + '\'' +
                '}';
    }
}
