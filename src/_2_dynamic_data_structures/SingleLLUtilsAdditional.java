package _2_dynamic_data_structures;

import java.util.Arrays;

public class SingleLLUtilsAdditional {
    public static void main(String[] args) {
        Node tailA = create(10, 20, 30, 40);
        Node tailB = create(15, 15, 25, 35, 45);
        System.out.println(toString(tailA));
        System.out.println(toString(tailB));
        System.out.println(toString(merge(tailA, tailB)));
        Node tailC = copy(tailA);
        System.out.println(toString(tailC));
        System.out.println("isEqual(tailA, tailB) = " + isEqual(tailA, tailB));
        System.out.println("isEqual(tailA, tailC) = " + isEqual(tailA, tailC));
        System.out.println("length(tailA) = " + length(tailA));
        System.out.println("max(tailA) = " + max(tailA));
        System.out.println("sum(tailA) = " + sum(tailA));
        System.out.println("isGrowing(tailA) = " + isGrowing(tailA));
    }

    public static Node merge(Node tailA, Node tailB) {
        if (tailA != null && tailB != null) {
            if (tailA.value < tailB.value) {
                return new Node(tailA.value, merge(tailA.next, tailB));
            } else {
                return new Node(tailB.value, merge(tailB.next, tailA));
            }
        } else {
            return tailA == null ? tailB : tailA;
        }
    }

    public static Node copy(Node tail) {
        if (tail == null) return null;
        else return new Node(tail.value, copy(tail.next));
    }

    public static boolean isEqual(Node tailA, Node tailB) {
        if (tailA != null && tailB != null) {
            return (tailA.value == tailB.value) && isEqual(tailA.next, tailB.next);
        } else return tailA == tailB;
    }

    public static int length(Node tail) {
        return tail == null ? 0 : 1 + length(tail.next);
    }

    public static int max(Node tail) {
        return tail == null ? 0 : Math.max(tail.value, max(tail.next));
    }

    public static int sum(Node tail) {
        return tail == null ? 0 : tail.value + sum(tail.next);
    }

    public static boolean isGrowing(Node tail) {
        return tail.next.next == null ? (tail.value < tail.next.value) :
                (tail.value < tail.next.value) && isGrowing(tail.next);
    }

    public static Node create(int... values) {
        return values.length == 0 ? null : new Node(values[0],
                create(Arrays.copyOfRange(values, 1, values.length)));
    }

    public static String toString(Node tail) {
        return tail == null ? "*" : tail.value + "->" + toString(tail.next);
    }
}

