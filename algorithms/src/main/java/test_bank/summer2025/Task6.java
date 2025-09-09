package test_bank.summer2025;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }

        int result = 0;

        while(true){
            Integer maxValue = Collections.max(list);
            list.remove(maxValue);
            Integer minValue = Collections.min(list);
            list.remove(minValue);

            result += maxValue - minValue;

            if(list.size() < 2){
                break;
            }
        }

        System.out.println(result);

    }
}
