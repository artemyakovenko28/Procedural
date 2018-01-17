package _3_memory_in_java;

public class App01x {
    public static void main(String[] args) {
        IntHolder x = new IntHolder(0);
        IntHolder y = x;
        x.value = 1;
        System.out.println("x.value: " + x.value);
        System.out.println("y.value: " + y.value);
    }
}
