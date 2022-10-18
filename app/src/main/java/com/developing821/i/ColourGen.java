package com.developing821.i;

import java.util.Random;

public class ColourGen {
    /**
     * Randomly generate an sRGB value in long format using starting point of 150
     * for pastel colours.
     * @return long - colour
     */
    public static long[] gen () {
        int max = 105;
        int min = 150;
        Random rand = new Random(max);
        Integer colour;
        int sum1, sum2, sum3;


        sum1 = min + rand.nextInt();
        sum2 = min + rand.nextInt();
        sum3 = min + rand.nextInt();

        colour = Integer.valueOf(String.valueOf(sum1) + String.valueOf(sum2) + String.valueOf(sum3));
        return new long[]{Long.valueOf(colour)};
    }
}
