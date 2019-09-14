public class BinaryGcd {

    private static long gcd(long a, long b) {
        String result = String.format("a = %d, b = %d", a, b);

        if (b == 0) {
            return a;
        }
        if (a == 0) {
            return b;
        }

        // a and b even
        if ((a & 1) == 0 && (b & 1) == 0) {
            System.out.printf("%s. П ← П:2. a and b even\n", result);
            return gcd(a >> 1, b >> 1) << 1;
        }
        // a is even, b is odd
        else if ((a & 1) == 0) {
            System.out.printf("%s. П ← П:2. a is even, b is odd\n", result);
            return gcd(a >> 1, b);
        }
        // a is odd, b is even
        else if ((b & 1) == 0) {
            System.out.printf("%s. П ← П:2. a is odd, b is even\n", result);
            return gcd(a, b >> 1);
        }
        // a and b odd, a >= b
        else if (a >= b) {
            System.out.printf("%s. Б ← (Б-М):2. a and b odd, a >= b\n", result);
            return gcd((a - b) >> 1, b);
        }
        // a and b odd, a < b
        else {
            System.out.printf("%s. Б ← (Б-М):2. a and b odd, a < b\n", result);
            return gcd(a, (b - a) >> 1);
        }
    }

    public static void main(String[] args) {
        long a = 10390757062L;
        long b = 12848912342L;
        System.out.printf("gcd(%d, %d) = %d\n", a, b, gcd(a, b));

//        System.out.println();
//        System.out.println(10390757062L / 841834);
//        System.out.println(12848912342L / 841834);
    }
}
