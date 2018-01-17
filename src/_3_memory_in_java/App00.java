package _3_memory_in_java;

public class App00 {
    public static void main(String[] args) {
        int x = 0;
        int y = x;
        x = 1;
        System.out.println("x: " + x);
        System.out.println("y: " + y);
        /*int - примитивный тип. Примитивный тип передается по значению.
        * Значение х копируется и значения х и у никак между собой не связаны.*/
    }
}
