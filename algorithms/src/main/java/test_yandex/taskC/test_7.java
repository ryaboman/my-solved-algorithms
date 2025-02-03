package test_yandex.taskC;

import java.util.*;

public class test_7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] arr = new int[3][n];

        for (int j = 0; j < 3; j++){
            for (int i = 0; i < n; i++) {
                arr[j][i] = in.nextInt();
            }
        }

        Map<Integer, List<Integer>[]> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[0][i], new List[]{new ArrayList<>(), new ArrayList<>()});
        }

        for (int i = 0; i < n; i++) {
            int x1 = arr[1][i];
            if (map.containsKey(x1)) {
                map.get(x1)[0].add(i);
            }
            int x2 = arr[2][i];
            if (map.containsKey(x2)) {
                map.get(x2)[1].add(i);
            }
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if(ans.contains(i)){
                continue;
            }
            int key = arr[0][i];
            if( map.get(key)[0].size() == 0 || map.get(key)[1].size() == 0 ){
                //System.out.println("null in row i=" + i);
                ans.add(i);

                int valueKey1 = arr[1][i];
                int valueKey2 = arr[2][i];

                if(valueKey1 != key){
                    int indexToRemove = map.get(valueKey1)[0].indexOf(i);
                    map.get(valueKey1)[0].remove(indexToRemove);
                }

                if(valueKey2 != key){
                    int indexToRemove = map.get(valueKey2)[1].indexOf(i);
                    map.get(valueKey2)[1].remove(indexToRemove);;
                }

                if(valueKey1 != key || valueKey2 != key){
                    i = -1;
                }
            }
        }
        System.out.println(ans.size());
    }
}
