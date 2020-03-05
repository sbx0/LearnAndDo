package cn.sbx0.singletondemo;

public class SingletonTest {
    public static void main(String[] args) {
        SingletonHungryMan singletonHungryMan = SingletonHungryMan.INSTANCE; // 1.5之前
        SingletonEnum singletonEnum = SingletonEnum.INSTANCE; // 1.5之后
    }
}
