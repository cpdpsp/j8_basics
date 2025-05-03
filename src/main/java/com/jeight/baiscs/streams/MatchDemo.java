package com.jeight.baiscs.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MatchDemo {
    public static void main(String[] args) {
        Person p1 = new Person("John","USA");
        Person p2 = new Person("Steve","INDIA");
        Person p3 = new Person("Ashok","INDIA");
        Person p4 = new Person("Chen","CHINA");

        List<Person> persons = Arrays.asList(p1,p2,p3,p4);
        boolean status;
        System.out.println("=========any match============");
        status = persons.stream().anyMatch(person -> person.country.equals("CHINA"));
        System.out.println("Any chinese available? "+status);

        System.out.println("=========all match============");
        status = persons.stream().allMatch(person -> person.country.equals("INDIA"));
        System.out.println("Is everyone from India? "+status);

        System.out.println("=========none match============");
        status = persons.stream().noneMatch(person -> person.country.equals("MEXICO"));
        System.out.println("Is no one from Mexico? "+status);

        System.out.println("=========any Indian available then print first person found======");
        Optional<Person> result = persons.stream().filter(person -> person.country.equals("INDIA")).findFirst();
        if(result.isPresent()){
            System.out.println("First Indian from the list"+result.get());
        }

        System.out.println("=========any Indian available then print any person found======");
        result = persons.stream().filter(person -> person.country.equals("INDIA")).findAny();
        result.ifPresent(person -> System.out.println("Any Indian from the list" + person));

        System.out.println("============Get all Indians in a collection==================");
        List<Person> personArrayList = persons.stream().filter(person -> person.country.equals("INDIA")).toList();
        System.out.println("Size of list::"+personArrayList.size());

        System.out.println("=========Collect name of person who belong to India in a collection=========");
        List<String> personName = persons.stream().filter(person -> person.country.equals("INDIA")).map(person -> person.name).toList();
        System.out.println("Size of list::"+personName.size());
    }
}

class Person {
    String name;
    String country;

    public Person(String name, String country) {
        this.name = name;
        this.country = country;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
