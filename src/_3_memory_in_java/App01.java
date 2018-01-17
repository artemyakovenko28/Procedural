package _3_memory_in_java;

import java.util.Arrays;

public class App01 {
    public static void main(String[] args) {
        int[] x = {0, 1, 2};
        int[] y = x;
        x[0] = 10;
        System.out.println("x: " + Arrays.toString(x));
        System.out.println("y: " + Arrays.toString(y));
    }
}
