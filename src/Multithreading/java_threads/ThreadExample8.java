package Multithreading.java_threads;

public class ThreadExample8 {
    public static void main(String[] args) {
        Runnable runnable=()->{
            while (true){
                sleep(1000);
                System.out.println("Running");
            }
        };
        Thread thread = new Thread(runnable); // if you don't want to keep this thread running even after main thread terminates then mark it as deamon thread
        thread.setDaemon(true);
        thread.start();
        sleep(3100);
    }
    public static void sleep(long millis){
        try{
            Thread.sleep(millis);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
