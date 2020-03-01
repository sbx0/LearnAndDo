import java.util.concurrent.TimeUnit;

class DataStorage {
    volatile int number = 0;

    public void to100() {
        this.number = 100;
    }
}

public class VolatileDemo {
    public static void main(String[] args) {
        DataStorage dataStorage = new DataStorage();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t is start.");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            dataStorage.to100();
            System.out.println(Thread.currentThread().getName() + "\t update number value = " + dataStorage.number);
        }, "thread-no-1").start();
        while (dataStorage.number == 0) {}
        System.out.println(Thread.currentThread().getName() + "\t get number = " + dataStorage.number + " end.");
    }
}