package _2_dynamic_data_structures;

public class App01 {
    public static void main(String[] args) {
        Node tail;
        tail = new Node(0, null);
        tail = new Node(1, tail);
        tail = new Node(2, tail);
        tail = new Node(3, tail);
    }
}

