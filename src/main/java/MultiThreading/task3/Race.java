package MultiThreading.task3;

import java.util.concurrent.CountDownLatch;

public class Race {
    public void race() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(4);
        for (int i = 0; i < 3; i++) {
            Runner runner = new Runner("Runner " + (i+1), latch);
            runner.start();
        }

        while (latch.getCount() != 1) {
            Thread.sleep(100);
        }
        gogogo();
        latch.countDown();


    }
    private static void gogogo(){
        try {
            System.out.println("На Старт");
            Thread.sleep(500);
            System.out.println("Внимание");
            Thread.sleep(1000);
            System.out.println("МАРШ!!!!");

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
