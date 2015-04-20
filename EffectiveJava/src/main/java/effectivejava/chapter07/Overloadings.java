package effectivejava.chapter07;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Overloadings {

    public static void classify(List<?> l) {
        System.out.println("List");
    }

    public static void classify(Collection<?> l) {
        System.out.println("collection");
    }

    public static void main(String[] args) {
        Collection<?> c = new ArrayList<>();
        classify(c);
    }
}
