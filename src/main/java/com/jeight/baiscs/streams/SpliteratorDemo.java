package com.jeight.baiscs.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;

public class SpliteratorDemo {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("sachin","sehwag","dhoni");
        Spliterator<String> spliterator = names.stream().spliterator();
        spliterator.forEachRemaining(System.out::println);
    }

}
