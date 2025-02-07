package stepic.test_13;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> stack = new ArrayDeque<>();
        int index = 0;
        while (scanner.hasNext()) {
            index++;
            if (index%2 != 0){
                scanner.nextInt();
                continue;
            }
            stack.push(scanner.nextInt());
        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop());
            System.out.print(" ");
        }
    }
}
