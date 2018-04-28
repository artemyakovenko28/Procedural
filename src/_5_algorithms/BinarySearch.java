package _5_algorithms;

public class BinarySearch {
    public static int binarySearch(int[] array, int key) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = array[mid];

            if (midVal < key)
                low = mid + 1;
            else if (midVal > key)
                high = mid - 1;
            else return mid;
        }
        return -(low + 1);
    }
    public static void main(String[] args) {
        int array[] = {1, 3 , 10, 20, 40, 54, 67, 78, 91, 100};
        System.out.println(binarySearch(array, 0));
    }
}
