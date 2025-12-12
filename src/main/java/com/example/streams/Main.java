package com.example.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
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

        List<Integer> l1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        // Given a list of numbers, take the even and square them -> FILTERING AND MAPPING
        List<Integer> evenSquares = l1.stream() //creates the stream
                .filter((n) -> n % 2 == 0)   // filters odd and even numbers || intermediate
                .map((n) -> n * n) // squares the numbers || intermediate
                .collect(Collectors.toList()); // collecting stream to a list || terminal
        System.out.println(evenSquares);

        // Given a list of numbers, find their sum || REDUCTION
        int sum = l1.stream()
                .reduce(0, (prev, i) -> prev + i);
        System.out.println(sum);

        List<Employee> employees = Arrays.asList(
                new Employee("Raju", 10000, "IT"),
                new Employee("Ashwin", 20000, "HR"),
                new Employee("Aditya", 25000, "IT"),
                new Employee("Taahaa", 17000, "HR"),
                new Employee("Arpit", 35000, "MANAGEMENT")
        );

        // Find the name of employees earning more than 18000
        List<String> empNames = employees.stream()
                .filter((emp) -> emp.salary > 18000)
                .map((emp) -> emp.name)
                .collect(Collectors.toList());
        System.out.println(empNames);

        // Create a map of an employee department with any employee from that department || Map<String, String>
        Map<String, String> deptMap = employees.stream()
                .collect(Collectors.groupingBy(
                        (emp) -> emp.dept,
                        Collectors.mapping((emp) -> emp.name,
                                Collectors.reducing("", (prev, b) -> {
                                    if (prev == null || prev.isEmpty()) {
                                        return b;
                                    }
                                    return prev;
                                }))
                ));
        System.out.println(deptMap);

        // Group the employee names by their departments || Map<String, List<String>> < IT, <E1, E2>>
        Map<String, List<String>> empDeptMap = employees.stream()
                .collect(Collectors.groupingBy(
                        (emp) -> emp.dept, // generating the key entry
                        Collectors.mapping((emp) -> emp.name,
                                Collectors.toList()
                        )  // generating the value entry
                ));
        System.out.println(empDeptMap);

        // generating a flat map
        List<List<Integer>> nestedList = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7)
        );

        List<Integer> flatList = nestedList.stream()
                .flatMap((list) -> list.stream())
                .collect(Collectors.toList());
        System.out.println(flatList);
    }
}
