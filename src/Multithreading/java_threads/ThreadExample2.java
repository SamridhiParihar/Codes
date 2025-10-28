package Multithreading.java_threads;

public class ThreadExample2 {
    public static class MyThread implements Runnable {
        @Override
        public void run(){
            System.out.println("My Thread is running !");
            System.out.println(".......");
            System.out.println("My Thread finished execution ");
        }
    }

    public static void main(String[] args) {
        Thread thread  = new Thread(new MyThread());
        thread.start();
    }
}
