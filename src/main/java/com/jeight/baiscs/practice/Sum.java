package com.jeight.baiscs.practice;

import java.util.Arrays;

public class Sum {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        //reducing multiple values to single value
        int sum = Arrays.stream(nums).reduce(0, (a, b) -> a + b);
        System.out.println("Sum is:: "+sum);
    }
}
