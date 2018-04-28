package _5_algorithms;

import java.util.Arrays;

public class ArrayMerger {
    public static int[] merge(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int aIndex = 0;
        int bIndex = 0;
        while (aIndex != a.length && bIndex != b.length) {
            if (a[aIndex] < b[bIndex]) {
                result[aIndex + bIndex] = a[aIndex++];
            } else {
                result[aIndex + bIndex] = b[bIndex++];
            }
        }
        if (a.length > b.length)
            System.arraycopy(a, aIndex, result, aIndex + bIndex, a.length - b.length);
        else System.arraycopy(b, bIndex, result, aIndex + bIndex, b.length - a.length);
        return result;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 7, 9, 11};
        int[] b = {0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
        int[] c = {0, 2, 4};
        int[] result = merge(a, b);
        result = merge(a, c);
        System.out.println(Arrays.toString(result));
    }
}
