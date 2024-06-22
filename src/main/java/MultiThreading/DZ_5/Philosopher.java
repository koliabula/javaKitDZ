package MultiThreading.DZ_5;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Philosopher extends Thread {
    private String name;
    private int  leftFork;
    private int rightFork;
    private CountDownLatch cdl;
    private Controller controller;
    private int eatCount;

    public Philosopher(String name, Controller controller, int leftFork, int rightFork, CountDownLatch cdl) {
        this.name = name;
        this.controller = controller;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.cdl = cdl;
        eatCount = 0;
    }

    public void run() {
        try {
            sleep(new Random().nextInt(1500, 3000));
            eat(this);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void eat(Philosopher philosopher) throws InterruptedException {
        while (eatCount < 3) {
            if (controller.trueForks(leftFork, rightFork)) {
                System.out.println(name + " кушаю вилками " + leftFork + " и " + rightFork);

                sleep(new Random().nextInt(2000, 5000));

                controller.falseForks(leftFork, rightFork);
                System.out.println(name + " покушал вилками " + leftFork + " и " + rightFork);
                eatCount++;
            }
        }

    }
}

