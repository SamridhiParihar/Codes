package Multithreading.java_threads;

public class ThreadExample3 {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run(){
                System.out.println("My Thread is running !");
                System.out.println(".......");
                System.out.println("My Thread finished execution ");
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
