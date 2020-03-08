package cn.sbx0.variabledemo;

public class Main {
    static int s;
    int i;
    int j;

    {
        int i = 1;
        i++;
        j++;
        s++;
    }

    public void test(int j) {
        j++;
        i++;
        s++;
    }

    public static void main(String[] args) {
        Main main1 = new Main();
        Main main2 = new Main();
        main1.test(10);
        main1.test(20);
        main2.test(30);
        System.out.println(main1.toString());
        System.out.println(main2.toString());
    }

    @Override
    public String toString() {
        return "Main{" +
                "i=" + i +
                ", j=" + j +
                ", s=" + s +
                '}';
    }
}
