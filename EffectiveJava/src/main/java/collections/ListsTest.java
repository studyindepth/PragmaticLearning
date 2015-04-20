package collections;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Lists;

public class ListsTest {

    public static void main(String[] args) {
        List<String> list = Lists.newArrayList();

        System.out.println((new ArrayList<String>()).getClass());
    }
}
