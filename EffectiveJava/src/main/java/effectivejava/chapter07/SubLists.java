package effectivejava.chapter07;

import java.util.List;

import com.google.common.collect.Lists;

public class SubLists {
    public static void main(String[] args) {
        List<String> list = Lists.newArrayList();
        list.add("abc");
        List<String> sub = list.subList(0, 1);
        
        sub.add("2");
        System.out.println(list.size());
        System.out.println(sub.size());
        
        
    }
}
