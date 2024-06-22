package MultiThreading.task1;

public class Main {
    public static void main(String[] args) {
        Object objectA = new Object();
        Object objectB = new Object();

        Thread threadA = new Thread(() -> {
            synchronized (objectA) {
                System.out.println("Thread A acquired objectA");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (objectB) {
                    System.out.println("Thread A acquired objectB");
                }
            }
        });

        Thread threadB = new Thread(() -> {
            synchronized (objectB) {
                System.out.println("Thread B acquired objectB");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (objectA) {
                    System.out.println("Thread B acquired objectA");
                }
            }
        });
        threadA.start();
        threadB.start();
    }
}
