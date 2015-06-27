package tests;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

public class CustomizedHashSet<E> extends HashSet<E> {

    private int addCount;

    @Override
    public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return super.addAll(c);
    }

    public int getAddCount() {
        return addCount;
    }

    @Override
    public int size() {
        return super.size();
    }

    public static void main(String[] args) {
        CustomizedHashSet<String> customizedHashSet = new CustomizedHashSet<>();
        customizedHashSet.add("e1");
        customizedHashSet.addAll(Arrays.asList("e1", "e2", "e3"));
        System.out.println(customizedHashSet.getAddCount());
        System.out.println(customizedHashSet.size());
    }
}
