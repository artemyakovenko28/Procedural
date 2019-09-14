package _5_algorithms.kindergarten_adventures;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    static int solve(int[] t) {
        int length = t.length;

        // Keeps track of all the intervals that after right-shifting index.
        int[] shifts = new int[length];
        for (int i = 0; i < length; i++) {
            // If the current number is negative or larger than the biggest index, it won't affect the final result.
            int curr = t[i];
            if (curr >= length || curr <= 0) {
                continue;
            }
            // Right shift index i + 1 --> the current index would be n-1 after shifting
            if (curr > i) {
                shifts[i + 1]++;
                if (curr > i + 1) {
                    shifts[i + 1 + length - curr]--;
                }
            } else {
                // There would be two intervals for each curr <= i.
                shifts[0]++;
                shifts[i - curr + 1]--;
                if (i != length - 1) {
                    shifts[i + 1]++;
                }
            }
        }

        System.out.println(Arrays.toString(shifts));
        int sum = 0;
        int max = 0;
        int index = 0;
        for (int i = 0; i < length; i++) {
            sum += shifts[i];
            if (sum > max) {
                max = sum;
                index = i;
            }
        }

        return ++index;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        System.out.println(solve(new int[]{1, 0, 0}));
//        System.out.println(solve(new int[]{0, 1, 5, 3, 0, 2, 1, 3, 5, 1}));
//        System.out.println(solve(new int[]{5, 6, 3, 4, 0, 1, 0, 3, 2, 0, 3, 2}));
        int i = 0;
        System.out.println(++i == i++);
        System.out.println(++i == ++i);
    }
}
