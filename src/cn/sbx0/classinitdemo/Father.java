package cn.sbx0.classinitdemo;

/**
 * 非静态方法前面其实有一个默认的对象this，
 * this在构造器（或<init>()）中它表示的是
 * 正在创建的对象。
 * 因为这里在创建的是子类Son对象，
 * 所以test()执行的是子类重写的代码
 * （面向对象多态）
 */
public class Father {
    private int i = test();
    private static int j = method();

    static {
        System.out.print("(1)");
    }

    Father() {
        System.out.print("(2)");
    }

    {
        System.out.print("(3)");
    }

    public int test() {
        System.out.print("(4)");
        return 1;
    }

    public static int method() {
        System.out.print("(5)");
        return 1;
    }
}