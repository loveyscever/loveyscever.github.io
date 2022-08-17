package com.xf.utils;

import java.util.Random;

public class NumberUtils {

    public static String getNumberbyCoundition(int number) {
        Random random = new Random();
        int num = random.nextInt(number) + 1;
        return num < 10 ? "0" + num : "" + num;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.println(NumberUtils.getNumberbyCoundition(15));
        }
    }
}
