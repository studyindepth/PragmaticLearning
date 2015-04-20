package gscollection;

import com.gs.collections.api.bag.Bag;
import com.gs.collections.api.block.predicate.Predicate;
import com.gs.collections.api.block.procedure.Procedure;
import com.gs.collections.impl.bag.immutable.ImmutableArrayBag;

public class BagsTest {
    public static void main(String[] args) {
        Bag<String> bag = ImmutableArrayBag.newBagWith("a", "b", "a");
        Bag<String> bagA = bag.select(new Predicate<String>() {

            /**
             * 
             */
            private static final long serialVersionUID = 1L;

            @Override
            public boolean accept(String each) {
                return each.equals("a");
            }
        });

        bagA.forEach(new Procedure<String>() {

            /**
             * 
             */
            private static final long serialVersionUID = 7074148394147134997L;

            @Override
            public void value(String each) {
                System.out.println(each);
            }

        });
    }
}
