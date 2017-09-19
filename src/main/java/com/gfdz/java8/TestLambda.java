package com.gfdz.java8;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class TestLambda {
    public static void main(String[] args) {
        List<Integer> numbers= Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        numbers.stream()
                .filter(e->e%2==0)
                .forEach(System.out::println);
    }
    public int increment(int number) {
        return number + 1;
    }
}
