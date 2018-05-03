package _5_algorithms;

/**
 * Write an algorithm that detects all pairs of integers in the array,
 * sum of which is equal to the specified value.
 */
public class SumOfPairs {
    public static void main(String[] args) {
        // answer (1, 3), (-1, 5), (0, 4)
        int[] array = new int[]{1, -1, 2, 3, 0, -2, -7, 7, 4, -5, 5};
        int value = 4;
        findPairs(array, value);
    }

    /**
     * Finds and prints all pairs of elements in the array,
     * sum of which is equal to the specified value
     * <p>Note: pairs (5, 6) and (6, 5) are equivalent
     * @param array array in which to do a search
     * @param value value of the sum
     */
    private static void findPairs(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if ((array[i] + array[j]) == value) {
                    System.out.println(array[i] + " + " + array[j] + " = " + value);
                }
            }
        }
    }
}
