package ru.ryaboman.algorithms.removeDublicates;

public class TestRemiveDublicates {
    //!Привести фразу к виду с отсутствием дубликатов
    public static void main(String[] args) {
        String input = "Привет, ррразрррабооотчикии!!!";
        String result = remiveDublicates(input);
        System.out.println(result);

    }

    private static String remiveDublicates(String input) {
        char[] ch = input.toCharArray();
        StringBuilder builder = new StringBuilder();
        char lastCh = ch[0];
        builder.append(ch[0]);
        for(int index = 1; index < ch.length; index++){
            if(lastCh != ch[index]){
                builder.append(ch[index]);
                lastCh = ch[index];
            }
        }

        return builder.toString();
    }
}
