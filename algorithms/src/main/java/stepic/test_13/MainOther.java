package stepic.test_13;

import java.util.*;

public class MainOther {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LinkedList<String> buffer = new LinkedList<>();

        for (int i = 0; in.hasNext(); i++) {
            int el = in.nextInt();

            if (i % 2 != 0) {
                buffer.addFirst(String.valueOf(el));
            }
        }

        System.out.print(String.join(" ", buffer));
    }
}
