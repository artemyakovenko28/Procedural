package _0_sort;

import java.util.Arrays;

public class SelectionSort {
    public static void selectionSort(int[] array) {
        for (int barrier = 0; barrier < array.length - 1; barrier++) {
            int indexOfMinElement = barrier;
            for (int index = barrier + 1; index < array.length; index++) {
                if (array[index] < array[indexOfMinElement]) {
                    indexOfMinElement = index;
                }
            }
            int temp = array[barrier];
            array[barrier] = array[indexOfMinElement];
            array[indexOfMinElement] = temp;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[10];
        int[] customArray = {45, 34, 56, 23, 89};
        for (int i = 0; i < array.length; i++) {
            array[i] =  (int)(Math.random() * 10);
        }
        System.out.println(Arrays.toString(array));
        selectionSort(array);
        System.out.println(Arrays.toString(array));
        selectionSort(customArray);
        System.out.println(Arrays.toString(customArray));
    }
}
