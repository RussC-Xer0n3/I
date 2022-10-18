package com.developing821.i;

import java.util.Random;

public class Colours {
    /**
     * Randomly generate an sRGB value in long format using starting point of 150
     * for pastel colours.
     *
     * For use with RadialGradient
     * 
     * @return long - colour
     */
    public static long[] gen () {
        int max = 105;
        int min = 150;
        Random rand = new Random(max);
        long[] colours = new long[0];
        int sum1, sum2, sum3;

        for (int i = 0; i < 2; i++) {
            sum1 = min + rand.nextInt();
            sum2 = min + rand.nextInt();
            sum3 = min + rand.nextInt();
            colours[i] = Long.valueOf(String.valueOf(sum1) + String.valueOf(sum2) + String.valueOf(sum3));
        }

        return colours;
    }
}
