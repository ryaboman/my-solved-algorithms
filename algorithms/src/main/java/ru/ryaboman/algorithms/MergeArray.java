package ru.ryaboman.algorithms;

public class MergeArray
{
    public static void main(String[] args) {
        int[] arr = mergeArrays(new int[]{1, 3}, new int[]{0, 1, 2, 5, 6});
        for(var item : arr){
            System.out.print(item);
        }
    }

    public static int[] mergeArrays(int[] a1, int[] a2) {
        int[] newArray = new int[a1.length + a2.length];
        int lastIndex = a1.length + a2.length;
        int indexA1 = 0;
        int indexA2 = 0;
        int index = 0;
        while(index < lastIndex){
            if( (indexA1 < a1.length) && (indexA2 < a2.length) && (a1[indexA1] <= a2[indexA2]) ){
                newArray[index] = a1[indexA1];
                indexA1++;
            }
            else if((indexA1 < a1.length) && (indexA2 < a2.length) && (a1[indexA1] > a2[indexA2]) ){
                newArray[index] = a2[indexA2];
                indexA2++;
            }
            else if(indexA1 < a1.length){
                newArray[index] = a1[indexA1];
                indexA1++;
            }
            else{
                newArray[index] = a2[indexA2];
                indexA2++;
            }
            index++;
        }
        return newArray; // your implementation here
    }
}
