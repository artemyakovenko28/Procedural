import java.util.ArrayList;

public class PalindromeChecker {

    public static void main(String[] args) {
        System.out.println(isPalindrome("ABBA"));
        System.out.println(isPalindrome("ABA"));
        System.out.println(isPalindrome("NOT A PALINDROME"));

        System.out.println(isPalindrome(45678));
        System.out.println(isPalindrome(12344321));
        System.out.println(isPalindrome(1234321));
    }

    private static boolean isPalindrome(String target) {
        int length = target.length();
        for (int i = 0; i < length / 2; i++) {
            if (target.charAt(i) != target.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isPalindrome(int n) {
        int original = n;
        int reverse = 0;

        while (n != 0) {
            int last = n % 10;
            n = n / 10;
            reverse = reverse * 10 + last;
        }

        return original == reverse;
    }
}
