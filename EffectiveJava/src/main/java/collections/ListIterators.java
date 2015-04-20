package collections;

import java.util.List;
import java.util.ListIterator;

import com.google.common.collect.Lists;


public class ListIterators {
    public static void main(String[] args) {
        List<String> strings = Lists.newArrayList();
        strings.add("a");
        strings.add("b");
      //  ListIterator<String> li = strings.listIterator();
        
        
        for(ListIterator<String> i = strings.listIterator(); i.hasNext();) {
            System.out.println(i.next());
            //i.remove();
            i.set("x");
        }
        
        System.out.println(strings.size());
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
