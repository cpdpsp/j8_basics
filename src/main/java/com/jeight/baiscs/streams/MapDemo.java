package com.jeight.baiscs.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class MapDemo {

    public static void main(String[] args){
        List<String> namesMap = Arrays.asList("Ashok","iu","Ani","gsmh");
        //names in upper case
        namesMap.stream().map(i->i.toUpperCase()).forEach(System.out::println);

        //length of names
        namesMap.stream().mapToInt(i->i.length()).forEach(System.out::println);

        //length of names starting with A
        namesMap.stream().filter(i-> i.startsWith("A")).map(i->i+"_"+i.length()).forEach(System.out::println);

        Employee e1 = new Employee("John",35,55000.00);
        Employee e2 = new Employee("David",25,45000.00);
        Employee e3 = new Employee("Butler",35,35000.00);
        Employee e4 = new Employee("Steve",45,65000.00);

        Stream<Employee> employeeStream = Stream.of(e1,e2,e3,e4);
        //employee name + age whose salary>=50000
        employeeStream.filter(employee -> employee.salary>=50000).map(employee -> employee.name+"_"+employee.age).forEach(System.out::println);

        List<String> javaCourses = Arrays.asList("core java","adv java","springboot");
        List<String> uiCourses = Arrays.asList("html","css","bs");
        List<List<String>> courses = Arrays.asList(javaCourses,uiCourses);
        courses.stream().forEach(System.out::println);

        Stream<String> flatMap = courses.stream().flatMap(s->s.stream());
        flatMap.forEach(System.out::println);
    }
}


class Employee{
    String name;
    int age;
    double salary;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
}
