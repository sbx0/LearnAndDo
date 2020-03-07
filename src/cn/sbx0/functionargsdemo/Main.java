package cn.sbx0.functionargsdemo;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int i = 1;
        String str = "hello";
        Integer num = 2;
        int[] arr = {1, 2, 3, 4, 5};
        DataEntity data = new DataEntity();

        change(i, str, num, arr, data);

        System.out.println("i = " + i);
        System.out.println("str = " + str);
        System.out.println("num = " + num);
        System.out.println("arr = " + Arrays.toString(arr));
        System.out.println("data.a = " + data.value);
    }

    public static void change(int j, String s, Integer n, int[] a, DataEntity data) {
        j += 1;
        s += "world";
        n += 1;
        a[0] += 1;
        data.value += 1;
    }
}

class DataEntity {
    int value = 10;
}
