package test_bank.summer2025;

import java.util.*;

public class Task2 {
    public static void main(String[] args) {
        int timeToArriveTrain = 0;
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            b[i] = scanner.nextInt();
        }

        int q = scanner.nextInt();
        for (int i = 0; i < q; i++) {
            int ti = scanner.nextInt();
            int di = scanner.nextInt();

            int ai = a[ti-1];
            int bi = b[ti-1];

            if(di <= ai){
                timeToArriveTrain = ai;
            }
            else {
                timeToArriveTrain = ai;
                while (timeToArriveTrain < di) {
                    timeToArriveTrain += bi;
                }
            }

            System.out.println(timeToArriveTrain);
        }

    }
}
