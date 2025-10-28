package Multithreading.java_threads;

public class JoinExample {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println("Thread t1: Started");
            try {
                Thread.sleep(2000); // Simulating some work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread t1: Finished");
        });

        Thread t2 = new Thread(() -> {
            System.out.println("Thread t2: Waiting for t1 to complete...");
            try {
                t1.join(); // t2 waits for t1 to finish
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread t2: Now running after t1 is done");
        });

        t1.start();
        t2.start();
    }
}

