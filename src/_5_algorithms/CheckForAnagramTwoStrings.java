package _5_algorithms;

import java.util.HashMap;
import java.util.Map;

public class CheckForAnagramTwoStrings {
    public static void main(String[] args) {
        System.out.println(isAnagram("abcdd", "bcdad"));
        System.out.println(isAnagram("qqq", "qqqqqqqqqq"));
    }

    private static boolean isAnagram(String first, String second) {
        if (first.length() != second.length()) {
            return false;
        }

        Map<Character, Integer> firstLetters = countNumberOfLetters(first);
        Map<Character, Integer> secondLetters = countNumberOfLetters(second);

        return firstLetters.equals(secondLetters);
    }

    private static Map<Character, Integer> countNumberOfLetters(String str) {
        Map<Character, Integer> letters = new HashMap<>();
        for (char letter : str.toCharArray()) {
            Integer letterAmount = letters.get(letter);
            if (letterAmount == null) {
                letters.put(letter, 1);
            } else {
                letters.put(letter, ++letterAmount);
            }
        }
        return letters;
    }
}
