package Multithreading.java_threads;
public class WaitNotifyExample {
    static class SharedResource {
        private boolean ready = false;

        synchronized void produce() {
            System.out.println("Producing data...");
            ready = true;
            notify(); // Notify the waiting thread
        }

        synchronized void consume() {
            while (!ready) {
                try {
                    System.out.println("Waiting for data...");
                    wait(); // Block and wait until notified
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Data consumed!");
        }
    }

    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        Thread consumer = new Thread(resource::consume);
        Thread producer = new Thread(() -> {
            try {
                Thread.sleep(2000); // simulate delay
                resource.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        consumer.start();
        producer.start();
    }
}



