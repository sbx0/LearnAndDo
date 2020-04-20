package cn.sbx0.atomic;

import java.util.concurrent.atomic.*;

public class AtomicTest {
    public static AtomicReference<User> atomicReference = new AtomicReference<>();
    private static final AtomicIntegerFieldUpdater<User> atomicIntegerFieldUpdater = AtomicIntegerFieldUpdater.newUpdater(User.class, "id");


    public static void main(String[] args) {
        System.out.println("-\t-AtomicInteger-\t-");
        AtomicInteger atomicInteger = new AtomicInteger(1);
        System.out.println(atomicInteger.getAndIncrement());
        System.out.println(atomicInteger.get());
        atomicInteger.compareAndSet(2, 1);
        System.out.println(atomicInteger.get());
        System.out.println(atomicInteger.getAndSet(4));
        System.out.println(atomicInteger.get());

        System.out.println("-\tAtomicBoolean\t-");
        AtomicBoolean atomicBoolean = new AtomicBoolean();

        System.out.println("-\tAtomicIntegerArray\t-");
        int[] ints = new int[]{1, 2, 3, 4};
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(ints);
        System.out.println(atomicIntegerArray);
        atomicIntegerArray.getAndSet(0, 4);
        System.out.println(atomicIntegerArray.get(0));
        System.out.println(ints[0]);

        System.out.println("-\tAtomicReference\t-");
        User user = new User(1, "Test");
        atomicReference.set(user);
        User updateUser = new User(1, "Admin");
        atomicReference.compareAndSet(user, updateUser);
        System.out.println(atomicReference.get().getId());
        System.out.println(atomicReference.get().getName());

        System.out.println("-\tAtomicIntegerFieldUpdater\t-");
        User conan = new User(1, "Test");
        System.out.println(atomicIntegerFieldUpdater.getAndIncrement(conan));
        System.out.println(atomicIntegerFieldUpdater.get(conan));

    }

    static class User {
        public volatile int id;
        private String name;

        public User(Integer id, String name) {
            this.id = id;
            this.name = name;
        }

        public Integer getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }
}
