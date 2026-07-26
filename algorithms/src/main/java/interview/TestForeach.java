package interview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestForeach {
    public static void main(String[] args) {
        int arr[] = {2, 5, 6, 3, 4, 8};
        System.out.println(Arrays.toString(twoSum(arr, 21)));
    }


    public static int[] twoSum(int[] arr, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < arr.length; i++){
            int res = target - arr[i];
            if(map.containsKey(res)){
                return new int[] {i, map.get(res)};
            }
            map.put(arr[i], i);

        }
        return new int[]{0, 0};
    }
}
