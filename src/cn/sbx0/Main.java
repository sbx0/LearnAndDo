package cn.sbx0;

import cn.sbx0.volatiledemo.VolatileDemo;

public class Main {

    public static void main(String[] args) {
        volatileDemo();
    }

    public static void volatileDemo() {
        VolatileDemo.volatileDontSupportAtomicity();
//        VolatileDemo.volatileVisibility();
    }
}
