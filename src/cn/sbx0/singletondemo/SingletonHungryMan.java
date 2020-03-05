package cn.sbx0.singletondemo;

/**
 * 饿汉式：
 * 直接创建对象，不管你是不是使用这个对象
 * 1.构造器私有化
 * 2.自行创建并用静态变量保存
 * 3.向外提供这个实例
 * 4.强调这是个单例，可以用final修饰
 */
public class SingletonHungryMan {
    public static final SingletonHungryMan INSTANCE = new SingletonHungryMan();

    private SingletonHungryMan() {
    }

    // 可以直接通过类名调用这个方法
    public static void staticFunction() {
        // 直接创建对象，不管你是不是使用这个对象
    }
}
