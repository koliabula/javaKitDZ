package MultiThreading.task3;

public class Main {
    public static void main(String[] args) {
        Race race = new Race();
        try {
            race.race();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
