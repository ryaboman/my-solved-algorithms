package interview;

import java.util.ArrayList;

public class TestArrayList {
    public static void main(String args[]) {
        ArrayList<String> list = new ArrayList<>();
        String t1 = "test1";
        String t2 = "test2";
        list.add(t1);
        list.add(t2);
        System.out.println(list.size() + ":");
        t1 = "test3";
        list.remove(t1);
        System.out.println(list.size());
        list.remove("test1");
        System.out.println(list.size());
    }
}
