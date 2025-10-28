package Multithreading.java_threads;

public class ThreadExample1 {
    public static class MyThread extends  Thread{
        @Override
        public void run(){
            System.out.println("My Thread is running !");
            System.out.println(".......");
            System.out.println("My Thread finished execution ");
        }
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
//        Thread thread = new Thread(myThread);
//        thread.start();
        myThread.start();
    }
}
