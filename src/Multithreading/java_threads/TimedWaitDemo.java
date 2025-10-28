package Multithreading.java_threads;

class TimerExample {
    synchronized void waitWithTimeout() {
        try {
            System.out.println("Waiting for 3 seconds...");
            wait(3000);  // wait for up to 3 seconds
            System.out.println("Woke up (either notified or timeout)");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    synchronized void notifyBeforeTimeout() {
        try {
            Thread.sleep(1000); // Give time for the other thread to start and wait
            System.out.println("Thread " + Thread.currentThread().getName() + " is notifying...");
            notify(); // Wakes up the waiting thread
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class TimedWaitDemo {
    public static void main(String[] args) {
        TimerExample obj = new TimerExample();

        // Thread that will wait
        Thread waitingThread = new Thread(obj::waitWithTimeout, "WaitingThread");

        // Thread that will notify before timeout
        Thread notifierThread = new Thread(obj::notifyBeforeTimeout, "NotifierThread");

        waitingThread.start();
        notifierThread.start();

    }
}
