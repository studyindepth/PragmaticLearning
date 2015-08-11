package building_blocks;

import java.util.ArrayList;
import java.util.List;

public class MaxThreadsTest {

    public static void main(String... s) {
        int i = 0;
        List<Object> list = new ArrayList<>();
        while (true) {
            list.add(new Thread());
            System.out.println(list.size());
        }
    }
}
