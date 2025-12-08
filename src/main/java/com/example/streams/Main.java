package com.example.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {


    static boolean areAllEven(Stream<Integer> stream) {
        // write code here
        return stream.allMatch(i -> i % 2 == 0);
    }


    public static void main(String[] args) {
        List<Integer> ls = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 8, 9, 9);


        // second largest distinct no
        int no = ls.stream().distinct().sorted((a, b) -> b.compareTo(a)).skip(1).findFirst().orElse(0);
        System.out.println(no);

        // count how many are prime nos
        long count = ls.stream().filter(i -> i % 2 != 0).count();
        System.out.println(count);

        // return all values that are more than once
        List<Integer> nos = ls.stream()
                .collect(Collectors.groupingBy(
                        (i) -> i,
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .filter(i -> i.getValue() > 1)
                .map(i -> i.getKey())
                .collect(Collectors.toList());

        System.out.println(nos);
    }
}
