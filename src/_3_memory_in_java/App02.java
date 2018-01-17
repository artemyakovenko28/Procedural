package _3_memory_in_java;

import java.util.Arrays;

public class App02 {
    public static void main(String[] args) {
        int[] x = {0, 1, 2};
        int[] y = x;
        x = null;
        System.out.println(Arrays.toString(x));
        System.out.println(Arrays.toString(y));
    }
}
