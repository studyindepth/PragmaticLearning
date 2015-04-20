package gscollection;

import com.gs.collections.api.LazyIterable;
import com.gs.collections.api.block.predicate.Predicate;
import com.gs.collections.api.block.procedure.Procedure;
import com.gs.collections.api.list.MutableList;
import com.gs.collections.impl.list.mutable.FastList;

public class GSCollection {
    public static void main(String[] args) {
        MutableList<String> list = new FastList<>();
        list.add("a");
        list.add("b");

        Procedure<String> p = new Procedure<String>() {
            /**
             * 
             */
            private static final long serialVersionUID = 5917254818058856590L;

            @Override
            public void value(String each) {
                System.out.println(each.toUpperCase());
            }
        };
        list.forEach(p);
        LazyIterable<String> lazy = list.asLazy();
        lazy.select(new Predicate<String>() {

            /**
             * 
             */
            private static final long serialVersionUID = -3988336917388785682L;

            @Override
            public boolean accept(String each) {

                return false;
            }
        });
    }
}
