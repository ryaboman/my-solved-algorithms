package ru.ryaboman.algorithms.anagram;

import java.util.HashMap;
import java.util.Map;

public class isAnagram {

    public static void main(String[] args) {
        String str1 = "anagram";
        String str2 = "nagaram";

        System.out.println(isAnagram(str1, str2));
    }

    private static Boolean isAnagram(String str1, String str2) {
        if(str1.length() != str2.length()){
            return false;
        }

        Map<Character, Integer> mapCharCount = new HashMap();

        char[] chArrayStr1 = str1.toCharArray();
        char[] chArrayStr2 = str2.toCharArray();

        for(Character ch : chArrayStr1){
            int count = mapCharCount.getOrDefault(ch, 0) + 1;
            mapCharCount.put(ch, count);
        }

        for(Character ch : chArrayStr2){
            if(!mapCharCount.containsKey(ch)){
                return false;
            }
            int count = mapCharCount.get(ch) - 1;
            if(count < 0){
                return false;
            }
            mapCharCount.put(ch, count);
        }

        int sum = 0;

        for(int number : mapCharCount.values()){
            sum += number;
        }

        if(sum == 0){
            return true;
        }

        return false;

    }
}
