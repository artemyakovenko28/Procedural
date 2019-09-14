public class Dashatize {
    public static String dashatize(int num) {
        long target = num;
        target = Math.abs(target);

        StringBuilder result = new StringBuilder();
        boolean prevEven = true;

        if (target == 0) {
            return String.valueOf(0);
        }

        while (target != 0) {
            long last = target % 10;
            target = target / 10;

            if (last % 2 == 1) {
                if (prevEven) {
                    result.append('-');
                }
                result.append(last);
                result.append('-');
                prevEven = false;
            } else {
                result.append(last);
                prevEven = true;
            }
        }

        if (result.charAt(0) == '-') {
            result.deleteCharAt(0);
        }
        result = result.reverse();
        if (result.charAt(0) == '-') {
            result.deleteCharAt(0);
        }
        return result.toString();
    }

    public static void main(String[] args) {
//        System.out.println(dashatize(4567));
//        System.out.println(dashatize(0));
//        System.out.println(dashatize(-1));
//        System.out.println(dashatize(Integer.MAX_VALUE));
        System.out.println(dashatize(Integer.MIN_VALUE));
    }
}
