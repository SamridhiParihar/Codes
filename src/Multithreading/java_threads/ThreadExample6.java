package Multithreading.java_threads;

public class ThreadExample6 {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                String threadName = Thread.currentThread().getName();
                System.out.println(threadName+ " is Running !");
                System.out.println("......");
                System.out.println(threadName+ "Thread Ended");
            }
        };

        Thread thread1 = new Thread(runnable,"My thread 1");
        Thread thread2 = new Thread(runnable, "My thread 2");
        thread1.start();

    }
}
