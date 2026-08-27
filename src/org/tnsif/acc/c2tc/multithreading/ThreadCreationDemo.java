package org.tnsif.acc.c2tc.multithreading;

// Way 1 of creating a thread: extend the Thread class and override run()
class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " - count: " + i);
        }
    }
}

public class ThreadCreationDemo {
    public static void main(String[] args) {
        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();

        thread1.start(); // starts a new thread, runs concurrently with main
        thread2.start();
    }
}
