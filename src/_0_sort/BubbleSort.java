package _0_sort;

import java.util.Arrays;

public class BubbleSort {
    public static void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void bubbleSort(int[] array) {
        for (int barrier = array.length - 1; barrier >= 0; barrier--) {
            for (int index = 0; index < barrier; index++) {
                if (array[index] > array[index + 1]) {
                    int temp = array[index];
                    array[index] = array[index + 1];
                    array[index + 1] = temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] array = new int[10];
        int[] emptyArray = {};
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random() * 10);
        }
//        System.out.println(Arrays.toString(array));
//        sort(array);
//        System.out.println(Arrays.toString(array));
//        System.out.println(Arrays.toString(emptyArray));
//        sort(emptyArray);
//        System.out.println(Arrays.toString(emptyArray));
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
}
