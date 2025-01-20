package test_yandex;

import java.io.*;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class test_4 {
    public static void main(String[] args) {
        try{
            Scanner in = new Scanner(new File("input.txt"));
            String J = in.nextLine();
            String S = in.nextLine();
            Set<Character> charSet = new LinkedHashSet<Character>();
            int count = 0;
            for(char c : J.toCharArray()){
                if(charSet.contains(c)){
                    continue;
                }
                charSet.add(c);
                count += S.length() - S.replace(String.valueOf(c), "").length();
            }
            File output = new File("output.txt");
            PrintWriter pw = new PrintWriter(output);
            pw.print(count);
            pw.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
}
