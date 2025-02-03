package test_yandex.taskA;

import java.io.File;
import java.io.PrintWriter;
import java.util.*;

public class test_5 {
    public static void main(String[] args) {
        char[][] matrix;
        List<String> words = new ArrayList<String>();
        try {
            Scanner in = new Scanner(new File("input.txt"));
            int r = in.nextInt();
            int c = in.nextInt();

            matrix = new char[r][c];
            int i = 0;
            while (in.hasNext()) {
                String row = in.nextLine();
                if (row.length() == 0) {
                    continue;
                }
                words.addAll( Arrays.asList(row.split("#")) );
                matrix[i] = row.toCharArray();
                i++;
            }

            for(int j=0; j < c; j++) {
                char[] col = new char[r];
                for (int k = 0; k < col.length; k++) {
                    col[k] = matrix[k][j];
                }
                String column = new String(col);
                words.addAll(Arrays.asList(column.split("#")));
            }

            Collections.sort(words);

            String search_word = "";
            for(var word : words) {
                if(word.length() >= 2){
                    search_word = word;
                    break;
                }

            }

            File output = new File("output.txt");
            PrintWriter pw = new PrintWriter(output);
            pw.print(search_word);
            pw.close();

        }
        catch (Exception e) {
            e.printStackTrace();
        }



    }
}
