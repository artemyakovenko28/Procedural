package _2_dynamic_data_structures;

import java.util.Arrays;

public class SingleLLUtilsModification {
    public static void main(String[] args) {
        Node emptyList = create();
        Node tail = create(1, 2, 3, 4);
        System.out.println(toString(tail));
        tail = addLastIter(tail, 5);
        System.out.println(toString(tail));
        tail =addLastRec(tail, 6);
        System.out.println(toString(tail));
        tail = insertInPositionIter(tail, 0, 25);
        System.out.println(toString(tail));
        tail = insertInPositionRec(tail, 6, 35);
        System.out.println(toString(tail));
        tail = removeLastIter(tail);
        System.out.println(toString(tail));
        System.out.println(toString(removeLastIter(emptyList)));
        tail = removeLastRec(tail);
        System.out.println(toString(tail));
        System.out.println(toString(removeLastRec(emptyList)));
        tail = removeByIndexIter(tail, 0);
        System.out.println(toString(tail));
        //tail = removeByIndexRec(tail, 6);
        //System.out.println(toString(tail));
    }

    private static Node findLast(Node tail) {
        return (tail.next == null) ? tail : findLast(tail.next);
    }

    private static Node findPenult(Node tail) {
        return (tail.next.next == null) ? tail : findPenult(tail.next);
    }

    private static Node findByIndex(Node tail, int index) {
        return (index == 0) ? tail : findByIndex(tail.next, index - 1);
    }

    public static Node addLastRec(Node tail, int value) {
        Node newElement = new Node(value, null);
        if (tail == null) return newElement;
        else {
            Node last = findLast(tail);
            last.next = newElement;
            return tail;
        }
    }

    public static Node addLastIter(Node tail, int value) {
        Node newElement = new Node(value, null);
        if (tail == null) return newElement;
        else {
            Node firstElement = tail;
            while (tail.next != null) {
                tail = tail.next;
            }
            tail.next = newElement;
            return firstElement;
        }
    }

    public static Node insertInPositionIter(Node tail, int index, int value) {
        Node newElement = new Node(value, null);
        if (tail == null) return newElement;
        if (index == 0) {
            newElement.next = tail;
            return newElement;
        } else {
            Node firstElement = tail;
            for (int position = 0; position < index - 1; position++) {
                tail = tail.next;
            }
            newElement.next = tail.next;
            tail.next = newElement;
            return firstElement;
        }
    }

    public static Node insertInPositionRec(Node tail, int index, int value) {
        Node newElement = new Node (value, null);
        if (tail == null) return newElement;
        if (index == 0) {
            newElement.next = tail;
            return newElement;
        }
        else {
            Node firstElement = tail;
            tail = findByIndex(tail, index - 1);
            newElement.next = tail.next;
            tail.next = newElement;
            return firstElement;
        }
    }

    public static Node removeLastIter(Node tail) {
        if (tail == null) return null;
        else {
            Node firstElement = tail;
            while (tail.next.next != null) {
                tail = tail.next;
            }
            tail.next = null;
            return firstElement;
        }
    }

    public static Node removeLastRec(Node tail) {
        if (tail == null) return null;
        else {
            Node firstElement = tail;
            tail = findPenult(tail);
            tail.next = null;
            return firstElement;
        }
    }

    public static Node removeByIndexIter(Node tail, int index) {
        Node firstElement = tail;
        if (tail == null) return null;
        if (index == 0) {
            tail = tail.next;
            return tail;
        } else {
            for (int position = 0; position < index - 1; position++) {
                tail = tail.next;
            }
            tail.next = tail.next.next;
            return firstElement;
        }
    }

    public static Node removeByIndexRec(Node tail, int index) {
        Node firstElement = tail;
        if (tail == null) return null;
        if (index == 0) {
            tail = tail.next;
            return tail;
        } else {
            findByIndex(tail, index - 1);
            tail.next = tail.next.next;
            return firstElement;
        }
    }

    public static String toString(Node tail) {
        return tail == null ? "*" : tail.value + "->" + toString(tail.next);
    }

    public static Node create(int... values) {
        return values.length == 0 ? null : new Node(values[0],
                create(Arrays.copyOfRange(values, 1, values.length)));
    }
}

