package com.jeight.baiscs.practice;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.stream.Collectors;

public class PracticeQ {

    public static void main(String[] args) {
        List<PEmployee> emps = new ArrayList<>();
        emps.add(new PEmployee(1, "Jhansi", 32, "Female", "HR", 2011, 25000.0));
        emps.add(new PEmployee(2, "Smith", 25, "Male", "Sales", 2015, 13500.0));
        emps.add(new PEmployee(3, "David", 29, "Male", "Infrastructure", 2012, 18000.0));
        emps.add(new PEmployee(4, "Orlen", 28, "Male", "Development", 2014, 32500.0));
        emps.add(new PEmployee(5, "Charles", 27, "Male", "HR", 2013, 22700.0));
        emps.add(new PEmployee(6, "Cathy", 43, "Male", "Security", 2016, 10500.0));
        emps.add(new PEmployee(7, "Ramesh", 35, "Male", "Finance", 2010, 27000.0));
        emps.add(new PEmployee(8, "Suresh", 31, "Male", "Development", 2015, 34500.0));
        emps.add(new PEmployee(9, "Gita", 24, "Female", "Sales", 2016, 11500.0));
        emps.add(new PEmployee(10, "Mahesh", 38, "Male", "Security", 2015, 11000.5));
        emps.add(new PEmployee(11, "Gouri", 27, "Female", "Infrastructure", 2014, 15700.0));
        emps.add(new PEmployee(12, "Nithin", 25, "Male", "Development", 2016, 28200.0));
        emps.add(new PEmployee(13, "Swathi", 27, "Female", "Finance", 2013, 21300.0));
        emps.add(new PEmployee(14, "Buttler", 24, "Male", "Sales", 2017, 10700.7));
        emps.add(new PEmployee(15, "Ashok", 23, "Male", "Infrastructure", 2018, 12700.0));
        emps.add(new PEmployee(16, "Sanvi", 26, "Female", "Development", 2015, 28900.0));

        System.out.println("Q1. How many male and female employees are there in the organization?");
        Map<String, Long> mapCount = emps.stream().collect(Collectors.groupingBy(PEmployee::getGender, Collectors.counting()));
        System.out.println("PracticeQ1:: " + mapCount);
        System.out.println("################################################################################################");

        System.out.println("Q2. Print the name of all departments in the organization");
        emps.stream().map(e -> e.getDepartment()).distinct().forEach(System.out::println);
        System.out.println("################################################################################################");

        System.out.println("Q3. What is the average age of male and female employees?");
        Map<String, Double> avgAgeMap = emps.stream().collect(Collectors.groupingBy(PEmployee::getGender, Collectors.averagingInt(PEmployee::getAge)));
        System.out.println("PracticeQ3:: "+avgAgeMap);
        System.out.println("################################################################################################");

        System.out.println("Q4. Get the details of highest paid employee in the organization");
        Optional<PEmployee> highestSalary = emps.stream().max(Comparator.comparing(PEmployee::getSalary));
        highestSalary.ifPresent(pEmployee -> System.out.println("PracticeQ4:: " + pEmployee));
        System.out.println("################################################################################################");

        System.out.println("Q5. Get the names of all employees who have joined after 2015");
        emps.stream().filter(e->e.getYearOfJoining()>2015).map(PEmployee::getName).forEach(System.out::println);
        System.out.println("################################################################################################");

        System.out.println("Q6. Count the number of employees in each department");
        Map<String,Long> countEmpMap = emps.stream().collect(Collectors.groupingBy(PEmployee::getDepartment,Collectors.counting()));
        System.out.println("PracticeQ6:: "+countEmpMap);
        System.out.println("################################################################################################");

        System.out.println("Q7. What is the average salary of each department");
        Map<String,Double> avgSalaryMap = emps.stream().collect(Collectors.groupingBy(PEmployee::getDepartment,Collectors.averagingDouble(PEmployee::getSalary)));
        System.out.println("PracticeQ7:: "+avgSalaryMap);
        System.out.println("################################################################################################");

        System.out.println("Q8. Get the details of the youngest male employee in the Development department");
        Optional<PEmployee> youngestME = emps.stream().filter(e->e.getGender().equals("Male") && e.getDepartment().equals("Development")).min(Comparator.comparing(PEmployee::getAge));
        youngestME.ifPresent(System.out::println);
        System.out.println("################################################################################################");

        System.out.println("Q9. Who has the most working experience in the organization?");
        Optional<PEmployee> maxExp = emps.stream().min(Comparator.comparing(PEmployee::getYearOfJoining));
        maxExp.ifPresent(System.out::println);
        System.out.println("################################################################################################");

        System.out.println("Q10. How many male and female employees are there in the Sales team?");
        Map<String,Long> salesCounting = emps.stream().filter(e->e.getDepartment().equals("Sales")).collect(Collectors.groupingBy(PEmployee::getGender,Collectors.counting()));
        System.out.println("PracticeQ10:: "+salesCounting);
        System.out.println("################################################################################################");

        System.out.println("Q11. What is the average salary of male and female employees?");
        Map<String, Double> avgSalary = emps.stream().collect(Collectors.groupingBy(PEmployee::getGender, Collectors.averagingDouble(PEmployee::getSalary)));
        System.out.println("PracticeQ11:: "+avgSalary);
        System.out.println("################################################################################################");

        System.out.println("Q12. List down the names of all employees in each department");
        Map<String, List<PEmployee>> listByDepartment = emps.stream().collect(Collectors.groupingBy(PEmployee::getDepartment));
        System.out.println("Practice12:: "+listByDepartment);
        System.out.println("################################################################################################");

        System.out.println("Q13. What is the average salary and total salary of the whole organizarion?");
        Double avgSalaryOfOrganization = emps.stream().collect(Collectors.averagingDouble(PEmployee::getSalary));
        System.out.println("Practice13:: "+avgSalaryOfOrganization);
        Double totalSalaryOfOrganization = emps.stream().collect(Collectors.summingDouble(PEmployee::getSalary));
        System.out.println("Practice13:: "+totalSalaryOfOrganization);
        System.out.println("################################################################################################");

        System.out.println("Q14. Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years");
        Map<Boolean, List<PEmployee>> partition = emps.stream().collect(Collectors.partitioningBy(e -> e.getAge() > 25));
        System.out.println("Practice14:: "+partition);
        System.out.println("################################################################################################");

        System.out.println("Q15. Who is the oldest employee in the organization? What is his age and which department he belongs to?");
        Optional<PEmployee> oldestEmp = emps.stream().max(Comparator.comparing(PEmployee::getAge));
        oldestEmp.ifPresent(e->System.out.println("Age::"+e.getAge()+" department:: "+e.getDepartment()));
        System.out.println("################################################################################################");

        System.out.println("Q16. Employee with the second highest salary");
        Optional<PEmployee> secondHighestSalary = emps.stream().sorted(Comparator.comparing(PEmployee::getSalary).reversed()).skip(1).findFirst();
        secondHighestSalary.ifPresent(System.out::println);
        List<PEmployee> secondHighestSalaryList = emps.stream().sorted(Comparator.comparing(PEmployee::getSalary).reversed()).collect(Collectors.toList());
        System.out.println("PracticeQ16:: "+secondHighestSalaryList.get(1));
        System.out.println("################################################################################################");

    }
}
