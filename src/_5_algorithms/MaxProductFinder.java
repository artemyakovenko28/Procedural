package _5_algorithms;

public class MaxProductFinder {
    public static void main(String[] args) {
        findMaxProduct(new int[]{5, 3, 6, -9, 10, -3, -4, 2, 1}); // answer = 360
    }

    private static void findMaxProduct(int[] array) {
//        find 2 min elements
        for (int barrier = 0; barrier < 2; barrier++) {
        int indexOfMin = barrier;
            for (int index = barrier + 1; index < array.length; index++) {
                if (array[index] < array[indexOfMin]) {
                    indexOfMin = index;
                }
            }
            if (indexOfMin != barrier) {
                int tmp = array[barrier];
                array[barrier] = array[indexOfMin];
                array[indexOfMin] = tmp;
            }
        }

//        find 3 max elements
        final int length = array.length;
        for (int barrier = length - 1; barrier > length - 4; barrier--) {
            int indexOfMax = barrier;
            for (int index = barrier - 1; index >= 0; index--) {
                if (array[index] > array[indexOfMax]) {
                    indexOfMax = index;
                }
            }
            if (indexOfMax != barrier) {
                int tmp = array[barrier];
                array[barrier] = array[indexOfMax];
                array[indexOfMax] = tmp;
            }
        }

        int firstProduct = array[0] * array[1] * array[length - 1];
        int secondProduct = array[length - 1] * array[length - 2] * array[length - 3];
        System.out.println("Max product = " + Math.max(firstProduct, secondProduct));
    }
}
