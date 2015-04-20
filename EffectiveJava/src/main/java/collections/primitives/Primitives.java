package collections.primitives;

import gnu.trove.list.array.TIntArrayList;
import gnu.trove.procedure.TIntProcedure;

public class Primitives {
    public static void main(String[] args) {
        TIntArrayList list = new TIntArrayList();
        list.add(1);
        list.add(12);
        TIntProcedure p = new TIntProcedure() {
            @Override
            public boolean execute(int value) {
                System.out.println(value);
                return true;
            }
        };

        list.forEach(p);
    }
}
