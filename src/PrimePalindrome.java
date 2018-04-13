import java.util.ArrayList;
import java.util.List;

public class PrimePalindrome {

    private static final String company = "Prompt link";

    private static List<Integer> findPrimes(int from, int to) {
        List<Integer> primeNumbers = new ArrayList<>();
        boolean[] notPrimes = new boolean[to];
        for (int i = 2; i < to; i++) {
            if (!notPrimes[i]) {
                if (i > from) {
                    primeNumbers.add(i);
                }
                for (int j = i; j < to; j += i) {
                    notPrimes[j] = true;
                }
            }
        }
        return primeNumbers;
    }

    private static void findPalindrome(List<Integer> target) {
        long max = 0;
        int first = 0;
        int second = 0;
        for (int i = 0; i < target.size(); i++) {
            for (int j = 0; j < i; j++) {
                long current = (long) target.get(i) * (long) target.get(j);
                if (current > max && isPalindrome(current)) {
                    max = current;
                    first = i;
                    second = j;
                }
            }
        }
        System.out.printf("result: %s = %s * %s%n", max, first, second);
    }

    private static boolean isPalindrome(long n) {
        long original = n;
        long reverse = 0;

        while (n != 0) {
            long last = n % 10;
            n = n / 10;
            reverse = reverse * 10 + last;
        }

        return original == reverse;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        List<Integer> primes = findPrimes(10_000, 100_000);
        findPalindrome(primes);
        long endTime = System.currentTimeMillis();
        System.out.println("time spent: " + (endTime - startTime));
    }
}
