package _1_recursion;

public class Main {
    public static int fib (int arg) {
        if (arg == 0) return 1;
        else
            if (arg == 1) return 1;
        else
            return fib(arg - 1) + fib(arg - 2);
        //return arg < 2 ? 1 : fib(arg - 2) + fib(arg - 1);
    }

    public static int factorial (int arg) {
        if (arg == 1) return 1;
        else
            return arg * factorial(arg - 1);
    }

    public static void main(String[] args) {
        System.out.println (fib(6));
        System.out.println(factorial(10));
    }
}
