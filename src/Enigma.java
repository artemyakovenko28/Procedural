import java.util.*;

public class Enigma {

    public static void main(String[] args) {
        List<Integer> firstList = Arrays.asList(17,29,14,4,20,11,33,2,32,16,22,9,6,31,26,15,1,24, 8,23,21,18,7,19,5,28,10,12,3,27,30,25,13);
        List<Integer> secondList = Arrays.asList(1,2,25,18,9,27,31,12,19,17,8,14,29,20,26,22,21,24,33,5,32,13,28,3,11,10,15,23,4,16,6,7,30);

//        System.out.println(first.size());
//        System.out.println(new HashSet<>(first).size());
//
//        System.out.println(second.size());
//        System.out.println(new HashSet<Integer>(second).size());

        List<Integer> result = new ArrayList<>();

        int offset = 7;
        List<Integer> word = Arrays.asList(30, 20, 23, 14, 22, 10, 30, 19, 26, 3);

        for (Integer secondIndex : word) {
            Integer second = secondList.get(secondIndex - 1);
            while (second - offset < 0) {
                second = second + 33;
            }
            int finish = firstList.get(second - offset - 1);
            result.add(finish);
        }
    }
}
