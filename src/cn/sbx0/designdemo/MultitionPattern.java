package cn.sbx0.designdemo;

import java.util.ArrayList;
import java.util.Random;

public class MultitionPattern {

    public static void main(String[] args) {
        Emperor emperor = Emperor.getInstance();
        System.out.println(emperor);
        Emperor emperor1 = Emperor.getInstance(0);
        System.out.println(emperor1);
        Emperor emperor2 = Emperor.getInstance(1);
        System.out.println(emperor2);
    }

    static class Emperor {
        private static final int maxNumberOfEmperor = 2;
        private static ArrayList emperorInfoList = new ArrayList(maxNumberOfEmperor);
        private static ArrayList emperorList = new ArrayList(maxNumberOfEmperor);

        private static int countNumOfEmperor = 0;

        static {
            for (int i = 0; i < maxNumberOfEmperor; i++) {
                emperorList.add(new Emperor("第" + i + "皇帝"));
            }
        }

        private Emperor() {

        }

        private Emperor(String info) {
            emperorInfoList.add(info);
        }

        public static Emperor getInstance(int num) {
            countNumOfEmperor = num;
            if (num >= 0 && num <= maxNumberOfEmperor) {
                return (Emperor) emperorList.get(num);
            } else {
                System.out.println("error");
                return null;
            }
        }

        public static Emperor getInstance() {
            Random random = new Random();
            countNumOfEmperor = random.nextInt(maxNumberOfEmperor);
            return (Emperor) emperorList.get(countNumOfEmperor);
        }

        @Override
        public String toString() {
            return (String) emperorInfoList.get(countNumOfEmperor);
        }
    }
}
