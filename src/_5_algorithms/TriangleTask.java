package _5_algorithms;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TriangleTask {

    private static final String FILE_NAME = "E:\\JavaStudy\\Procedural\\src\\triangle.txt";

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(FILE_NAME)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}
