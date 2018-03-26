import java.util.ArrayList;
import java.util.List;

public class PrimeFinder {
    public static void main(String[] args) {
        System.out.println(findPrimes(100));
        System.out.println(findPrimes(200));
    }

    private static List<Integer> findPrimes(int n) {
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
        return primes;
    }

    private static boolean isPrime(int n) {
        for (int i = 2; i < n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
