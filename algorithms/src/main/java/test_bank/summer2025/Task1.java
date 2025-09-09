package test_bank.summer2025;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        char[] chars = s.toCharArray();
        int countOfMismatches = 0;
        for (int i = 0; i < chars.length/2; i++) {
            if (chars[i] != chars[chars.length - 1 - i]) {
                countOfMismatches++;
            }

            if (countOfMismatches == 2){
                System.out.println("NO");
                return;
            }

        }

        System.out.println("YES");
    }
}
