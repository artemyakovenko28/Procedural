package _3_memory_in_java;

import java.util.Arrays;

public class App40 {
    public static void main(String[] args) {
        int[] x = {0, 1, 2};
        x = f(x);
        System.out.println("x: " + Arrays.toString(x));
    }

    public static int[] f(int[] x) {
        return new int[] {x[0] + 10, x[1] + 10, x[2] + 10};
    }
}
