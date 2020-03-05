package cn.sbx0.basedemo;

public class PlusPlus {
    public static void main(String[] args) {
        int i = 1;
        for (int j = 0; j < 100; j++) {
            i = i++;
        }
        int j = i++;
        int k = i + ++i * i++;
        System.out.println("i = " + i);
        System.out.println("j = " + j);
        System.out.println("i = " + k);
    }
}
