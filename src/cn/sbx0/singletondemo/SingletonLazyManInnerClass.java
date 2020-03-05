package cn.sbx0.singletondemo;

/**
 * 在内部类被加载和初始化时才创建
 * 静态内部类不会自动随着外部类的加载和初始化而初始化，它是要单独去加载和初始化的
 * 因为是在内部类加载和初始化时创建的，所以是线程安全的
 */
public class SingletonLazyManInnerClass {

    private SingletonLazyManInnerClass() {
    }

    private static class InnerClass {
        private static final SingletonLazyManInnerClass INSTANCE = new SingletonLazyManInnerClass();
    }

    public static SingletonLazyManInnerClass getInstance() {
        return InnerClass.INSTANCE;
    }
}
