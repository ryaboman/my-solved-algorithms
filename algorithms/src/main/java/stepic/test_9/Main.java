package stepic.test_9;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Double sum = 0d;
        while (scanner.hasNext()) {
            String value = scanner.next();
            try {
                sum += Double.parseDouble(value);
            } catch (NumberFormatException e) {
            }
        }

        //System.out.printf("%.6f", sum);
        System.out.format("%.6f", sum);
    }
}
