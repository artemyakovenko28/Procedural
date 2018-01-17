package _3_memory_in_java;

public class App13x {
    public static void main(String[] args) {
        IntHolder x = new IntHolder(0);
        f(x);
        System.out.println("x.value: " + x.value);
    }

    public static void f(IntHolder x) {
        x = new IntHolder(1);
    }
}
