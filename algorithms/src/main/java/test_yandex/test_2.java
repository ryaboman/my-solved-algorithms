package test_yandex;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class test_2 {
    public static void main(String[] args) {
        try{
            Scanner in = new Scanner(new File("input.txt"));
            int a = in.nextInt();
            int b = in.nextInt();
            File output = new File("output.txt");
            PrintWriter pw = new PrintWriter(output);
            pw.print(a+b);
            pw.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
}
