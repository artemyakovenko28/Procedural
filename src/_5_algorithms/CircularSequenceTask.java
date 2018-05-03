package _5_algorithms;

import java.util.ArrayList;
import java.util.List;

public class CircularSequenceTask {
    private static final int LIMIT = 100_000;

    public static void main(String[] args) {
        CircularSequenceTask task = new CircularSequenceTask();

        long startTime3 = System.nanoTime();
        task.findNumbersFromArray(LIMIT);
        long endTime3 = System.nanoTime();
        System.out.println("Spent time for array: " + ((double) (endTime3 - startTime3) / 1_000_000 + " millis"));
        System.out.println();

        long startTime2 = System.nanoTime();
        task.findNumbersFromInvertedList(LIMIT);
        long endTime2 = System.nanoTime();
        System.out.println("Spent time for inverted list: " + ((double) (endTime2 - startTime2) / 1_000_000 + " millis"));
        System.out.println();

        long startTime1 = System.nanoTime();
        task.findNumbersFromList(LIMIT);
        long endTime1 = System.nanoTime();
        System.out.println("Spent time for list: " + ((double) (endTime1 - startTime1) / 1_000_000) + " millis");
        System.out.println();
    }

    private void findNumbersFromList(int limit) {
        List<Integer> numbers = new ArrayList<>(limit - 1);
        for (int i = 1; i < limit; i++) {
            numbers.add(i);
        }

        int counter = 4;
        while (true) {
            for (int i = 0; i < numbers.size(); i++) {
                if (counter == 4) {
                    numbers.remove(i--);
                    counter = 0;
                    if (numbers.size() < 4) {
                        System.out.println(numbers);
                        return;
                    }
                }
                counter++;
            }
        }

    }

    private void findNumbersFromInvertedList(int limit) {
        List<Integer> numbers = new ArrayList<>(limit - 1);
        for (int i = limit - 1; i > 0; i--) {
            numbers.add(i);
        }

        int counter = 4;
        while (true) {
            for (int i = numbers.size() - 1; i >= 0; i--) {
                if (counter == 4) {
                    numbers.remove(i);
                    counter = 0;
                    if (numbers.size() < 4) {
                        System.out.println(numbers);
                        return;
                    }
                }
                counter++;
            }
        }
    }

    private void findNumbersFromArray(int limit) {
        int[] numbers = new int[limit - 1];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }

        int crossedCount = 0;
        int upperBound = limit - 4;
        int counter = 4;
        while (true) {
            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] == 0) {
                    continue;
                }
                if (counter == 4) {
                    numbers[i] = 0;
                    crossedCount++;
                    counter = 0;
                    if (crossedCount >= upperBound) {
                        printResult(numbers);
                        return;
                    }
                }
                counter++;
            }
        }
    }

    private void printResult(int[] array) {
        StringBuilder result = new StringBuilder("[");
        int count = 0;
        for (int number : array) {
            if (number != 0) {
                if (++count < 3) {
                    result.append(number).append(", ");
                } else {
                    result.append(number).append("]");
                    break;
                }
            }
        }
        System.out.println(result);
    }
}
