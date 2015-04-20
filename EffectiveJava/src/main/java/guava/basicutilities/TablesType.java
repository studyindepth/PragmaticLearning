package guava.basicutilities;

import java.util.Map;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public class TablesType {
    public int id = 0;
    public void say() {
        
    }
    public static void main(String[] args) {
        //    groupId  member id  role level
        Table<Integer, Integer, Integer> table = HashBasedTable.create();
        table.put(1, 1, 1);
        table.put(1, 2, 11);
        table.put(1, 3, 111);

        table.put(2, 1, 2);
        table.put(2, 2, 22);
        table.put(2, 3, 222);

        table.put(3, 1, 3);
        table.put(3, 2, 33);
        table.put(3, 3, 333);
        Map<Integer, Integer> map1 = table.row(1);
        Map<Integer, Integer> map2 = table.row(2);
        Map<Integer, Integer> map3 = table.row(3);

        System.out.println(map1.get(2));
        System.out.println(map2);
        System.out.println(map3);
    }
}
