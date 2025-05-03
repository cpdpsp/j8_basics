package com.jeight.baiscs.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FilterDemo {

    public static void main(String[] args){
        List<Integer> input = Arrays.asList(12,65,9,98,76,9);
        input.stream().filter(i->i>20).forEach(i->System.out.println(i));

        List<String> names = Arrays.asList("Ashok","shok","ANu","hok","ok");
        names.stream().filter(i->i.startsWith("A")).forEach(System.out::println);

        User u1 = new User("Sunidhi",10);
        User u2 = new User("iwert",13);
        User u3 = new User("slkmn",78);
        User u4 = new User("uhdf",45);
        Stream<User> stream = Stream.of(u1,u2,u3,u4);
        stream.filter(user -> user.age>15 && user.name.startsWith("s")).forEach(System.out::println);
    }
}

class User{
    String name;
    int age;
    User(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User [name="+name+", age="+age+"]";
    }
}