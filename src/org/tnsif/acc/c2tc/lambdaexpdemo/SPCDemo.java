package org.tnsif.acc.c2tc.lambdaexpdemo;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class SPCDemo {
    public static void main(String[] args) {
        // Supplier: no input, returns a value
        Supplier<String> supplier = () -> "Hello from Cambridge";
        String supplierValue = supplier.get();
        System.out.println(supplierValue);

        // Predicate: takes one input, returns a boolean
        Predicate<Integer> eligible = (salary) -> salary >= 30000;
        System.out.println(eligible.test(40000));

        // Consumer: takes one input, returns nothing
        Consumer<String> consumer = message -> System.out.println("consumer received " + message);
        consumer.accept("This is test message");
    }
}
