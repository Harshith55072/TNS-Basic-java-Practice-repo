package org.tnsif.acc.c2tc.multithreading;

// Demonstrates Thread.sleep() - pausing a thread's execution for a set time.
public class ThreadSleepDemo {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Tick " + i);
            Thread.sleep(1000); // pause for 1000 ms (1 second) before the next tick
        }
        System.out.println("Done!");
    }
}
