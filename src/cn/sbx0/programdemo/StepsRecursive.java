package cn.sbx0.programdemo;

/**
 * 有N步台阶，一次只能上一步或两步，共有多少种走法？
 */
public class StepsRecursive {
    public static void main(String[] args) {
        System.out.println(go(1));
    }

    public static int go(int n) {
        if (n == 1 || n == 2) return n;
        return go(n - 1) + go(n - 2);
    }
}
