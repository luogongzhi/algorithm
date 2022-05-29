package com.lgz.algorithm.bit;

/**
 * @author lgz
 * @ClassName BitArithmetic.java
 * @description BitArithmetic
 * @since 2022/04/03 12:55:29
 */
public class BitArithmetic {

    /**
     * 打印给入数字的指定位信息
     * @param bit 多少位
     * @param num
     */
    public static void printBitNum(int bit, int num) {
        for (int i = bit; i >= 0; i--) {
            System.out.print((num & (1 << i)) == 0 ? "0" : "1");
        }
    }

}
