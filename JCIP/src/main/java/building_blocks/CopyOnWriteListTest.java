package building_blocks;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteListTest {
    public static void main(String[] args) {
        List<String> list = new CopyOnWriteArrayList<>();
        System.out.println(list.hashCode());
        list.add("a");
        System.out.println(list.hashCode());
        list.add("2");
        System.out.println(list.hashCode());
        System.out.println(list.size());
    }
}
