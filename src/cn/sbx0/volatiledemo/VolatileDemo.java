package cn.sbx0.volatiledemo;

import java.util.concurrent.TimeUnit;

class DataStorage {
    volatile int number = 0;

    public void to100() {
        this.number = 100;
    }

    public synchronized void click() {
        this.number++;
    }
}

public class VolatileDemo {
    // volatile 不保证原子性
    public static void volatileDontSupportAtomicity() {
        DataStorage dataStorage = new DataStorage();
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t is start.");
                for (int j = 0; j < 1000; j++) {
                    dataStorage.click();
                }
            }, "thread-no-" + i).start();
        }
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName() + "\t result = " + dataStorage.number);
    }

    // volatile 可见性
    public static void volatileVisibility() {
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
        while (dataStorage.number == 0) {
        }
        System.out.println(Thread.currentThread().getName() + "\t get number = " + dataStorage.number + " end.");
    }
}