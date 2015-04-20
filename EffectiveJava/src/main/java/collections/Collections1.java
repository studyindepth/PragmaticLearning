package collections;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.testng.internal.annotations.Sets;

public class Collections1 {
    public static void main(String[] args) {
        Set<Integer> set = Collections.EMPTY_SET;
        for (Integer integer : set) {
            System.out.println(integer);
        }
 
        Set<Integer> ids = Sets.newHashSet();
        ids.add(2);
        System.out.println(ids.remove(1));
        A a = new A();

    }
}

class A {
    List<String> string;
}
