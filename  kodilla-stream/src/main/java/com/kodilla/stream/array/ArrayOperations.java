package com.kodilla.stream.array;

import java.lang.reflect.Array;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public interface ArrayOperations {

    static double getAverage(int[] numbers){
        IntStream.range(0,numbers.length)
                 .forEach(System.out::println);

        double average = IntStream.range(0,numbers.length)
                .map(n -> numbers[n])
                .average()
                .orElse(-0.0)
                ;
        return average;
    };
}
