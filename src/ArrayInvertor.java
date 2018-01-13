import java.util.Arrays;

public class ArrayInvertor {
    public static void invert(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
    }

    public static void invertOptimized(int[] array) {
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
    }

    public static void invertRec(int[] array, int index) {
        int temp = array[index];
        array[index] = array[array.length - 1 - index];
        array[array.length - 1 - index] = temp;
        if (index != array.length / 2 + 1) {
            invertRec(array, index + 1);
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        invert(array);
        System.out.println(Arrays.toString(array));
        invertOptimized(array);
        System.out.println(Arrays.toString(array));
        invertRec(array, 0);
        System.out.println(Arrays.toString(array));
    }
}
