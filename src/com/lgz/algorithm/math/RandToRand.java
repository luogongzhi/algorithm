package com.lgz.algorithm.math;

/**
 * @author lgz
 * @ClassName RandToRand.java
 * @description 随机数
 * @since 2022/04/09 12:05:58
 */
public class RandToRand {

    public static void main(String[] args) {

        int testTimes = 100000000;
/*        int[] counts = new int[8];
        for (int i = 0; i < testTimes; i++) {
            int num = oneToSeven();
            counts[num]++;
        }
        for (int i = 0; i < 8; i++) {
            System.out.println(i + "出现了" + counts[i] + "次");
        }*/

/*
        int count = 0;
        double x = 0.17;

        for (int i = 0; i < testTimes; i++) {
            if (xToPower3() < x) {
                count++;
            }
        }
        System.out.println((double) count / (double) testTimes);
//        System.out.println(Math.pow(x, 3));
        System.out.println((double) 1 - Math.pow((double) 1 - x, 2));*/
    }


    /**
     * [0,x)范围上的数出现概率由原来的 x 调整为 x 平方
     *
     * @return 返回 [0,1) 的一个小数
     */
    public static double xToPower2() {
        return Math.min(Math.random(), Math.random());
    }

    /**
     * [0,x)范围上的数出现概率由原来的 x 调整为 x 三次方
     *
     * @return 返回 [0,1) 的一个小数
     */
    public static double xToPower3() {
        return Math.max(Math.random(), Math.max(Math.random(), Math.random()));
    }

    /**
     * @return 等概率返回1~5
     */
    public static int oneToFive() {
        return (int) (Math.random() * 5) + 1;
    }

    /**
     * @return 等概率返回0和1
     */
    public static int zeroToOne() {
        int ans = 0;
        do {
            ans = oneToFive();
        } while (ans == 3);
        return ans < 3 ? 0 : 1;
    }

    /**
     * @return 等概率返回1~7
     */
    public static int oneToSeven() {
        int ans = 0;
        do {
            ans = (zeroToOne() << 2) + (zeroToOne() << 1) + zeroToOne();
        } while (ans == 7);
        return ans + 1;
    }

}
