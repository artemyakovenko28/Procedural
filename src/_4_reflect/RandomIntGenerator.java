package _4_reflect;

import java.lang.reflect.Field;
import java.util.Random;

public class RandomIntGenerator {
    public static void main(String[] args) throws IllegalAccessException {
        Point point = new Point(1, 4);

        Field[] fields = Point.class.getDeclaredFields();
        for (Field field : fields) {
            InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
            if (annotation != null) {
                int left = annotation.left();
                int right = annotation.right();
                int randomInt = left + new Random().nextInt(right - left);
                field.setAccessible(true);
                field.set(point, randomInt);
            }
        }

        System.out.println(point);
    }
}