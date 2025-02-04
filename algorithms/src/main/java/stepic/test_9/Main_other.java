package stepic.test_9;

import java.io.*;
import java.util.Locale;
import java.util.Scanner;

public class Main_other {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        double sum = 0.0;
        while (scanner.hasNext()) {
            if (scanner.hasNextDouble()) {
                sum += scanner.nextDouble();
            } else {
                scanner.next();
            }
        }
        System.out.printf(Locale.ENGLISH, "%.6f", sum);
    }
}