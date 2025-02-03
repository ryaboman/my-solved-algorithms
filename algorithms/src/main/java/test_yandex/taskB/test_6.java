package test_yandex.taskB;

import java.util.*;

public class test_6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int b = in.nextInt();
        int[] arr = new int[n];
        int index_b = -1;
        for (int arr_i = 0; arr_i < n; arr_i++) {
            int x = in.nextInt();
            if (x > b){
                arr[arr_i] = 1;
            }
            else if (x < b){
                arr[arr_i] = -1;
            }
            else {
                index_b = arr_i;
                arr[arr_i] = 0;
            }

        }

        int[] P = new int[n + 1];
        for (int i = 0; i < n; i++) {
            P[i+1] = P[i] + arr[i];
        }

        Map<Integer, Integer[]> map = new HashMap<>();
        for (int i = 0; i <= index_b; i++) {
            int parity = i % 2;
            if (map.containsKey(P[i])) {
                map.get(P[i])[parity]++;
            }
            else {
                Integer[] arrParity = new Integer[2];
                arrParity[0] = 0;
                arrParity[1] = 0;
                arrParity[parity]++;
                map.put(P[i], arrParity);
            }
        }

        int ans = 0;
        for(int i = index_b; i < n; i++){
            int sum = P[i+1];
            int parity = i % 2;
            if (map.containsKey(sum)) {
                ans += map.get(sum)[parity];
            }
        }

        System.out.println(ans);

    }
}
