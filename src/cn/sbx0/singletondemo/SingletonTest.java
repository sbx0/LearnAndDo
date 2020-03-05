package cn.sbx0.singletondemo;

import java.util.concurrent.*;

public class SingletonTest {
    public static void main(String[] args) {
        SingletonHungryMan singletonHungryMan = SingletonHungryMan.INSTANCE; // 1.5之前
        System.out.println(singletonHungryMan);
        SingletonHungryManEnum singletonEnum = SingletonHungryManEnum.INSTANCE; // 1.5之后
        System.out.println(singletonEnum);
        SingletonHungryManStaticCodeBlock singletonStaticCodeBlock = SingletonHungryManStaticCodeBlock.INSTANCE;
        System.out.println(singletonStaticCodeBlock);
        // -----
        Callable<SingletonLazyManUnsafe> callableUnsafe = SingletonLazyManUnsafe::getInstance;
        ExecutorService executorServiceUnsafe = Executors.newFixedThreadPool(2);
        Future<SingletonLazyManUnsafe> futureUnsafe1 = executorServiceUnsafe.submit(callableUnsafe);
        Future<SingletonLazyManUnsafe> futureUnsafe2 = executorServiceUnsafe.submit(callableUnsafe);
        try {
            SingletonLazyManUnsafe singletonLazyManUnsafe1 = futureUnsafe1.get();
            SingletonLazyManUnsafe singletonLazyManUnsafe2 = futureUnsafe2.get();
            System.out.println(singletonLazyManUnsafe1 == singletonLazyManUnsafe2);
            System.out.println(singletonLazyManUnsafe1);
            System.out.println(singletonLazyManUnsafe2);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        executorServiceUnsafe.shutdown();
        // -----
        Callable<SingletonLazyManSafe> callableSafe = SingletonLazyManSafe::getInstance;
        ExecutorService executorServiceSafe = Executors.newFixedThreadPool(2);
        Future<SingletonLazyManSafe> futureSafe1 = executorServiceSafe.submit(callableSafe);
        Future<SingletonLazyManSafe> futureSafe2 = executorServiceSafe.submit(callableSafe);
        try {
            SingletonLazyManSafe singletonLazyManSafe1 = futureSafe1.get();
            SingletonLazyManSafe singletonLazyManSafe2 = futureSafe2.get();
            System.out.println(singletonLazyManSafe1 == singletonLazyManSafe2);
            System.out.println(singletonLazyManSafe1);
            System.out.println(singletonLazyManSafe2);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        executorServiceSafe.shutdown();
        // -----
    }
}
