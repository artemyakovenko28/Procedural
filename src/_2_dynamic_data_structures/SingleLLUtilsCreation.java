package _2_dynamic_data_structures;

import java.util.Arrays;

public class SingleLLUtilsCreation {
    public static void main(String[] args) {
        Node tail = genIter(0, 1, 2, 3);
        System.out.println(toStringIter(tail));
        tail = genRecFull(5, 6, 7, 8, 9, 10);
        System.out.println(toStringRec(tail));
    }

    public static Node genIter(int... values) {
        Node tail = null;
        for (int k = values.length - 1; k >= 0; k--) {
            tail = new Node(values[k], tail);
        }
        return tail;
    }

    public static Node genRecFull(int... values) {
        if (values.length == 0) return null;
        else {
            int[] newArray = Arrays.copyOfRange(values, 1, values.length);
            Node next = genRecFull(newArray);
            return new Node(values[0], next);
            //return new Node(values[0], genRecFull(newArray));
        }
    }

    public static Node genRec(int... values) {
        return values.length == 0 ? null : new Node(values[0],
                genRec(Arrays.copyOfRange(values, 1, values.length)));
    }

    public static String toStringIter(Node tail) {
        String result = "";
        while (tail != null) {
            result += tail.value + "->";
            tail = tail.next;
        }
        return result += "*";
    }

    public static String toStringRec(Node tail) {
        if (tail == null) return "*";
        else
            return tail.value + "->" + toStringRec(tail.next);
    }
}

