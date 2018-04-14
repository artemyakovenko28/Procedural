import java.util.ArrayList;
import java.util.List;

public class CircularPrimes {

    private static final int LIMIT = 1_000_000;

    private static List<Integer> findCircularPrimes(int n) {
        List<Integer> circularPrimes = new ArrayList<>();
        List<Integer> primes = PrimeFinder.findPrimesOptimized(n);
        for (int prime : primes) {
            if (isCircularPrime(prime)) {
                circularPrimes.add(prime);
            }
        }
        return circularPrimes;
    }

    private static boolean isPrime(int n) {
        int bound = (int) Math.sqrt(n) + 1;
        for (int i = 2; i < bound; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean isCircularPrime(int n) {
        int rotation = rotate(n);
        while (rotation != n) {
            if (!isPrime(rotation)) {
                return false;
            }
            rotation = rotate(rotation);
        }
        return true;
    }

    private static int rotate(int n) {
        int last = n % 10;
        int remainder = n / 10;
        int digitsCount = countDigits(remainder);
        int result = last * (int) Math.pow(10, digitsCount) + remainder;
        return result;
    }

    private static int countDigits(int n) {
        int count = 0;
        while (n != 0) {
            n /= 10;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(findCircularPrimes(LIMIT));
    }
}
