package tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Sortings {
    public static void main(String[] args) {
        List<StringBuilder> list = new ArrayList<StringBuilder>();
        list.add(new StringBuilder("B"));
        list.add(new StringBuilder("A"));
        list.add(new StringBuilder("C"));
        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list.subList(1, 2));
    }
}
