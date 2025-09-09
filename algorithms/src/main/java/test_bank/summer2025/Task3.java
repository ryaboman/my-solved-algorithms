package test_bank.summer2025;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            arr[i] = num;

            while (map.containsKey(num)) {
                if (num == 0) {
                    break;
                }
                num /= 2;
            }

            map.put(num, 1);
        }

        System.out.println(map.size());
    }
}
