package cn.sbx0.singletondemo;

/**
 * 懒汉式（线程不安全）：
 * 延迟创建这个实例对象
 * 1.构造器私有化
 * 2.用一个静态变量保存这个唯一的实例
 * 3.提供一个静态的方法，获取这个静态实例
 */
public class SingletonLazyManUnsafe {
    private static SingletonLazyManUnsafe instance;

    private SingletonLazyManUnsafe() {
    }

    public static SingletonLazyManUnsafe getInstance() {
        if (instance == null) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new SingletonLazyManUnsafe();
        }
        return instance;
    }
}
