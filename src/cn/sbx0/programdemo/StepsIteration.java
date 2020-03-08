package cn.sbx0.programdemo;

/**
 * 有N步台阶，一次只能上一步或两步，共有多少种走法？
 */
public class StepsIteration {
    public static void main(String[] args) {
        System.out.println(go(6));
    }

    public static int go(int n) {
        if (n == 1 || n == 2) return n;
        int one = 2;
        int two = 1;
        int sum = 0;
        for (int i = 3; i <= n; i++) {
            sum = one + two;
            two = one;
            one = sum;
        }
        return sum;
    }
}
