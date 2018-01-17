package _3_memory_in_java;

public class App40x {
    public static void main(String[] args) {
        IntHolder x = new IntHolder(0);
        x = f(x);
        System.out.println("x.value: " + x.value);
    }

    public static IntHolder f(IntHolder x) {
        return new IntHolder(x.value + 1);
    }
}
