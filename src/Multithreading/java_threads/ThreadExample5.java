package Multithreading.java_threads;

public class ThreadExample5 {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                String threadName = Thread.currentThread().getName();
                System.out.println(threadName+ " is Running !");
                System.out.println("......");
                System.out.println(threadName+ " Thread Ended");
            }
        };

        Thread thread = new Thread(runnable, "My Thread");
        thread.start();
    }
}
