package _0_sort;

import java.util.Arrays;
import java.util.Random;

public class MergeSort {
    private static int[] sort(int[] array) {
        if (array == null || array.length == 0) return null;

        int mid = array.length / 2;
        int[] left = new int[mid];
        int[] right = new int[array.length - mid];

        System.arraycopy(array, 0, left, 0, mid);
        System.arraycopy(array, mid, right, 0, array.length - mid);

        if (left.length > 2) {
            left = sort(left);
        }
        if (right.length > 2) {
            right = sort(right);
        }

        if (left.length == 2) {
            if (left[0] > left[1]) {
                int temp = left[0];
                left[0] = left[1];
                left[1] = temp;
            }
        }
        if (right.length == 2) {
            if (right[0] > right[1]) {
                int temp = right[0];
                right[0] = right[1];
                right[1] = temp;
            }
        }
        return merge(left, right);
    }

    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];

        int leftIndex = 0;
        int rightIndex = 0;
        int i = 0;
        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] < right[rightIndex]) {
                result[i] = left[leftIndex++];
            } else {
                result[i] = right[rightIndex++];
            }
            i++;
        }

        if (leftIndex < rightIndex) {
            System.arraycopy(left, leftIndex, result, i, left.length - leftIndex);
            return result;
        }
        if (leftIndex > rightIndex) {
            System.arraycopy(right, rightIndex, result, i, right.length - rightIndex);
            return result;
        }

        if (left.length < right.length) {
            System.arraycopy(right, rightIndex, result, i, right.length - rightIndex);
        } else {
            System.arraycopy(left, leftIndex, result, i, left.length - leftIndex);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] array = new int[50];
        Random rnd = new Random();
        for (int i = 0; i < 50; i++) {
            array[i] = rnd.nextInt(50);
        }
        System.out.println(Arrays.toString(sort(array)));
    }
}
