package org.tnsif.acc.c2tc.multithreading;

// Way 2 of creating a thread: implement Runnable and pass it to a Thread.
// Preferred over extending Thread since Java doesn't support multiple
// inheritance - implementing Runnable leaves the class free to extend
// something else if needed.
class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " - count: " + i);
        }
    }
}

public class RunnableDemo {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyRunnable(), "Thread-A");
        Thread thread2 = new Thread(new MyRunnable(), "Thread-B");

        thread1.start();
        thread2.start();
    }
}
