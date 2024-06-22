package MultiThreading.task2;

import static java.lang.Thread.sleep;

public class Main {
    public static volatile boolean switcher;
    public static boolean work = true;
    public static int res = 100;


    public static void isSwitcher() {
        if (switcher) {
            switcher = false;
            return;
        }
        switcher = true;
    }

    public static void main(String[] args) {
        Thread threadA = new Thread( () ->{
            while (work) {
                isSwitcher();
//                System.out.println(switcher);
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
//                System.out.println("Thread A");
            }
        });
        Thread threadB = new Thread(() -> {
            while (res > 0) {
                if (switcher == true) {
                    System.out.println(res--);
                    try {
                        sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            work = false;
        });

        threadA.start();
        threadB.start();

    }
}
