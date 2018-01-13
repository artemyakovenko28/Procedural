package _0_sort;

import java.util.Arrays;

public class InsertionSort {
    public static void insertionSort(int[] array) {
        for (int barrier = 1; barrier < array.length; barrier++) {
            int newElement = array[barrier];
            int location = barrier - 1;
            while (location >= 0 && array[location] > newElement) {
                array[location + 1] = array[location];
                location--;
            }
            array[location + 1] = newElement;
        }
    }

    public static void insertionSortOptimized(int[] array) {
        for (int barrier = 1; barrier < array.length; barrier++) {
            int newElement = array[barrier];
            int location = Arrays.binarySearch(array, 0, barrier, newElement);
            if (location < 0) {
                location = Math.abs(location + 1);
                System.arraycopy(array, location, array, location + 1, barrier - location);
                array[location] = newElement;
            }
        }
    }
    public static void main(String[] args) {
        int[] array = {23, 45, 12, 4, 5, 3, 67, 13, 78};
        //insertionSort(array);
        System.out.println(Arrays.toString(array));
        insertionSortOptimized(array);
        System.out.println(Arrays.toString(array));
    }
}
