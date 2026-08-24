package org.tnsif.acc.c2tc.streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AllIntermediateOps {
    public static void main(String[] args) {
        // Initial list of numbers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 5, 6, 7, 8, 9);

        // 1. map: multiply each number by 2
        List<Integer> doubled = numbers.stream().map(n -> n * 2).collect(Collectors.toList());
        System.out.println("Doubled " + doubled);

        // 2. filter: keep only even numbers
        List<Integer> evens = numbers.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
        System.out.println("After filter " + evens);

        // 3. distinct: remove duplicates
        List<Integer> uniqueNumbers = numbers.stream().distinct().collect(Collectors.toList());
        System.out.println("After Distinct " + uniqueNumbers);

        // 4. limit(5): take only the first 5 elements
        List<Integer> limitedNumbers = numbers.stream().limit(5).collect(Collectors.toList());
        System.out.println("Limited number " + limitedNumbers);

        // 5. sorted: sort the elements (ascending)
        List<Integer> sortedData = numbers.stream().sorted().collect(Collectors.toList());
        System.out.println("Sorted data " + sortedData);

        // 6. skip(2): skip the first 2 elements
        List<Integer> skipped = numbers.stream().skip(2).collect(Collectors.toList());
        System.out.println("Skipped data " + skipped);
    }
}
