import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String source = "-)оьуушйх:жч(цпх,хгющ(фйец'шшє-ї-едгю_;ц-рйийц.хжсїецч'я_ь";
        String alphabet = "дежзрстуиіїйклємнопфхцчшщьюя_.+,-()'абвг:;\"";
        List<Character> chars = new ArrayList<>();
        for (char ch : alphabet.toCharArray()) {
            chars.add(ch);
        }
        StringBuilder result = new StringBuilder();

//        String key = "положенняположенняположенняположенняположенняположенняположенняположенняположення";
//        String key = "фахівецьфахівецьфахівецьфахівецьфахівецьфахівецьфахівецьфахівецьфахівецьфахівецьфахівецьфахівець";
//        String key = "підручникпідручникпідручникпідручникпідручникпідручникпідручникпідручникпідручникпідручник";
//        String key = "матеріалиматеріалиматеріалиматеріалиматеріалиматеріалиматеріалиматеріалиматеріалиматеріали";
//        String key = "проблемапроблемапроблемапроблемапроблемапроблемапроблемапроблемапроблемапроблемапроблемапроблема";
//        String key = "спекрспекрспекрспекрспекрспекрспекрспекрспекрспекрспекрспекрспекрспекрспекрспекрспекрспекрспекр";
//        String key = "вітчизнянийвітчизнянийвітчизнянийвітчизнянийвітчизнянийвітчизнянийвітчизнянийвітчизнянийвітчизняний";
//        String key = "першийпершийпершийпершийпершийпершийпершийпершийпершийпершийпершийпершийпершийпершийпершийпершийпершийперший";
        String key = "пропозиціяпропозиціяпропозиціяпропозиціяпропозиціяпропозиціяпропозиціяпропозиціяпропозиціяпропозиціяпропозиція";
        char[] keyChars = key.toCharArray();
        List<Integer> keys = new ArrayList<>();
        for (int i = 0; i < key.length(); i++) {
            keys.add(chars.indexOf(keyChars[i]));
        }

        System.out.println(chars);
        System.out.println(keys);

        char[] sourceChars = source.toCharArray();
        for (int i = 0; i < source.length(); i++) {
            int coded = chars.indexOf(sourceChars[i]);
            if (coded - keys.get(i) >= 0) {
                result.append(chars.get(coded - keys.get(i)));
            }
        }

        System.out.println(result);

    }
}
