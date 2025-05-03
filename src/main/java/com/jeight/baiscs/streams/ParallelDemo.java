package com.jeight.baiscs.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Stream;

public class ParallelDemo {
    public static void main(String[] args) {
        System.out.println("=======Serial stream========");
        Stream<Integer> searialStream = Stream.of(1,2,3,4);
        searialStream.forEach(n -> System.out.println(n+ " :: "+Thread.currentThread()));
        System.out.println("=======Parallel stream========");
        Stream<Integer> parallelStream = Stream.of(1,2,3,4,5,6);
        parallelStream.parallel().forEach(n->System.out.println(n +" :: "+Thread.currentThread()));
        List<String> names = Arrays.asList("sachin","sehwag","dhoni");
        Spliterator<String> spliterator = names.stream().spliterator();
        spliterator.forEachRemaining(n->System.out.println(n));
    }
}
