package org.tnsif.acc.c2tc.multithreading;

// Demonstrates why synchronized matters: two threads incrementing a shared
// counter without synchronization can produce a wrong final result, because
// they can both read the same value before either writes it back (a race condition).
class Counter {
    private int count = 0;

    // "synchronized" ensures only one thread can execute this method at a
    // time on this object, preventing the race condition described above.
    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

public class SynchronizationDemo {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Runnable incrementTask = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        };

        Thread thread1 = new Thread(incrementTask);
        Thread thread2 = new Thread(incrementTask);

        thread1.start();
        thread2.start();

        thread1.join(); // wait for thread1 to finish
        thread2.join(); // wait for thread2 to finish

        // With synchronized in place, this reliably prints 2000.
        // Removing "synchronized" from increment() can make this print a
        // smaller, inconsistent number due to the race condition.
        System.out.println("Final count: " + counter.getCount());
    }
}
