package _2_dynamic_data_structures.loop_list;

import _2_dynamic_data_structures.Node;

import java.util.Arrays;

public class LoopList {
    public static void main(String[] args) {
        Node list = genRec(0, 1, 2, 3, 4, 5);
        System.out.println(toStringIter(list));
        System.out.println(checkLoop(list));
        Node loopList = setLoop(list);
        System.out.println(checkLoop(loopList));
//        System.out.println(toStringIter(loopList));
    }

    public static boolean checkLoop(Node tail) {
        if (tail == null) {
            return false;
        }

        Node slow = tail;
        Node fast = tail;
        while (true) {
            if (fast.next == null || fast.next.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
    }

    public static Node setLoop(Node tail) {
        if (tail == null) {
            return null;
        }
        Node curr = tail;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = tail;
        return tail;
    }

    public static Node genRec(int... values) {
        if (values.length == 0)
            return null;
        else {
            int[] newArray = Arrays.copyOfRange(values, 1, values.length);
            return new Node(values[0], genRec(newArray));
        }
    }

    public static Node genIter(int... values) {
        Node tail = null;
        for (int k = values.length - 1; k >= 0; k--) {
            tail = new Node(values[k], tail);
        }
        return tail;
    }

    public static String toStringIter(Node tail) {
        String result = "";
        while (tail != null) {
            result += tail.value + " -> ";
            tail = tail.next;
        }
        return result + "null";
    }
}
