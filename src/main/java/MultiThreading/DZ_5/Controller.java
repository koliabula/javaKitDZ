package MultiThreading.DZ_5;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Controller extends Thread  {
    private static final int N = 5;
    private List<Philosopher> philosophers;
    private List<Fork> forks;
    CountDownLatch cdl;

    public void init(){
        cdl = new CountDownLatch(N);
        philosophers = new ArrayList<>(N);
        forks = new ArrayList<>(N);

        for (int i = 0; i < N; i++) {
            forks.add(new Fork());
        }

        for (int i = 0; i < N; i++) {
            if (i == N - 1) {
                philosophers.add(new Philosopher("Phil " + (i+1),this,  i, 0, cdl));
            } else{
                philosophers.add(new Philosopher("Phil " + (i+1),this, i, i + 1, cdl));
            }
        }
    }

    public void run(){
        init();
        try {
            for (Philosopher philosopher : philosophers) {
            philosopher.start();
            }
            cdl.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public synchronized boolean trueForks(int leftFork, int rightFork) {
        if (forks.get(leftFork).getFree() && forks.get(leftFork).getFree()) {
            forks.get(leftFork).setFree(false);
            forks.get(rightFork).setFree(false);
            return true;
        }
        return false;
    }

    public void falseForks(int leftFork, int rightFork) {
        forks.get(leftFork).setFree(true);
        forks.get(rightFork).setFree(true);
    }
}
