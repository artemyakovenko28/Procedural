import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Result {
    public static void main(String[] args) {
        Rotor rotor1 = getRotor1();
        Rotor rotor2 = getRotor2();

        String source = "ьруктиьпцв";
        List<Character> sourceChars = new ArrayList<>();
        for (char ch : source.toCharArray()) {
            sourceChars.add(ch);
        }

        List<String> results = decode(sourceChars, rotor1, rotor2);
        for (int i = 0; i < results.size(); i++) {
            System.out.println(i + ": " + results.get(i));
        }
    }

    private static List<String> decode(List<Character> sourceChars, Rotor rotor1, Rotor rotor2) {
        List<String> results = new ArrayList<>();
        int size = rotor1.getChars().size();
        System.out.println("  size = " + size);

        for (int offset0 = 0; offset0 < size; offset0++ ) {
            StringBuilder target = new StringBuilder();

            int offsetCounter = 0;
            System.out.println("  offset0 = " + offset0);
            System.out.println("---------------------------------------");
            for (int i = 0; i < sourceChars.size(); i++) {
                Integer currentOffset = offset0 + offsetCounter;

                System.out.println("s2 = " + sourceChars.get(i));

                Integer rotor2Index = rotor2.getChars().indexOf(sourceChars.get(i));
                Integer rotor2Position = rotor2.getPositions().get(rotor2Index);
                System.out.println("p2 = " + rotor2Position);
                Integer rotor2Contact = rotor2.getContacts().get(rotor2Index);
                System.out.println("c2 = " + rotor2Contact);

//                Integer rotor1Position = (rotor2Contact - currentOffset) % size;
                Integer rotor1Position;
                if (rotor2Contact - currentOffset > 0) {
                    rotor1Position = rotor2Contact - currentOffset;
                } else {
                    rotor1Position = size + (rotor2Contact - currentOffset);
                }

//                System.out.println("  rotor1Position = " + rotor1Position);
                Integer rotor1Index = rotor1.getPositions().indexOf(rotor1Position);
                System.out.println("p1 = " + (rotor1Index + 1));

                Integer positionIndex = rotor1.getPositions().get(rotor1Index);

                Integer rotor1Contact = rotor1.getContacts().get(rotor1Index);
//                System.out.println("rotor1Contact = " + rotor1Contact);
                Integer charIndex = rotor1.getPositions().indexOf(rotor1Contact);

                System.out.println("c1 = " + rotor1.getContacts().get(rotor1.getPositions().indexOf(rotor1Index + 1)));

                System.out.println("s1 = " + rotor1.getChars().get(charIndex));

                target.append(rotor1.getChars().get(charIndex));

                offsetCounter++;
                System.out.println("---");
            }
            System.out.println("---------------------------------------");
            results.add(target.toString());
        }


        return results;
    }

    private static Rotor getRotor1() {
        List<Character> chars = new ArrayList<>(Arrays.asList('а', 'б', 'в', 'г', 'д', 'е', 'є', 'ж', 'з', 'и', 'і', 'ї', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ь', 'ю', 'я', '_'));
        List<Integer> positions = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33));
        List<Integer> contacts = new ArrayList<>(Arrays.asList(17,29,14,4,20,11,33,2,32,16,22,9,6,31,26,15,1,24, 8,23,21,18,7,19,5,28,10,12,3,27,30,25,13));
        return new Rotor(chars, contacts, positions);
    }

    private static Rotor getRotor2() {
        List<Character> chars = new ArrayList<>(Arrays.asList('а', 'б', 'в', 'г', 'д', 'е', 'є', 'ж', 'з', 'и', 'і', 'ї', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ь', 'ю', 'я', '_'));
        List<Integer> positions = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33));
        List<Integer> contacts = new ArrayList<>(Arrays.asList(1,2,25,18,9,27,31,12,19,17,8,14,29,20,26,22,21,24,33,5,32,13,28,3,11,10,15,23,4,16,6,7,30));
        return new Rotor(chars, contacts, positions);
    }
}