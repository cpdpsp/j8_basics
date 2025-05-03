package com.jeight.baiscs.streams;

import java.util.Arrays;
import java.util.List;

public class SliceDemo {

    public static void main(String[] args) {
        List<String> javaCourses = Arrays.asList("coreJava","advJava","springboot","restapi","microservice","restapi");
        System.out.println("==============limit==============");
        javaCourses.stream().limit(3).forEach(System.out::println);
        System.out.println("==============skip==============");
        javaCourses.stream().skip(3).forEach(System.out::println);
        System.out.println("==============distinct==============");
        javaCourses.stream().distinct().forEach(System.out::println);
    }
}
