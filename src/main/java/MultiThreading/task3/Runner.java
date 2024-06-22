package MultiThreading.task3;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Runner extends Thread  {
    private String name;
    CountDownLatch latch;

    public Runner(String name , CountDownLatch latch  ) {
        this.name = name;
        this.latch = latch;

    }

    @Override
    public void run() {
        try {
            goToStart();
            latch.countDown();
            latch.await();
            goToFinish();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void goToStart() throws InterruptedException {
        System.out.println(name + "Движется к старту");
        sleep(new Random().nextLong(1000, 3000));
        System.out.println(name + " Прибежал к старту");
    }

    public void goToFinish() throws InterruptedException {
        System.out.println(name + " Движется к финишу");
        sleep(new Random().nextLong(1000, 3000));
        System.out.println(name + " Прибежал к финишу");
    }
}
