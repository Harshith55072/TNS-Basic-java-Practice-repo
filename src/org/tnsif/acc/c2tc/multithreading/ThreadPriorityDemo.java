package org.tnsif.acc.c2tc.multithreading;

// Demonstrates thread priority - a HINT to the thread scheduler about which
// threads should get more CPU time. It's not a guarantee: the actual order
// still depends on the OS scheduler, so don't rely on this for correctness.
public class ThreadPriorityDemo {
    public static void main(String[] args) {
        Thread lowPriority = new Thread(() -> {
            for (int i = 1; i <= 3; i++) {
                System.out.println("Low priority thread: " + i);
            }
        });

        Thread highPriority = new Thread(() -> {
            for (int i = 1; i <= 3; i++) {
                System.out.println("High priority thread: " + i);
            }
        });

        lowPriority.setPriority(Thread.MIN_PRIORITY);   // 1
        highPriority.setPriority(Thread.MAX_PRIORITY);  // 10

        lowPriority.start();
        highPriority.start();
    }
}
