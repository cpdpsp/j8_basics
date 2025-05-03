package com.jeight.baiscs.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupByDemo {

    public static void main(String[] args) {

        GpEmployee e1 = new GpEmployee(1,"Robert",26500.00,"USA");
        GpEmployee e2 = new GpEmployee(2,"Abrahm",46500.00,"INDIA");
        GpEmployee e3 = new GpEmployee(3,"Chen",36500.00,"CHINA");
        GpEmployee e4 = new GpEmployee(4,"David",16500.00,"INDIA");
        GpEmployee e5 = new GpEmployee(5,"Cathy",25500.00,"USA");

        List<GpEmployee> GpEmployeeeesList = Arrays.asList(e1,e2,e3,e4,e5);

        System.out.println("==========Group by=============");
        Map<String, List<GpEmployee>> collect = GpEmployeeeesList.stream().collect(Collectors.groupingBy(e -> e.country));
        System.out.println("Group by country "+collect);
    }
}

class GpEmployee {
    int id;
    String name;
    double salary;
    String country;

    public GpEmployee(int id, String name, double salary,String country){
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.country = country;
    }

    @Override
    public String toString() {
        return "GpEmployeeee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", country='" + country + '\'' +
                '}';
    }
}
